<%@page import="edu.sejon.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정 페이지</h1>


	<form action="${pageContext.request.contextPath }/modify.do" method="post">
	<table>
	<tr>
		<td>아이디 : </td>
		<td><input type="text" name="id" value="ID"></td>
	</tr>
	<tr>
		<td>패스워드 : </td>
		<td> <input type="password" name="pw" value="12345678"> </td>
	</tr>
	<tr>
		<td>이메일 : </td>
		<td><input type="text" name="email" value="<%="이메일 변경" %>"></td>
	</tr>
	<tr>
		<td>주소 : </td>
		<td><input type="text" name="address" value="<%="주소 변경" %>"></td>
	</tr>

	</table>
 	<input type="submit" value="수정 완료">
	<input type="reset" name="초기화"><br>
	</form>




</body>
</html>