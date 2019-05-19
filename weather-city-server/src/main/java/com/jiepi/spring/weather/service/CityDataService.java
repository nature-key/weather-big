package com.jiepi.spring.weather.service;

import com.jiepi.spring.weather.vo.City;

import java.util.List;

public interface CityDataService {


    List<City> listCity() throws  Exception;
}
