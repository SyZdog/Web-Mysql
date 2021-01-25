package com.tedu.pojo;
/**
 * 实体类,用于封装Emp表中的一条用户信息
 */
public class Emp {
	
	//1.声明实体类中的属性
	private Integer id;
	private String name;
	private String job;
	private Double salary;
	
	//2.提供对应的getter和setter方法
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	//3.重写toString方法
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}
	
	
	
}
