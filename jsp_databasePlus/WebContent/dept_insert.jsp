<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="edu.sejong.ex.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejong.ex.dao.DeptDao"%>
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
<%
	   request.setCharacterEncoding("UTF-8");
       
	   String deptno = request.getParameter("deptno");
	   String dname = request.getParameter("dname");
       String loc = request.getParameter("loc");
       
       DeptVO dept = new DeptVO(Integer.valueOf(deptno),dname,loc);
              
	   DeptDao deptDao = new DeptDao();
    	
	   deptDao.insert(dept);
%>

<a href="dept_list.jsp">dept 리스트 확인</a>

</body>
</html>