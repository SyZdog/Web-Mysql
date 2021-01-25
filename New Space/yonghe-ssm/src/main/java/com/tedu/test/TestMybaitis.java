package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

public class TestMybaitis {
	public static void main(String[] args) throws Exception {
		//1.读取mybatis-config.xml核心文件
		InputStream in = Resources.getResourceAsStream(
				"mybatis/mybatis-config.xml");
		//2.获取SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取SqlSession对象
		SqlSession session = factory.openSession();

		//4.获取DoorMapper接口的实例
		DoorMapper mapper = session.getMapper(DoorMapper.class);
		//5.调用findAll方法查询所有门店信息
		List<Door> list = mapper.findAll();
		//6.遍历所有门店信息
		for(Door door : list){
			System.out.println(door);
		}

	}
}
