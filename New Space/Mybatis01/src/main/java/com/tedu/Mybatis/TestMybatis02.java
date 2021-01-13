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

public class TestMybatis02 {
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
	 * 新增员工信息：刘德华 歌手 8888
	 * */
	@Test
	public void insert() {
		//执行sql语句，返回执行结果
		int rows = session.update("EmpMapper.insert");
		System.out.println("影响行数：" + rows);
	}
	//修改员工信息，将刘德华的job更改为演员
	@Test
	public void testUpdate() {
		int rows = session.update("EmpMapper.update");
		System.out.println("影响行数：" + rows);
	}
	//删除姓名为刘德华的员工
	@Test
	public void testDelete() {
		int rows = session.update("EmpMapper.delete");
		System.out.println("影响行数：" + rows);
	}
	//================使用占位符的方式
	//查询员工信息
	@Test
	public void testFindById() {
		Integer id = 1;
		Emp emp = session.selectOne("EmpMapper.findById", id);
		System.out.println(emp);
	}
	//添加员工信息
	@Test
	public void testInsert2() {
		//参数存入map中
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "张飞");
//		map.put("job", "保安");
//		map.put("salary", 1500);
		//也可以将要传输的参数封装的Emp对象中
		Emp emp = new Emp();
		emp.setName("关羽");
		emp.setJob("java高级程序员");
		int rows = session.update("EmpMapper.insert2", emp);
		System.out.println("影响行数：" + rows);
	}
	//修改员工信息：张飞 架构师 25000
	@Test
	public void testUpadate2() {
		Emp emp = new Emp();
		emp.setName("张飞");
		emp.setJob("架构师");
		emp.setSalary(25000.0);
		int rows = session.update("EmpMapper.update2",emp);
		System.out.println("影响行数：" + rows);
	}
	//查询指定的列的数据
	@Test
	public void testFindAll2() {
		Map map =new HashMap();
		map.put("cols", "name,job");
		List<Emp> list = session.selectList("EmpMapper.findAll2", map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//根据name模糊查询表记录emp表记录(${})
	@Test
	public void testFindAll3() {
		Map map = new HashMap();
		map.put("name", "刘");
		List<Emp> list = session.selectList("EmpMapper.findAll3", map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//根据name模糊查询表记录emp表记录(#{})
	@Test
	public void testFindAll4() {
		 Map map = new HashMap();
		 map.put("name", "%刘%");
		 List<Emp> list = session.selectList("EmpMapper.findAll4", map);
		 for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	
}
