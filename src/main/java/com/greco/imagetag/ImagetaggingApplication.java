package com.greco.imagetag;


import com.greco.imagetag.bus.ImageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication(scanBasePackages={"com.greco.imagetag.*"})
@EnableAutoConfiguration
@EnableCaching
public class ImagetaggingApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${aws.s3.bucket}")
	private String amazonS3Bucket;


	@Autowired
	ImageProcessor imageProcessor;
	public static void main(String[] args) {

		SpringApplication.run(ImagetaggingApplication.class, args);

	}

	@Override
	public void run(String[] args) throws Exception {

		long startTime = System.currentTimeMillis();
		logger.info("STARTING APPLICATION");
		imageProcessor.processImages(amazonS3Bucket);
		long totalTime = System.currentTimeMillis() - startTime;
		logger.info("Finished processing images in " + totalTime/1000 + " seconds");

	}





}
