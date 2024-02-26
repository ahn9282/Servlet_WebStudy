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

<c:forEach var="i" begin="1" end="9">
<tr>
<c:forEach var="j" begin="3" end="9" step="2">

<td> ${j } X ${i } = ${j * i}</td>
</c:forEach>
</tr>
</c:forEach>

</table>
</body>
</html>