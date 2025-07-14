package com.yaks.emp_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmpManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpManagementServiceApplication.class, args);
	}

}
