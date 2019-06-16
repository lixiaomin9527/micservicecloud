package com.xiaomin.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xiaomin.springcloud.service.DeptFeignService;
import com.xiaomin.vo.Dept;

@RestController
public class DeptController_Consumer {

	@Autowired
	private DeptFeignService deptFeignService;
	
	@PostMapping("/consumer/add")
	public boolean add(Dept dept) {
		return deptFeignService.add(dept);
	}
	
	@GetMapping("/consumer/get/{id}")
	public Dept get(@PathVariable("id") int id) {
		return deptFeignService.get(id);
	}
	
	@GetMapping("/consumer/list")
	public List<Dept> list(){
		return deptFeignService.list();
	}
}
