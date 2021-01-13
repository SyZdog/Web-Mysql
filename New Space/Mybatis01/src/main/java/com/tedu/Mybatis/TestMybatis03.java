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

import com.tedu.pojo.Emp;

public class TestMybatis03 {
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
	/**
	 * 练习12: 根据薪资查询员工信息
 		* 如果参数有 minSal、maxSal, 则
 		* ... where salary > minSal and salary < maxSal
 		* 如果参数中只有minSal, 则
 		* ... where salary > minSal 
 		* 如果参数中只有maxSal, 则
 		* ... where salary < maxSal
 		* 如果没有参数, 则不执行where子句, 默认查询所有员工
	 * */
	@Test
	public void testFindAllBysal() {
		//1.将参数封装到map集合中
		Map map = new HashMap();
		map.put("minSal", 3000);
		map.put("maxSal", 5000);
		List<Emp> list = session.selectList("EmpMapper.findAllBySal",map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//根据薪资查询员工信息
	@Test
	public void testFindAllBysal2() {
		//1.将参数封装到map集合中
		Map map = new HashMap();
		map.put("minSal", 3000);
		map.put("maxSal", 5000);
		List<Emp> list = session.selectList("EmpMapper.findAllBySal2",map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//根据员工的id批量删除员工信息
	@Test
	public void testDeleteByIds() {
		Integer[] ids = {1,3,5,7};
		int rows = session.update("EmpMapper.deleteByIds",ids);
		System.out.println("影响行数为："+rows);
	}
	//根据员工的id批量更新员工信息，将id为2，4，6，8的员工薪资
	//在原有基础上增加1000
	@Test
	public void testUpdateByIds() {
		Integer[] ids = {2,4,6,8};
		Map map = new HashMap();
		map.put("sal", 1000);
		map.put("arrIds", ids);
		int rows = session.update("EmpMapper.updateByIds",map);
		System.out.println("影响行数为："+rows);
	}
}
