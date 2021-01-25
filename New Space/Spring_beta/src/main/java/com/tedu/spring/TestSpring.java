package com.tedu.spring;
/**
 * 使用spring的IOC解决程序中的耦合问题
 */

import java.applet.AppletContext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.dao.EmpDao;
import com.tedu.service.EmpService;

public class TestSpring {
	@Test
	public void textIOC() {
		//获取spring的核心容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过spring的核心容器获取EmpService接口的子类实例
		EmpService service = (EmpService) ac.getBean("empService");
		EmpDao dao = (EmpDao) ac.getBean("empDao");
		System.out.println(service);
		System.out.println(dao);
	}
}
