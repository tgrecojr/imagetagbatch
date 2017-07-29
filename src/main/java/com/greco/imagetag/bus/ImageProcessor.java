package com.greco.imagetag.bus;

import com.amazonaws.services.rekognition.model.Label;
import com.greco.imagetag.aws.AWSConnector;
import com.greco.imagetag.model.DetectedLabel;
import com.greco.imagetag.model.ObjectKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.amazonaws.services.s3.model.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ImageProcessor {

    @Autowired
    AWSConnector awsConnector;
    @Autowired
    ObjectKeyManager objectKeyManager;
    @Value("${aws.rekognition.allowedextensions}")
    private String allowedRekognitionImageTypes;
    @Value("${aws.rekognition.maxlabels}")
    private int rekognitionMaxLabels;
    @Value("${aws.rekognition.minconfidence}")
    private float rekognitionMinConfidence;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void processImages(String s3Bucket){

        logger.info("Getting objectKeys for bucket " + s3Bucket);
        ArrayList<String> objectKeysInBucket = awsConnector.getS3ObjectKeysForBucket(s3Bucket);
        logger.info("Found " + objectKeysInBucket.size() + " objects in S3 bucket " + s3Bucket);
        for (String image : objectKeysInBucket) {
            if(imageShouldBeProcessed(image)){
                logger.info("Processing Image: " + image);
                ObjectKey ok = new ObjectKey(s3Bucket,image);
                List<Label> returnedLabels = awsConnector.getRekognitionLabels(s3Bucket,image,rekognitionMaxLabels,rekognitionMinConfidence);
                ArrayList<DetectedLabel>detectedLabels = new ArrayList<DetectedLabel>();
                List<Tag> s3Tags = new ArrayList<>();
                for (Label label : returnedLabels) {
                    //s3Tags.add(new Tag(label.getName(), label.getConfidence().toString()));
                    logger.info("Detected Label: " + label.getName() + ", confidence: " + label.getConfidence());
                    DetectedLabel dl = new DetectedLabel(label.getName(),label.getConfidence());
                    detectedLabels.add(dl);
                    s3Tags.add(new Tag(label.getName(), label.getConfidence().toString()));
                }
                ok.setDetectedLabels(detectedLabels);
                awsConnector.tagS3Object(s3Bucket,image,s3Tags);
                objectKeyManager.saveObjectKeyAndLabels(ok);
            }else{
                logger.warn("Skipping Image: " + image);
            }

        }


    }

    protected boolean imageShouldBeProcessed(String image){
        boolean shouldBeProcessed = false;
        int dotLocation = image.lastIndexOf(".") + 1;
        String extension = image.substring(dotLocation, image.length());
        if(getAllowedRekognitionTypes(allowedRekognitionImageTypes).contains(extension)){
            shouldBeProcessed = true;
        }
        return shouldBeProcessed;
    }

    @Cacheable("allowedtypes")
    protected List getAllowedRekognitionTypes(String listOfImageExtensions){
        List<String> items = Arrays.asList(allowedRekognitionImageTypes.split(","));
        return items;
    }



}
