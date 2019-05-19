package com.jiepi.spring.weather.controller;

import com.jiepi.spring.weather.service.DataClient;
import com.jiepi.spring.weather.service.WeatherReportService;
import com.jiepi.spring.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Weather Controller.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月22日
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherReportService.class);
    @Autowired
    private WeatherReportService weatherReportService;

    //    @Autowired
//    private CityDataService cityDataService;
//    @Autowired
//    private CityClient cityClient;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {

        // 获取城市ID列表
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;

        try {
            // TODO 改为由城市数据API微服务提供数据
            cityList= dataClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }


}
