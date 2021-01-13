package com.tedu.Mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.dao.EmpMapper;
import com.tedu.pojo.Emp;

public class TestMybatis04 {
	private static SqlSession session = null;
	static{
			try {	
				//1.读取mybatis的核心配置文件（mybatis-config.xml)
				InputStream in = Resources.getResourceAsStream("mybatis-config.xml");	
				//2.通过配置信息获取一个SqlSessionFactory工厂对象
				SqlSessionFactory fac = new SqlSessionFactoryBuilder().build( in );
				//3.通过工厂获取SqlSession对象
				//默认是false，表示需要手动提交事务，true表示自动提交事务
				session = fac.openSession(true);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//=====================Mapper接口开发=======================
	//查询员工信息
	@Test
	public void testFindAll() {
		//1.获取EmpMapper接口的字节码对象
		EmpMapper mapper = session.getMapper(EmpMapper.class);//EmpMapper接口的实例
		//2.调用findAll()
		List<Emp> list = mapper.findAll();
		//3.遍历
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	
}