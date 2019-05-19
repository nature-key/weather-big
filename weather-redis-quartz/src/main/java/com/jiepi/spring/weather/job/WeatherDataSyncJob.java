package com.jiepi.spring.weather.job;


import com.jiepi.spring.weather.service.CityDataService;
import com.jiepi.spring.weather.service.CityDataServiceImp;
import com.jiepi.spring.weather.service.WeatherDataService;
import com.jiepi.spring.weather.vo.City;
import com.jiepi.spring.weather.vo.WeatherResponse;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("quartz");
        List<City> cities = null;
        try {
            cities = cityDataService.listCity();
            cities.forEach(it -> {
                logger.info("cityId{}", it.getCityId());
                weatherDataService.syncDataByCityId(it.getCityId());
            });

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("end");
    }
}
