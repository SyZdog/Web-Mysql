package com.tedu.spring;
//测试spring的IOC（控制反转）

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.dao.EmpDao;
import com.tedu.pojo.Person;
import com.tedu.pojo.User;
import com.tedu.service.EmpService;

public class TestSpring {
	//获取spring容器对象
	private static ClassPathXmlApplicationContext ac = null;
	static {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testIOC() {
		//在Spring容器中获取对象
		EmpService service = (EmpService) ac.getBean("empService");
		System.out.println(service);
		EmpDao dao = (EmpDao) ac.getBean("empDao");
		System.out.println(dao);
		User user = (User) ac.getBean("user");
		System.out.println(user);
		Person person = (Person) ac.getBean("person");
		System.out.println(person);
	}
	//测试Spring中配置Bean实例时是单例还是多例
	/*
	 * 单实例：spring容器从始至终只会为该类创建一个实例，每次获取的实例都是第一次
	 * 创建的实例
	 * 优点：更加的节省资源和内存
	 * 缺点：因为多个线程获取的是同一个对象，当多线程同时对这个对象中的变量进行操作时，
	 * 可能会出现线程安全问题
	 * 在没有线程安全的前提下，就可以选择单实例
	 * 多实例：spring容器每次都会为该类创建一个新的实例，每次获取的都是不同的实例
	 * 优点：因为每一个线程获取的都是不同的对象，访问的也是不同的对象，因此不会出现
	 * 线程安全问题
	 * 缺点：会耗费资源和内存
	 * 在有线程安全的情况下，选择多实例
	 * */
	@Test
	public void testIOC2() {
		//通过spring容器对象获取user的对象/实例
		User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		if (u1 == u2) {
			System.out.println("当前类的实例是单实例");
		}else {
			System.out.println("当前类的实例是多实例");
		}
	}
	/*
	 * 测试springDI(依赖注入）
	 * 1.set方法注入：是通过对象的setXxx()给对象的xxx属性进行赋值
	 * 		在property标签的name属性上去指定你要赋值的那个属性的属性名
	 * 
	 * 2.构造方法注入：通过对象的有参构造给对象赋值
	 * 		在constructor-arg标签的name属性上指定的值要和全参构造方法里的形参的值一致
	 * */
	@Test
	public void testDI() {
		//通过spring容器对象获取User对象
		User u = (User) ac.getBean("user");
		System.out.println(u);
	}
}
