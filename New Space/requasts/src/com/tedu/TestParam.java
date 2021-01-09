package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//这行代码是为了防止中文乱码而设置的
		response.setContentType("text/html;charset=utf-8");
		//通过response获取一个输出流（这个流可以向浏览器发送数据）
		PrintWriter Out = response.getWriter();
		//处理POST提交的中文参数的乱码问题（只针对POST提交有效）
		request.setCharacterEncoding("utf-8");
		//获取请求中携带的数据
		String user =request.getParameter("user");
		System.out.println("user:"+user);
		String pwd = request.getParameter("pwd");
		System.out.println("pwd:"+pwd);
		Out.write("TestParam...");
		/*System.out.println("===============");
		//练习：获取注册表单中的参数
		//获取用户名：username
		String username = request.getParameter("username");
		System.out.println("username:"+username);
		//获取密码：pwd
		String password=request.getParameter("pwd");
		System.out.println("pwd:"+password);
		//获取性别：gender
		String gender = request.getParameter("gender");
		System.out.println("gender:"+gender);
		//获取爱好：like
		String[] likes = request.getParameterValues("like");
		System.out.println(Arrays.toString(likes));
		//获取城市：city
		String city = request.getParameter("city");
		System.out.println("city:"+city);
		//获取描述：description
		String description = request.getParameter("description");
		System.out.println("desc:"+description);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

