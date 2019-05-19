package com.jiepi.spring.weather.service;

import com.jiepi.spring.weather.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city-server-eureka")
public interface CityClient {

    @GetMapping("/city/list")
    List<City> listCity();
}