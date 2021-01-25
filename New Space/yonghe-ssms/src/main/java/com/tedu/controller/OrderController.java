package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.pojo.Order;
import com.tedu.service.DoorService;
import com.tedu.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private DoorService doorService;
	@Autowired
	private OrderService orderService;
	
	/** 1.查询所有订单信息 */
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		//1.查询所有门店信息(List<Door>)
		List<Door> doorList = doorService.findAll();
		//2.将门店集合存入model,带到jsp
		model.addAttribute("doorList", doorList);
		//3.查询所有订单信息(List<Order>)
		List<Order> orderList = 
					orderService.findAll();
		//4.将订单集合存入model,带到jsp
		model.addAttribute("orderList", orderList);
		System.out.println(doorList);
		System.out.println(orderList);
		
		//转向订单列表页面
		return "order_list";
	}
	
	/** 2.查询所有门店并跳转到订单新增页面 */
	@RequestMapping("/toAddOrder")
	public String toAddOrder(Model model) {
		//1.查询所有门店信息
		List<Door> doorList = doorService.findAll();
		//2.带到订单新增页面取出并显示
		model.addAttribute("list", doorList);
		return "order_add";
	}
	
	/** 3.新增订单 */
	@RequestMapping("orderAdd")
	public String orderAdd(Order order) {
		//调用service层的方法新增订单
		orderService.addOrder(order);
		//重定向到查询所有订单的方法
		return "redirect:/orderList";
	}
	
	/** 4.根据id删除订单信息 */
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		//调用service的根据id删除订单的方法
		orderService.deleteById(id);
		//转向查询所有订单的方法
		return "redirect:/orderList";
	}
	
	/** 5.1.修改：根据id查询订单信息，将订单
	 * 信息带到订单修改页面进行数据的回显 */
	@RequestMapping("/orderInfo")
	public String orderInfo(
			Model model,Integer id) {
		//0.查询所有门店的集合
		List<Door> doorList = doorService.findAll();
		//0.将所有门店集合存入model中
		model.addAttribute("doorList", doorList);
		
		//1.调用service层的根据id查询订单的方法
		Order order = orderService.findById(id);
		//2.将订单对象存入model中
		model.addAttribute("order", order);
		return "order_update";
	}
	
	/** 5.2.修改：根据id修改订单信息 */
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order) {
		//调用service的根据ID修改订单的方法
		orderService.updateById(order);
		//转向订单列表页面
		return "redirect:/orderList";
	}
	
	
	
}






