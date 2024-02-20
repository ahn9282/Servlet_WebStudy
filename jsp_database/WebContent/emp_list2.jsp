<%@page import="edu.sejong.ex.beanEx.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="edu.sejong.ex.empD.EmpDao"%>
<%@page import="edu.sejong.ex.empD.EmpDto"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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


beanDao deptDao = new beanDao();
 deptDao.setList("select * from emp");

out.println(deptDao.getList());

%>

</body>
</html>