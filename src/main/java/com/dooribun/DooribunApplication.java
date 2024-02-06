package com.dooribun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DooribunApplication {

	public static void main(String[] args) {
		SpringApplication.run(DooribunApplication.class, args);
	}

}
