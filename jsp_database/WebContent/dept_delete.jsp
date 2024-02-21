<%@page import="edu.sejong.ex.dept.DeptDao"%>
<%@page import="edu.sejong.ex.dept.DeptDto"%>
<%@page import="java.util.*"%>
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
/* 	request.setCharacterEncoding("UTF-8"); */
	
	String deptno = request.getParameter("deleteno");
	
	
	DeptDto dept = new DeptDto(Integer.valueOf(deptno),null,null);
	DeptDao deptDao = new DeptDao();
	
	deptDao.delete(dept);

%>

<jsp:include page="dept_list.jsp"/>
<a href="dept_ctl.jsp">다 시</a>
</body>
</html>