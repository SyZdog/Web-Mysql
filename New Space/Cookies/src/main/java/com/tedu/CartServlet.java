package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 处理响应中文乱码
		* 这行代码会通知浏览器使用utf-8接收服务器响应的数据
		* 服务器也会使用相同的码表发送数据给浏览器 */
		response.setContentType("text/html;charset=utf-8");
		//通过response获取一个输出流（这个流可以向浏览器发送数据）
		PrintWriter Out = response.getWriter();
		//========================================
		//1.获取商品信息
		String prodName = request.getParameter("prod");
		//2.创建Cookie对象,将商品信息保存到Cookie中
		Cookie cookie = new Cookie("cart", URLEncoder.encode(prodName, "utf-8"));
		//设置Cookie的生命周期，单位：秒
		cookie.setMaxAge(60*60*24*30);
		//3.将Cookie保存到响应信息中，发送给浏览器
		response.addCookie(cookie);
		//4.做出回应
		Out.write("已将"+prodName+"加入到购物车");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

