package com.jiepi.spring.weather.service;


import com.jiepi.spring.weather.vo.City;
import com.jiepi.spring.weather.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "weather-eureka-client-zuul",fallback = DataServerHystrix.class)
public interface DataClient {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/city/list")
    List<City> listCity() throws Exception;

    /**
     * 根据城市ID查询天气数据
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
