package com.pojo;

import java.util.Date;

public class Department {

	private Integer id;
	private String departmentName;
	private Date saveTime;

	public Date getSaveTime() {
		return new Date();
	}

	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}

	//未与数据库关联，演示日期格式
	private Date myDate;

	public Date getMyDate() {
		return new Date();
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public Department() {
	}
	
	public Department(int i, String string) {
		this.id = i;
		this.departmentName = string;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
	}
	
}
