package com.test.testcasedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TestcasedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestcasedemoApplication.class, args);
	}

}
