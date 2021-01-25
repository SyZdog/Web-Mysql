package com.tedu.dao;

import java.util.List;
import java.util.Map;

import com.tedu.pojo.Emp;

/**
 * Mapper接口
 * */
public interface EmpMapper {
	//查询所有的员工信息
	public List<Emp> findAll();
	//增加员工
	public int insert(Map map);
	//修改信息
	public int update(Emp emp);
	//删除id为2的员工
	public int delete(Integer id);
}
