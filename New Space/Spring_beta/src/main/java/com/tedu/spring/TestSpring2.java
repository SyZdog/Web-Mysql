package com.tedu.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.pojo.User;

public class TestSpring2 {
	private static ClassPathXmlApplicationContext ac = null;
	static {
		 ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testDI1() {
		User u1 = (User) ac.getBean("user");
		System.out.println(u1);
	}
	
}
