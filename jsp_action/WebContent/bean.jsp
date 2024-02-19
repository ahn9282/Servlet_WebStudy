<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>bean액션 태그 예제 입니다.</h1>
	<jsp:useBean id="student" class="edu.sejong.ex.Student" />
	<jsp:setProperty property="name" name="student" value="홍길동" />
	<jsp:setProperty property="grade" name="student" value="5학년" />
	<jsp:setProperty property="age" name="student" value="123" />
	<jsp:setProperty property="studentNum" name="student" value="5123" />
	이름 :
	<jsp:getProperty property="name" name="student" />
	<br>
	학년 :
	<jsp:getProperty property="grade" name="student" /><br>
	나이 : <jsp:getProperty property="age" name="student" /><br>
	학생 번호 : <jsp:getProperty property="studentNum" name="student" /><br>
</body>
</html>