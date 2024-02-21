<%@page import="edu.sejong.ex.dept.*"%>
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
request.setCharacterEncoding("UTF-8");

String deptno = request.getParameter("deleteno");


DeptDto dept = new DeptDto(Integer.valueOf(deptno), null,null);
DeptDao deptDao = new DeptDao();

deptDao.delete(dept);
%>
<a href="dept_list.jsp">dept리스트확인</a>
</body>
</html>