package com.xiaomin.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xiaomin.vo.Dept;

@RestController
public class DeptController_Consumer {

//	private static final String URL_PREFIXX = "http://localhost:8001";
	private static final String URL_PREFIXX = "http://MICSERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/consumer/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(URL_PREFIXX + "/dept/add", dept, boolean.class);
	}
	
	@GetMapping("/consumer/get/{id}")
	public Dept get(@PathVariable("id") int id) {
		return restTemplate.getForObject(URL_PREFIXX + "/dept/get/" + id, Dept.class);
	}
	
	@GetMapping("/consumer/list")
	public List<Dept> list(){
		return restTemplate.getForObject(URL_PREFIXX + "/dept/list", List.class);
	}
}
