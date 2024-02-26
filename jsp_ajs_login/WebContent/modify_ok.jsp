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
	<h1>수정 ok 페이지</h1>

	<%
		request.setCharacterEncoding("UTF-8");
	MemberDto idGet = (MemberDto)session.getAttribute("member"); 
	
		String id = idGet.getId();
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDao dao = new MemberDao();
		MemberDto member = new MemberDto(id,pw,email,address);
		int result = dao.modifyMember(member);
		
		System.out.println(member.getId());
		System.out.println(member.getPw());
		System.out.println(member.getEmail());
		System.out.println(member.getAddress());
		System.out.println(result);
		
		
	%>
	<h1>수정 완료되었습니다. 다시 로그인해주세요~</h1>
	<% session.invalidate(); %>
<a href="login.jsp">로그인 화면으로</a>

</body>
</html>