package com.xiaomin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 启动客户端注册到eurka
public class DeptProvider8001_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}
