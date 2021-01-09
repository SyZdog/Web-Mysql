package com.tedu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.pojo.User;

public class TestSpring {
	@Test
	public void testSpring(){
		//1.加载Spring的核心配置文件
		ClassPathXmlApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"spring/applicationContext.xml");
		//2.获取bean实例
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
}
