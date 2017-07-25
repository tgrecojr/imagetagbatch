package com.greco.imagetag;



import com.greco.imagetag.model.ObjectKey;
import com.greco.imagetag.repo.ObjectKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;



@SpringBootApplication(scanBasePackages={"com.greco.imagetag.*"})
@PropertySource("file:///Users/tgrecojr/Code/appconfigs/s3imagetagger.properties")
@EnableAutoConfiguration
@EnableCaching
public class ImagetaggingApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ImagetaggingApplication.class, args);

	}

	@Override
	public void run(String[] args) throws Exception {



	}





}
