package com.example.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterceptorApplication.class, args);
	}

}
