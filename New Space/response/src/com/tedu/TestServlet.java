package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 处理响应中文乱码
		* 这行代码会通知浏览器使用utf-8接收服务器响应的数据
		* 服务器也会使用相同的码表发送数据给浏览器 */
		response.setContentType("text/html;charset=utf-8");
		//通过response获取一个输出流（这个流可以向浏览器发送数据）
		//response第一个作用：可以响应客户端
		PrintWriter Out = response.getWriter();
		Out.write("hello");
		//response第二个作用：实现重定向
		//===========测试冲定向=======
		//测试1：从TestServlet重定向到response项目下的test.jsp
		//重定向前的路径：http://localhost/response/TestServlet
		//重定向后的路径：http://localhost/response/test.jsp
		//response.sendRedirect("test.jsp");
		//response.sendRedirect("http://localhost/response/test.jsp");
		//测试2：从TestServlet重定向到requests项目下的test.jsp
		//response.sendRedirect("http://localhost/requasts/test.jsp");
		//测试3：从TestServlet重定向到百度首页
		response.sendRedirect("http://www.baidu.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

