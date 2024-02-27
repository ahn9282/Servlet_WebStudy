<%@page import="edu.sejon.ex.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejon.ex.dao.MemberDao"%>
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
<h1>회원 리스트</h1>
<%
MemberDao dao = new MemberDao();
List<MemberDto> list = dao.printMember();
/* for(MemberDto dto : list){
	out.print(dto); 
}*/
%>
<table border="6">
<c:forEach var="dto" items="${list}">
<tr>
<td>${dto.id}</td>
<td>${dto.pw}</td>
<td>${dto.email}</td>
<td>${dto.address}</td>
</tr>
</c:forEach>
</table>

</body>
</html>