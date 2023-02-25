package com.example.L07springbootmvcannotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L07SpringBootMvcAnnotationsApplication {

	private static Logger logger = LoggerFactory.getLogger(L07SpringBootMvcAnnotationsApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(L07SpringBootMvcAnnotationsApplication.class, args);
		logger.error("This is error log");
		logger.warn("This is warn log");
		logger.info("This is info log");
		logger.debug("This is debug log");
		logger.trace("This is trace log");

	}

}
