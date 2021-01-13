package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Emp;

/**
 * Mapper接口
 * */
public interface EmpMapper {
	//查询所有的员工信息
	public List<Emp> findAll();
}
