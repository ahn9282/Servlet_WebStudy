<%@page import="com.sejong.ex.dto.MemberDto"%>
<%@page import="com.sejong.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 ok 페이지</h1>

	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDao dao = new MemberDao();
		MemberDto member = new MemberDto(id,pw,email,address);
		int result = dao.insertMember(member);
		
		System.out.println(result);
		
		if(result == 0){
			response.sendRedirect("login.jsp");
		}else if(result > 0){
			session.setAttribute("member", member);
			response.sendRedirect("main.jsp");
		}
	%>


</body>
</html>