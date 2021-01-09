package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 处理响应中文乱码
		* 这行代码会通知浏览器使用utf-8接收服务器响应的数据
		* 服务器也会使用相同的码表发送数据给浏览器 */
		response.setContentType("text/html;charset=utf-8");
		//通过response获取一个输出流（这个流可以向浏览器发送数据）
		PrintWriter Out = response.getWriter();
		//1.获取一个session对象
		HttpSession session = request.getSession();
		//2.从session中获取要结算的商品信息
		Object prodName = session.getAttribute("cart");
		//3.对商品开始结算，作出响应
		Out.write("成功为"+prodName+"支付了2000元");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
