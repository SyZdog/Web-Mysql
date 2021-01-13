package com.tedu.Mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.pojo.Emp;

public class TestMybatis01 {
	@Test
	public void findAll() throws IOException {
		//1.读取mybatis的核心配置文件（mybatis-config.xml)
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		//2.通过配置信息获取一个SqlSessionFactory工厂对象
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build( in );
		//3.通过工厂获取SqlSession对象
		//如果默认是false表示需要手动提交事务，true表示自动提交
		SqlSession session = fac.openSession(true);
		//4.执行sql语句（EmpMapper.xml)，接收处理后的结果
		List<Emp> list = session.selectList("EmpMapper.findAll");
		//5.输出结果
		for(Emp e : list) {
			System.out.println( e );
		}
	}
}
