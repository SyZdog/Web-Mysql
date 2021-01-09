package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//这行代码是为了防止中文乱码而设置的
		response.setContentType("text/html;charset=utf-8");
		//通过response获取一个输出流（这个流可以向浏览器发送数据）
		PrintWriter Out = response.getWriter();
		
		//===================将请求从A转发到B======
		//转发前往request对象的map集合中存入一个数据
		request.setAttribute("name", "刘德华");
		/*
		 * AServlet:http://localhost/requasts/AServlet
		 * BServlet:http://localhost/requasts/BServlet
		 * 相对路径
		 */
		System.out.println("AServlet.doGet()...");
		request.getRequestDispatcher("BServlet").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

