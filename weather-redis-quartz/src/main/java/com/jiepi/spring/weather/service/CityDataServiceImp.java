package com.jiepi.spring.weather.service;

import com.jiepi.spring.weather.util.XmlBuilder;
import com.jiepi.spring.weather.vo.City;
import com.jiepi.spring.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImp implements CityDataService {


    @Override
    public List<City> listCity() throws Exception {
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        System.out.println(sb.toString());
        CityList cityList = (CityList) XmlBuilder.xmlStrToObjec(CityList.class, sb.toString());
        return cityList.getCityList();
    }
}
