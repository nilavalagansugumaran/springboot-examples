package com.example.samleRestClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SamleRestClientApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SamleRestClientApplication.class, args);

		context.getBean(MyClientComponent.class).invokeService();
	}

}
