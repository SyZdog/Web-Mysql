package com.tedu.factory;
/*
 * Bean:在计算机语言中，可以重用的组件
 * JavaBean:使用Java语言/程序编写的可重用组件，例如：service/dao/pojo
 * JavaBean:通常分为业务Bean和实体Bean
 * 业务Bean:处理业务逻辑，service层，dao层
 * 实体Bean:封装数据，例如pojo，Emp
 * 
 * 解除耦合：
 * 1.提供配置文件（config.properties)：xml（标签），properties（key=value)，在配置文件中配置
 * service和dao的实现类
 * 配置内容：key（接口唯一）=value（实现类的全限定名）
 * 			EmpService=com.tedu.service.EmpServiceImpl
 * 			EmpDao=com.tedu.dao.EmpDaoImpl
 * 2.通过工厂读取配置文件中的全限定名，利用反射创建类的实例（对象）
 * */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
	//Properties对象的作用：可以用来读取配置文件（config.properties）
	private static Properties prop = null;
	static {
		try {
			//为prop进行实例化
			prop = new Properties();
			//通过类加载器去加载这个配置文件
			ClassLoader classLoader = BeanFactory.class.getClassLoader();
			//通过类加载器去加载配置文件
			InputStream in = classLoader.getResourceAsStream("config.properties");
			//将配置信息读取到Properties对象中
			prop.load(in);
			//System.out.println(prop.getProperty("EmpService"));//通过key去获取value
			//System.out.println(prop.getProperty("EmpDao"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("初始化Properties对象失败！");
		}
	}
	//根据配置信息中的key来获取value（实现类的全类限定名），然后利用反射来创建实例/对象
	public static Object getBean(String key) {
		Object obj = null;
		try {
			//1.获取当前接口对应的全类限定名
			String className = prop.getProperty(key);
			//2.利用反射技术然后去获取实例
			obj = Class.forName(className).newInstance();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
		
	}
}
