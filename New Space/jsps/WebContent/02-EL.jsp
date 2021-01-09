<%@page import="com.tedu.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h1>EL表达式</h1>
	<h2>1.获取常量、表达式、变量的值（变量得先存入域中）</h2>
	${"Hello EL"} Hello EL </br>
	${100+123}</br>
	<%
		String name = "Jack";
		request.setAttribute("name", name);
	%>
	<!-- 使用EL表达式获取变量的时候，
	底层会根据变量的名字到四大作用域（pageContext<request<session<application)
	中寻找同名属性值，寻找的顺序是按照与对象的范围，从小到大去寻找
	需要先将变量存入到域中，然后从域中获取变量
	如果找到就直接返回找到的属性，如果找不到，就什么也不输出-->
	${name}
	<!-- 使用jsp表达式，是不需要将变量存入到域中，可以直接使用 -->
	<%=name %>
	<h2>2.获取作用域中数组或集合中的元素</h2>
	<%
		//声明一个数组，并在数组中添加元素
		String[] names = {"刘德华","郭富城","张学友","黎明"};
		//将数据保存到域中
		request.setAttribute("names", names);
	%>
	<!-- 通过EL获取域中的names数组中的元素 -->
	${names[0]}
	${names[1]}
	${names[2]}
	${names[3]}
	<h2>3.获取作用域中map集合中的元素</h2>
	<%
		//创建一个map集合，并为map集合添加元素
		Map<String,Object> map = new HashMap();
		map.put("name","易烊千玺");
		map.put("age",20);
		map.put("addr","中国");
		//把map集合存入域中
		request.setAttribute("map1", map);
	%>
	<!-- 通过EL获取map集合的值 -->
	${map1.name}</br>
	${map1.age}</br>
	${map1.addr}</br>
	<hr/>
	${map1["name"]}
	${map1["age"]}
	${map1["addr"]}
	<h2>4.获取作用域中实体对象的属性值</h2>
	<%
		//声明一个实体对象
		User u1 = new User();
		u1.setName("刘德华");
		u1.setAge(60);
		u1.SetAddr("中国香港");
		//将User对象存入到域中
		request.setAttribute("user", u1);
	%>
	<!-- 通过EL来获取实体对象User属性值 -->
	<%-- 
	${user.getName()}
	${user.getAge()}
	${user.getAddr()}
	--%>
	<hr/>
	<!-- user.name底层调用的仍然是getName() -->
	${user.name}
	<!-- user.name底层调用的仍然是getAge() -->
	${user.age}
	<!-- user.name底层调用的仍然是getAddr() -->
	${user.addr}
	
</body>
</html>