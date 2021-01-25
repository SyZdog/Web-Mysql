package com.tedu.pojo;
//用于封装用户信息
public class User {
	private String name;
	private Integer age;
	private UserInfo info;//自定义的包装类型
	//提供无参构造方法
	public User(){}
	//提供有参构造方法
	public User(String name, Integer age, UserInfo info) {
		super();
		this.name = name;
		this.age = age;
		this.info = info;
	}
	//提供get和set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public UserInfo getInfo() {
		return info;
	}
	public void setInfo(UserInfo info) {
		this.info = info;
	}
	//提供toString()方法
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", info=" + info + "]";
	}
	
}
