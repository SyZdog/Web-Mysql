<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<!-- 引入JSTL标签库-->
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h2>1.（1）c:set标签：用于往域中添加属性，或者修改域中已有的属性值</h2>
	<c:set var = "name" value = "张三" scope = "request"/>
	<%--
		String name = "张三";
		request.setAttribute("name", name)
	--%>
	${name}
	<h4>（2）修改request域中名称为name的属性值</h4>
	<c:set var = "name" value = "张三丰" scope = "request"/>
	${name}
	<h2>2.c:if标签：用于构造简单的if..else..结构</h2>
	<h4>往域中存入一个成绩，根据成绩判断成绩所属的等级</h4>
	<c:set var = "score" value = "99" scope = "request"/>
	<c:if test="${ score >= 80 and score <=100 }">您的成绩属于: 优秀!</c:if>
	<c:if test="${ score >= 60 and score <80 }">您的成绩属于: 中等!</c:if>
	<c:if test="${ score >= 0 and score <60 }">您的成绩属于: 不及格!</c:if>
	<c:if test="${ score < 0 or score >100 }">您的输入有误!</c:if>
	<h2>3.c:forEach 标签： 可以存入域中的集合或数组中的元素进行遍历</h2>
	<h4>(1) 遍历域中数组或集合中的元素</h4>
	<%
		//创建一个List集合
		List<String> list = new ArrayList();
		list.add("刘备");
		list.add("张飞");
		list.add("关羽");
		list.add("赵云");
		//将集合存入到request域中 
		request.setAttribute("list", list);
	%>
	<!-- 通过c:foreach标签来遍历集合中的元素 -->
	<c:forEach items = "${list}" var = "name" varStatus = "status">
		${status.count}.${name}<br/>
	</c:forEach>
	<h4>(2)遍历域中map集合中的元素</h4>
	<%
		//创建一个map集合，并为map集合添加元素
		Map<String,Object> map = new HashMap();
		map.put("name","易烊千玺");
		map.put("age",20);
		map.put("addr","中国");
		//把map集合存入域中
		request.setAttribute("map1", map);
	%>
	<!-- 遍历map集合中的元素 -->
	<c:forEach items = "${map1}" var = "entry">
		${entry}<br/>
	</c:forEach>
	<hr/>
	<c:forEach items = "${map1}" var = "entry">
	${entry.key}:${entry.value}<br/>
	</c:forEach>
	<h4>(3)遍历0~100之间的整数,将是3的倍数的数值输出到浏览器中</h4>
	<!-- for(int i = 0; i <= 100; i++) -->
	<c:forEach begin = "0" end = "100" var = "i" step  ="1">
		${i % 3 == 0 ? i : ""}
	</c:forEach>
	<hr/>
	<c:forEach begin = "0" end = "100" var = "i" step  ="1">
		<c:if test = "${i % 3 == 0}">${i}</c:if>
	</c:forEach>
	<hr/>
	<c:forEach begin="0"  end="100"  var="i"  step="3">
		${i}
	</c:forEach>
	
</body>
</html>