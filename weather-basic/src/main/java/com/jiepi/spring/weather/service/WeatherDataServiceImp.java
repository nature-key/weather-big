package com.jiepi.spring.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiepi.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class WeatherDataServiceImp implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeahter(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeahter(uri);
    }

    private WeatherResponse doGetWeahter(String url) {
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        String strBody = null;
        if (entity.getStatusCodeValue() == 200) {
            strBody = entity.getBody();

        }
        try {

            weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }


}
