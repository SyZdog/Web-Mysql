package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

@Controller
public class DoorController {
	/*
	 * @Autowired:自动装配
	 * 
	 * */
	/** 自动装配：由spring自动为属性赋值(对象)  */
	@Autowired
	private DoorMapper mapper;
	
	/*
	 * 通用页面的跳转方法
	 * */
	@RequestMapping("/{page}")
	public String toJSP(@PathVariable String page) {
		return page;
	}
	/*
	 * 查询所有的门店信息
	 * */
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		//1.调用DoorMapper中的findAll()去查询门店信息
		List<Door> list = mapper.findAll();
		//2.将所有的门店信息存入model中，代入JSP
		model.addAttribute("list", list);
		return "door_list";
	}
	/*
	 * 根据ID删除门店信息
	 * */
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id) {
		//调用DoorMapper中根据id删除门店信息
		mapper.deleteById(id);
		//删除门店信息后更新，然后跳转到查询所有门店的方法，然后显示最新的门店信息
		return "forward:/doorList";
		
	}
	/*新增门店信息*/
	@RequestMapping("/doorAdd")
	public String doorAdd(Door door) {
		mapper.add(door);
		return "forward:/doorList";
	}
	/*
	 * 根据id查询门店的信息
	 * */
	@RequestMapping("/doorInfo")
	public String doorInfo(Integer id,Model model) {
		//调用DoorMapper接口的findById方法，根据查询门店信息
		Door door = mapper.findById(id);
		//将门店信息保存到Model中
		 model.addAttribute("door", door);
		 //跳转到门店修改页面，回显原有门店信息
		return "door_update";
		
	}
	/*
	 * 根据ID更新门店信息
	 * */
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door) {
		//调用DoorMapper的修改门店信息的方法，根据ID进行修改
		mapper.updateById(door);
		//修改完后更新，然后跳转到带查询所有的门店信息，显示最新的门店信息
		return "forward:/doorList";
		
	}
	/*
	 * 整合springmvc框架
	 * */
	@RequestMapping("/test")
	public String testSpringmvc(){
		System.out.println("TestSsm.testSpringMvc");
		return "test";
	}

	//测试ssm开发环境
	@RequestMapping("/ssm")
	public String  testSSM() {
		//1.调用findAll方法查询所有门店信息
		List<Door> list = mapper.findAll();
		//2.遍历门店信息
		for (Door door : list) {
			System.out.println(door);
		}
		return "test";
	}
}
