<%@page import="com.sejong.ex.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지입니다.</h1>

	<%
		MemberDto member = (MemberDto) session.getAttribute("member");
	%>
	<%=member.getId()%>님 환영합니다.
	<br />


	<a href="login.jsp"> 로그인 페이지로 이동 </a>
		<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃">
		<input type="button" value="회원정보수정" onclick="javascript:window.location='modify.jsp'"> 
		</form>

</body>
</html>