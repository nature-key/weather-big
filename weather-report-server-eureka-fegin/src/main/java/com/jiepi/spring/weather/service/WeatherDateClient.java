package com.jiepi.spring.weather.service;

import com.jiepi.spring.weather.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("weather-data-server-eureka")
public interface WeatherDateClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);
}
