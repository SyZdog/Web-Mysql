<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>显示所有门店信息</h3>
	<%
		//获取request域中的门店信息集合
		List<String> list = (List<String>)request.getAttribute("list");
		for(String door : list){
			out.write("<p>"+door+"</p>");
		}
	%>
</body>
</html>