package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayCooki extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 处理响应中文乱码
		* 这行代码会通知浏览器使用utf-8接收服务器响应的数据
		* 服务器也会使用相同的码表发送数据给浏览器 */
		response.setContentType("text/html;charset=utf-8");
		//通过response获取一个输出流（这个流可以向浏览器发送数据）
		PrintWriter Out = response.getWriter();
		//=============================================
		//1.获取请求中的所有的Cookie信息（返回Cookie数组/null）
		Cookie[] cs= request.getCookies();
		//2遍历所有的Cookie，然后找到名称为Cart的Cookie
		String prod = null;
		if (cs != null ) {
			for (Cookie c : cs) {
				if ("cart".equals(c.getName())) {
		//3.如果找到了我们所要找的Cookie，那就从Cookie中获取要结算的商品信息
					prod = c.getValue();
					prod = URLDecoder.decode(prod, "UTF-8");
				}
			}
		}
		//4.为商品进行结算
		if (prod != null) {
			Out.write("已经成功为"+prod+"支付了1000元");
		}else {
			Out.write("您还没有将任何商品加入到购物车！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

