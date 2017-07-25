package com.greco.imagetag;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages={"com.greco.imagetag.*"})
@PropertySource("file:///Users/tgrecojr/Code/appconfigs/s3imagetagger.properties")
@EnableAutoConfiguration
public class ImagetaggingApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ImagetaggingApplication.class, args);

	}

	@Override
	public void run(String[] args) throws Exception {

		System.out.println("THIS IS MY APPLICATION");

	}


}
