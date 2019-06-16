package com.xiaomin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class micservicecloudZuul9527_App {

	public static void main(String[] args) {
		SpringApplication.run(micservicecloudZuul9527_App.class, args);
	}

}
