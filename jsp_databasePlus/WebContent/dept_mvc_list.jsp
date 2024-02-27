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
<table border="5">
<c:forEach var="dept" items="${depts}">
<tr>
<td>부선번호 : ${dept.deptno}</td>
<td>직종이름 : ${dept.dname}</td>
<td>지역 : ${dept.getLoc()}</td>
</tr>
</c:forEach>


</table>

</body>
</html>