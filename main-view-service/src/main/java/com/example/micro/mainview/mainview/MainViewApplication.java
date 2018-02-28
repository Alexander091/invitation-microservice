package com.example.micro.mainview.mainview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.micro.mainview.mainview.proxy")
@EnableDiscoveryClient
public class MainViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainViewApplication.class, args);
	}
}
