package com.xiaomin.springcloud.service;

import java.util.List;

import com.xiaomin.vo.Dept;

public interface IDeptService {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
