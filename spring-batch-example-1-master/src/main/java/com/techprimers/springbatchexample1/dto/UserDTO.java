package com.techprimers.springbatchexample1.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is the class which we construct after understanding the V4 Connect API response 
 * @author abharsa
 */
@Entity
public class UserDTO {
	@Id
	private Integer id;
    private String name;
    private String dept;
    private Integer salary;
    private Date time;

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", time=" + time
				+ "]";
	}
}
