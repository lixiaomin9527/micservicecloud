package com.xiaomin.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

public class Dept implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long deptNo;
	private String dName;
	private String dbSource;
	public Long getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getDbSource() {
		return dbSource;
	}
	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}
	
	
}
