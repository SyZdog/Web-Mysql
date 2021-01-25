package com.tedu.pojo;

public class Door {
	private Integer id;	//门店编号
	private String name;	//门店名称
	private String tel;	//门店电话
	private String addr;	//门店地址
	public Door(){}
	public Door(Integer id, String name, String tel, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Door [id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
}
