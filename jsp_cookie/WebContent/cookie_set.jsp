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
Cookie cookie = new Cookie("age","10");
cookie.setMaxAge(60*60);
response.addCookie(cookie);
%>
<a href="cookie_get.jsp">cookie get</a>
</body>
</html>