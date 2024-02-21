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
       
       DeptVO dept = new DeptVO(Integer.valueOf(deptno),null,null);
              
      DeptDao deptDao = new DeptDao();
       
      deptDao.delete(dept);
%>
<hr>
<jsp:include page="dept_list.jsp"/>
<a href="dept_input.html">dept input 화면으로....</a>

</body>
</html>