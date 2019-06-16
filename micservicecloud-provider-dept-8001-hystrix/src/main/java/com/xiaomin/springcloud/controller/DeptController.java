package com.xiaomin.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaomin.springcloud.service.IDeptService;
import com.xiaomin.vo.Dept;

@RestController
public class DeptController {

	@Autowired
	private IDeptService deptService;
	
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return deptService.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "exceptionFallBack_Get")
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept = deptService.get(id);
		if (null == dept) {
			throw new RuntimeException("信息不存在");
		}
		return deptService.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return deptService.list();
	}
	
	public Dept exceptionFallBack_Get(Long id) {
		Dept dept = new Dept();
		dept.setDeptNo(id);
		dept.setdName("id不存在，或已删除");
		dept.setDbSource("dbSource is empty");
		return dept;
	}

}
