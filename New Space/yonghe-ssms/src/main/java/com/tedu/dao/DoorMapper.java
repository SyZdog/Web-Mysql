package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

public interface DoorMapper {
	/**
	 * 1.查询所有门店信息
	 * @return List<Door>
	 */
	/* 1.Mapper接口的全路径名要和mapper文件的
	 *	namespace保持一致
	 * 2.Mapper接口中方法的名字要和sql标签的id值
	 *	保持一致
	 * 3.Mapper接口中方法的返回值类型和参数类型
	 *	要和sql标签的返回值类型以及参数类型保持一致
	 */
	public List<Door> findAll();
	
	/**
	 * 2.根据id删除门店信息
	 * @param id
	 */
	public void deleteById(Integer id);
	
	/**
	 * 3.添加门店信息
	 * @param door
	 */
	public void addDoor(Door door);
	
	/**
	 * 4.根据id查询门店信息
	 * @param id
	 * @return
	 */
	public Door findById(Integer id);
	
	/**
	 * 5.根据id修改门店信息
	 * @param door
	 */
	public void updateById(Door door);

	
}
