package cn.tedu.c3p0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cm.tedu.util.JdcbUtil;

public class TestC3P0 {
	@Test
	public void testSelect() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		//1、创建连接池
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			//2、设置连接数据库的基本信息
//			pool.setDriverClass("com.mysql.cj.jdbc.Driver");
//			pool.setJdbcUrl("jdbc:mysql:///jt_db?characterEncoding=utf-8&serverTimezone=UTC");
//			pool.setUser("root");
//			pool.setPassword("root");
			//3、从连接池里获取一个连接对象
			conn = pool.getConnection();
			//获取传输器
			stat = conn.createStatement();
			String sql = "select * from account";
			//获取到的执行效果
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double money = rs.getDouble("money");
				System.out.println(id + ":" + name + ":" + money);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdcbUtil.close(conn, stat, rs);
		}
	}
}
