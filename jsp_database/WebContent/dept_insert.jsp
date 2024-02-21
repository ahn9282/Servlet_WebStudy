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

String deptno = request.getParameter("deptno");
String dname= request.getParameter("dname");
String loc = request.getParameter("loc");

DeptDto dept = new DeptDto(Integer.valueOf(deptno), dname,loc);
DeptDao deptDao = new DeptDao();

deptDao.insert(dept);
%>
<a href="dept_list.jsp">dept리스트확인</a>
</body>
</html>