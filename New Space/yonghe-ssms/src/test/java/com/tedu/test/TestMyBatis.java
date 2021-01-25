package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

public class TestMyBatis {
	
	@Test
	public void testFindAll() throws Exception{
		//0.加载mybatis核心配置文件, 读取所有配置信息
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		//1.创建工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//2.通过工厂创建一个SqlSession对象
		SqlSession session = factory.openSession();
		//3.获取Mapper接口对象
		DoorMapper map = session.getMapper(DoorMapper.class);
		//4.调用接口对象的方法进行查询
		List<Door> list = map.findAll();
		//5.输出结果
		for (Door door:list) {
			System.out.println(door);
		}
		
	}
	
}
