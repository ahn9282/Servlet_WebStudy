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
<h1>업데이트 페이지 입니다.</h1>
<%
      request.setCharacterEncoding("UTF-8");
       
	 String deptno = request.getParameter("deptno");
	 String dname = request.getParameter("dname");
	 String loc = request.getParameter("loc");
	
	 DeptVO dept = new DeptVO(Integer.valueOf(deptno),dname,loc);
             
      DeptDao deptDao = new DeptDao();
       
      deptDao.update(dept);
%>
<hr>
<jsp:include page="dept_list.jsp"/>
<a href="dept_input.html">dept input 화면으로....</a>

</body>
</html>