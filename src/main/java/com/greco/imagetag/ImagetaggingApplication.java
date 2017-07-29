package com.greco.imagetag;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication(scanBasePackages={"com.greco.imagetag.*"})
@EnableAutoConfiguration
@EnableCaching
public class ImagetaggingApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {

		SpringApplication.run(ImagetaggingApplication.class, args);

	}

	@Override
	public void run(String[] args) throws Exception {

		logger.info("STARTING APPLICATION");

	}





}
