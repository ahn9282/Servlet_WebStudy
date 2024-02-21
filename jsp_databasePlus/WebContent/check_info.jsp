<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="edu.sejong.ex.dao.EmpDao"%>
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
		int empno = Integer.valueOf(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String manager = request.getParameter("manager");
		String hiredate = request.getParameter("hiredate");
		int sal = Integer.valueOf(request.getParameter("sal"));
		String comm = request.getParameter("comm");
		String dname =request.getParameter("dname");
		
		EmpDto in = new EmpDto(empno, ename, job, manager, hiredate, comm,sal, dname);
		EmpDao ed = new EmpDao();
		ed.insertempEX(in);
		
	%>
	<a href=emp_list.jsp>확인 list</a> 
	
</body>
</html>