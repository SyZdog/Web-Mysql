package com.tedu.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import cm.tedu.util.JdcbUtil;

public class LoginUser2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请登录");
		System.out.print("请输入用户名：");
		String user = sc.nextLine();
		System.out.print("请输入密码：");
		String pwd = sc.nextLine();
		login(user,pwd);
	}
	private static void login(String user, String pwd) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			conn = JdcbUtil.getConn();
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			System.out.println(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("登录成功！");
			}else {
				System.out.println("登录失败，用户名或密码错误！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdcbUtil.close(conn, ps, rs);
		}
	}
}
