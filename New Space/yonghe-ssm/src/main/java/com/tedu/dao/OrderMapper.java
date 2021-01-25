package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Order;

public interface OrderMapper {
	//查询订单表中的所有信息
	public List<Order> findAll();
	//根据ID删除订单信息
	public void deleteById(Integer id);
	//新增订单信息
	public void add(Order order);
	//根据ID查询订单信息
	public Order findById(Integer id);
	//根据ID修改订单信息
	public void updateById(Order order);

}
