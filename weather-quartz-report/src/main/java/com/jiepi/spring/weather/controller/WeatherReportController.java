package com.jiepi.spring.weather.controller;

import com.jiepi.spring.weather.service.CityDataService;
import com.jiepi.spring.weather.service.WeatherDataService;
import com.jiepi.spring.weather.service.WeatherReportService;
import com.jiepi.spring.weather.vo.City;
import com.jiepi.spring.weather.vo.WeatherResponse;
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
    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {

        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }



}
