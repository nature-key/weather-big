package com.jiepi.spring.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherApplicationcity {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplicationcity.class, args);
	}

}