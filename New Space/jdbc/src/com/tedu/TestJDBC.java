package com.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			//1.注册数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取数据库连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8&serverTimezone=UTC", "root", "root");
			//3.获取传输器
		    state = conn.createStatement();
			//4.发送sql到服务器执行并返回结果
			String sql = "select * from account";
			 rs = state.executeQuery(sql);
			//5.处理结果
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
			//6.释放资源
			if(rs != null) {
				
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					rs = null;
				}
			}
			if (state != null) {
				try {
					state.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					state = null;
				}
			}
			if (conn != null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
			
		}
			
	}

}
