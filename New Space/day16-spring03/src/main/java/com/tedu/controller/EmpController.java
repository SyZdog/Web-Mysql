package com.tedu.controller;
import org.junit.Test;

import com.tedu.factory.BeanFactory;
import com.tedu.service.EmpService;
import com.tedu.service.EmpServiceImpl;
/**
 * 模拟表现层 
 * controller --> service --> dao
 */
public class EmpController {
	/* 获取Service接口的子类实例
	 * ——这里使用new对象的方式造成了程序之间的耦合性提升 */
	private EmpService service = (EmpService) BeanFactory.getBean("EmpService");
	
	@Test
	public void testAddEmp() {
		System.out.println("调用service层的方法添加员工信息...");
		service.addEmp();
	}
}


