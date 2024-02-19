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
String str = request.getParameter("age");
int age = Integer.valueOf(str);
%>
<%=age %>세 성인입니다. 주류구매 다능합니다.<br>
<a href="requesrex.html">처음으로 이동</a>
</body>
</html>