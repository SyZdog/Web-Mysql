package com.tedu.controller;

import java.util.List;

import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Door;
import com.tedu.pojo.Order;

@Controller
public class OrderController {
	/*
	 * @Autowired:自动装配
	 * 
	 * */
	/** 自动装配：由spring自动为属性赋值(对象)  */
	@Autowired
	private OrderMapper mapper;
	@Autowired
	private DoorMapper doorMapper;
	/*
	 * 查询所有的订单信息
	 * */
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		//1.调用OrderMapper中的findAll()去查询订单信息
		List<Order> list = mapper.findAll();
		//2.将所有的订单信息存入model中，代入JSP
		model.addAttribute("list", list);
		//查询所有的门店信息
		List<Door> dList = doorMapper.findAll();
		model.addAttribute("dList", dList);
		//跳转到订单列表页面
		return "order_list";
	}
	/*查询所有的门店信息，将门店信息代入到订单的新增页面显示*/
	@RequestMapping("/toOrderAdd")
	public String toOrderAdd(Model model) {
		List<Door> dList = doorMapper.findAll();
		model.addAttribute("dList", dList);
		return "order_add";
	}
	/*
	 * 新增订单信息
	 * */
	@RequestMapping("/orderAdd")
	public String orderadd(Order order) {
		//调用OrderMapper的新增订单方法，新增一条订单信息
		mapper.add(order);
		//跳转到查询所有订单的方法orderList，去显示最新的丁订单信息
		return "forward:/orderList";
	}
	/*
	 * 根据ID删除订单信息
	 * */
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		//调用OrderMapper中根据id删除订单信息
		mapper.deleteById(id);
		//删除订单信息后更新，然后跳转到查询所有订单的方法，然后显示最新的订单信息
		return "forward:/orderList";
		
	}
	
	/*
	 * 根据id查询订单的信息
	 * */
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer id,Model model) {
		//调用OrderMapper接口的findById方法，根据查询订单信息
		Order order = mapper.findById(id);
		//将订单信息保存到Model中
		 model.addAttribute("order", order);
		 //查询所有的门店信息，将所有的门店信息存入到Model域中
		 List<Door> dList = doorMapper.findAll();
		 model.addAttribute("dList", dList);
		 //跳转到订单修改页面，回显原有订单信息
		return "order_update";
		
	}
	/*
	 * 根据ID更新订单信息
	 * */
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order) {
		//调用OrderMapper的修改订单信息的方法，根据ID进行修改
		mapper.updateById(order);
		//修改完后更新，然后跳转到带查询所有的订单信息，显示最新的订单信息
		return "forward:/orderList";
		
	}
	
}
