package com.xiaomin.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaomin.vo.Dept;

@FeignClient(value = "MICSERVICECLOUD-DEPT", fallbackFactory = DeptHystrixService.class)
public interface DeptFeignService {

	@PostMapping("/dept/add")
	public boolean add(Dept dept);

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") int id);

	@GetMapping("/dept/list")
	public List<Dept> list();
}
