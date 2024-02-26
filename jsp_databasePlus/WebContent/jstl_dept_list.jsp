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
		DeptDao deptDao = new DeptDao();
    	
         List<DeptVO> dtos = deptDao.deptList();
         pageContext.setAttribute("dept", dtos);
%>
<table border="5">
<tr>
<th>deptno</th>
<th>dname</th>
<th>loc</th>
</tr>
<c:forEach var="deptv" items="${dept }">
<tr>
<td>${deptv.getDeptno() }</td>
<td>${deptv.getDname()}</td>
<td>${deptv.getLoc()}</td>
</tr>
</c:forEach>
</table>


</body>
</html>