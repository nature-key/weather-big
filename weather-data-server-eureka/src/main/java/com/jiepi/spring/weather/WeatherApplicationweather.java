package com.jiepi.spring.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherApplicationweather {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplicationweather.class, args);
	}

}
