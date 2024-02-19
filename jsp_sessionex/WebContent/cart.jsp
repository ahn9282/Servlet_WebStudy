<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쇼핑몰 장바구니</h1>
	<%
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.html");
		} else {
			out.print("계속 쇼핑을 할 수 있습니다.");
		}
	%>
	<a href="session_test.jsp">session_test</a>
</body>
</html>