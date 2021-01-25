package com.tedu.controller;
/**
 * 模拟表现层 
 * controller --> service --> dao
 *//* 获取Service接口的子类实例
 * ——这里使用new对象的方式造成了程序之间的耦合性提升 */

import org.junit.Test;

import com.tedu.service.EmpService;
import com.tedu.service.EmpServiceImpl;

public class EmpController {
	private EmpService service = new EmpServiceImpl();
	@Test
	public void testAddEmp() {
		System.out.println("调用service层的方法添加员工信息...");
		service.addEmp();
	}
}
