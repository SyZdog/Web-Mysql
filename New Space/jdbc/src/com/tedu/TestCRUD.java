package com.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cm.tedu.util.JdcbUtil;

public class TestCRUD {
	//新增
		@Test
		public void testInsert() {
			Connection conn = null;
			Statement state =null;
			ResultSet rs=null;
			try {
				conn = JdcbUtil.getConn();
				//获取传输器
				state = conn.createStatement();
				//发送sql到服务器执行，并返回结果
				String sql = "insert into account values(null,'tom',3900)";
				int rows = state.executeUpdate(sql);
				System.out.println("影响行数"+rows);
				//处理结果
				//资源释放
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdcbUtil.close(conn,state,rs);
			}
		}
		//修改
		@Test
		public void testUpdate(){
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = JdcbUtil.getConn();
				//获取传输器
				stat = conn.createStatement();
				//执行sql语句，并返回结果
				String sql = "update account set money=1500 where name='ton'";
				int rows = stat.executeUpdate(sql);
				System.out.println("影响的行数" + rows);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdcbUtil.close(conn, stat, rs);
			}
		}
		//删除
		@Test
		public void testDelete() {
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = JdcbUtil.getConn();
				stat = conn.createStatement();
				String sql = "delete from account where id=8";
				int rows = stat.executeUpdate(sql);
				System.out.println("影响的行数" + rows);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdcbUtil.close(conn, stat, rs);
			}
		}
		
		//查询
		@Test
		public void testSelect() {
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = JdcbUtil.getConn();
				stat = conn.createStatement();
				String sql = "select * from account";
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


