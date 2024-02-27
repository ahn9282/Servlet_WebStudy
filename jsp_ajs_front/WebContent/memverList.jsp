<%@page import="edu.sejon.ex.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejon.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MemberDao dao = new MemberDao();
List<MemberDto> dtos = dao.printMember();

%>
<h1>멤버 테이블 리스트 확인</h1>
<hr>
<form action="${pageContext.request.contextPath}/list.do" method="post">
<input type="submit" value="확인">
</form>
</body>
</html>