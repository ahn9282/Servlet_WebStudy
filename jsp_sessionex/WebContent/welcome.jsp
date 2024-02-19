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
		String id = (String)session.getAttribute("id");
	out.println(id + "님 환영합니다.");
	%>
	<a href="logout.jsp">로그아웃</a>
	<a href="cart.jsp">장바구니</a>
	<form action="cart.jsp">
	<input type="submit" value="장바구니">
	</form>
</body>
</html>