package com.jiepi.spring.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

	@Test
	public void contextLoads() {
		int i=0;
		while (true){
			System.out.println("输出"+i++);
		}
	}

}