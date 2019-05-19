package com.jiepi.eureka.eurekaclient.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city-server-eureka")
public interface CityClient {

    @GetMapping("/city/list")
    String listCity();
}
