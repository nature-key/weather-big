package com.jiepi.spring.weather.service;

import com.jiepi.spring.weather.vo.Weather;

public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
