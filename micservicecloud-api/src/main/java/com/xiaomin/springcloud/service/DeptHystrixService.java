package com.xiaomin.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xiaomin.vo.Dept;

import feign.hystrix.FallbackFactory;

/**
 * 客户端（服务降级）
 * @author 李晓敏
 *
 */
@Component
public class DeptHystrixService implements FallbackFactory<DeptFeignService> {

	@Override
	public DeptFeignService create(Throwable cause) {
		return new DeptFeignService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(int id) {
				Dept dept = new Dept();
				dept.setdName("服务已关闭");
				return dept;
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
