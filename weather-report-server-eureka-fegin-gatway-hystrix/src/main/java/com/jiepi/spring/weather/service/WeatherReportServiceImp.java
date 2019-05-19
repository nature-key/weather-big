package com.jiepi.spring.weather.service;

import com.jiepi.spring.weather.vo.Forecast;
import com.jiepi.spring.weather.vo.Weather;
import com.jiepi.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImp implements WeatherReportService {


    //    @Autowired
//    private WeatherDataService weatherDataService;
    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {


        // TODO 改为由天气数据API微服务来提供
        WeatherResponse weatherByCityId = dataClient.getDataByCityId(cityId);
        return weatherByCityId.getData();
    }
}
