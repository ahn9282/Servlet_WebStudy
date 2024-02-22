<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 페이지</h1>


<form action="join_ok.jsp" method="post">
<table>
<tr>
<td>아이디 : </td>
<td><input type="text" name="id" size="20"></td>
</tr>

<tr>
<td>패스워드 : </td>
<td><input type="text" name="pw" size="20"></td>
</tr>

<tr>
<td>이메일 : </td>
 <td><input type="text" name="email" size="20"></td>
</tr>

<tr>
<td>주소 : </td>
<td><input type="text" name="address" size="20"></td>
</tr>

</table>

 <input type="submit" value="회원가입">

 <input type="reset" name="초기화"><br>
 </form>
</body>
</html>