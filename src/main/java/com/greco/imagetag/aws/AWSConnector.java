package com.greco.imagetag.aws;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AWSConnector implements InitializingBean{

    @Value("${aws.profile}")
    private String amazonProfileName;
    @Value("${aws.region}")
    private String amazonRegionName;
    private AmazonS3 s3Client;
    private AmazonRekognition rekognitionClient;


    @Override
    public void afterPropertiesSet() throws Exception {
        AmazonS3Client.builder();
        s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(amazonRegionName)
                .withCredentials(new ProfileCredentialsProvider(amazonProfileName))
                .build();
        rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withRegion(amazonRegionName)
                .withCredentials(new ProfileCredentialsProvider(amazonProfileName))
                .build();

    }

}
