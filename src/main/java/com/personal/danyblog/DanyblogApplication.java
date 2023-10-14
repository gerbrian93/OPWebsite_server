package com.personal.danyblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class DanyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanyblogApplication.class, args);
	}

}
