package com.jiepi.spring.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiepi.spring.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImp implements WeatherDataService {

    private final static Logger logger= LoggerFactory.getLogger(WeatherDataServiceImp.class);
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final long TIME_OUT=10000l;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
        WeatherResponse weatherResponse = null;
        String strBody = null;
        ObjectMapper  mapper = new ObjectMapper();
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        if (stringRedisTemplate.hasKey(url)) {
            logger.info("redis has data");
            strBody = operations.get(url);
        } else {
            logger.info("redis no date");
            ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

            if (entity.getStatusCodeValue() == 200) {
                strBody = entity.getBody();
            }
            operations.set(url,strBody,TIME_OUT, TimeUnit.SECONDS);
        }
        try {

            weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("异常{}",e.getMessage());
        }
        return weatherResponse;
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 保存数据---Redis
     * @param url
     */
    private void saveWeatherData(String url){
        String key = null;
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String strBody=null;

        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

        if (entity.getStatusCodeValue() == 200) {
            strBody = entity.getBody();
        }
        operations.set(url,strBody,TIME_OUT, TimeUnit.SECONDS);

    }

}
