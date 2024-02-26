<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="edu.sejong.ex.dao.EmpDao"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="edu.sejong.ex.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejong.ex.dao.DeptDao"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	EmpDao empDao = new EmpDao();
    	
         List<EmpDto> list = empDao.empList();
         pageContext.setAttribute("emp", list);
%>
<table border="5">

<c:forEach var="empv" items="${emp }">
<tr>
<td>${empv.getEmpno() }</td>
<td>${empv.getEname()}</td>
<td>${empv.getJob()}</td>
<td>${empv.getMgr()}</td>
<td>${empv.getHiredate()}</td>
<td>${empv.getSal()}</td>
<td>${empv.getComm()}</td>
<td>${empv.getDeptno()}</td>
</tr>
</c:forEach>
</table>


</body>
</html>