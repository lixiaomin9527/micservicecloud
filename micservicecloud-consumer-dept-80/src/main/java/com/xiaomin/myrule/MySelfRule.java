package com.xiaomin.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

/**
 * 
 * 自定义负载均衡计算方式
 * @author 李晓敏
 *
 */
@Configuration
public class MySelfRule {

	@Bean
	public IRule getRule() {
		return new RoundRule_XM();
	}
}
