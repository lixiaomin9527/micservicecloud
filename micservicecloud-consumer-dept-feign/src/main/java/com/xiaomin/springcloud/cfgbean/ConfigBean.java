package com.xiaomin.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 配置类（相当于applicationContext.xml）
 * @author 李晓敏
 *
 */
@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced // 使用负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	// 重写负载均衡方式
//	@Bean
//	public IRule getRole() {
//		// RandomRule 随机访问
//		return new RandomRule();
//	}
}
