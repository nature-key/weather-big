package com.jiepi.eureka.eurekaclient.controller;


import com.jiepi.eureka.eurekaclient.server.CityClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cityList")
    @HystrixCommand(fallbackMethod = "defaultCityList")
    public String getCityList() {
        String listCity = cityClient.listCity();
        return listCity;
    }

    public String defaultCityList(){
        return  "city server fail";
    }

}
