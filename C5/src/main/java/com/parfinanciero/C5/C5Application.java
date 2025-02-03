package com.parfinanciero.C5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class 	C5Application {

	public static void main(String[] args) {
		SpringApplication.run(C5Application.class, args);
	}

}
