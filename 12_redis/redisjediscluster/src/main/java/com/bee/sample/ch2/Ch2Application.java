package com.bee.sample.ch2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch2Application {
    private static final Logger LOGGER    = LoggerFactory.getLogger(Ch2Application.class);
	public static void main(String[] args) {
		LOGGER.debug(" >>>>> Rdetail is");  
		SpringApplication.run(Ch2Application.class, args);

	}

}
