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
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("id") && cookie.getValue().equals("abcde")){
				out.println(cookie.getValue() + "님 환연합니다.");
			}
		}
	%>
	<a href="login.jsp">로그아웃</a>
</body>
</html>