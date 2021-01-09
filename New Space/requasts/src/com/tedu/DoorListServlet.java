package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//这行代码是为了防止中文乱码而设置的
		response.setContentType("text/html;charset=utf-8");
		//通过response获取一个输出流（这个流可以向浏览器发送数据）
		PrintWriter Out = response.getWriter();
		//1.模拟查询数据库，查询所有门店集合
		List<String> doorList = new ArrayList<String>();
		doorList.add("01, 永和北三环西路店, 010-67676767");
		doorList.add("02, 永和西直门店, 010-68976347");
		doorList.add("03, 永和东直门店, 010-78397647");
		doorList.add("04, 永和北京西店, 010-78764397");
		doorList.add("05, 永和天安门店, 010-78769743");
		//2.将数据存入request域中
		request.setAttribute("list", doorList);
		//3.将请求转发到 doorList.jsp 中, 取出所有门店显示在页面中
		request.getRequestDispatcher("doorList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
