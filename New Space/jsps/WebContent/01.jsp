<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h3>JSP表达式</h3>
	<%= "Hello" %> Hello	<br/>
	<% String name = "马云"; %>
	<%= name %>	<br/>
	<%= 123+456 %>
	<%= Math.random() %>
	
	<h3>JSP脚本片段</h3>
	<% for(int i = 0; i < 5; i++){ %>
	<% 	out.write("Hello~~JSP~~<br/>"); %>
	<% } %>
</body>
</html>