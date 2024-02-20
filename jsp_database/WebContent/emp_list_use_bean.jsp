<%@page import="java.util.*"%>
<%@page import="edu.sejong.ex.beanEx.beanDao"%>
<%@page import="edu.sejong.ex.beanEx.BeanDto"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>emp_use_list</h1>
<jsp:useBean id="BeanDto" class="edu.sejong.ex.beanEx.BeanDto" />
<jsp:useBean id="list" class="edu.sejong.ex.beanEx.beanDao" />

<jsp:setProperty property="list" name="list" value="select * from emp" />

 <jsp:getProperty property="list" name="list" /> <br>

</body>
</html>