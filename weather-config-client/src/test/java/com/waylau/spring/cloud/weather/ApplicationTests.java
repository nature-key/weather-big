package com.waylau.spring.cloud.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Value("${auther}")
	private String auther;

	@Test
	public void contextLoads() {
		System.out.println("==============================================");
		System.out.println(auther);
	}
}
