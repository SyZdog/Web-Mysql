package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

public interface DoorMapper {
	//查询门店表中的所有信息
	public List<Door> findAll();
	//根据ID删除门店信息
	public void deleteById(Integer id);
	//新增门店信息
	public void add(Door door);
	//根据ID查询门店信息
	public Door findById(Integer id);
	//根据ID修改门店信息
	public void updateById(Door door);

}
