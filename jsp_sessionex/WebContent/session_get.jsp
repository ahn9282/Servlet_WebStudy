<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = (String)session.getAttribute("name");
int age = (Integer)session.getAttribute("age");
	
%>
이흠 : <%=name %>
나이 : <%=age %>
<a href="session_test.jsp">session_test</a>
</body>
</html>