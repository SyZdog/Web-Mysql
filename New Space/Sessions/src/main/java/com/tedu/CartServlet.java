package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//1.获取要加入购物车的商品信息
		String prodName = request.getParameter("prod");
		//2.创建（获取）一个session，将商品保存到session
		HttpSession session = request.getSession();
		session.setAttribute("cart", prodName);
		//3.作出响应
		Out.write("成功将"+prodName+"加入到购物车中");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

