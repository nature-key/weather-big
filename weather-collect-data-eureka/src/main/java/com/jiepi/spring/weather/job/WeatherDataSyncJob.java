package com.jiepi.spring.weather.job;

import com.jiepi.spring.weather.service.WeatherDataCollectionService;
import com.jiepi.spring.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);


    @Autowired
   private WeatherDataCollectionService weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("quartz");
        List<City> cities = new ArrayList<>();
        try {
            City city = new City();
            city.setCityId("101280601");
            cities.add(city);
            cities.forEach(it -> {
                logger.info("cityId{}", it.getCityId());
               weatherDataCollectionService.syncDateByCityId(it.getCityId());
            });

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("end");
    }
}
