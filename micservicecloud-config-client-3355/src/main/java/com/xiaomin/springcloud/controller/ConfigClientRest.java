package com.xiaomin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String appname;
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaService;
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/config")
	public String getConfig() {
		String str = "applicationName:" + appname + ",eurekaService:" + eurekaService + ",port:" + port;
		System.out.println(str);
		return str;
	}
}
