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
<%=age %>세로 미성년자입니다. 주류구매 불가합니다. 가라<br>
<a href="requesrex.html">처음으로 이동</a>
</body>
</html>