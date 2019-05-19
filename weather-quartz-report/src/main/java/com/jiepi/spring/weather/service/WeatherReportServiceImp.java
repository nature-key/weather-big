package com.jiepi.spring.weather.service;

import com.jiepi.spring.weather.vo.Weather;
import com.jiepi.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImp  implements WeatherReportService{


    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse response = weatherDataService.getDataByCityId(cityId);
        return response.getData();
    }
}
