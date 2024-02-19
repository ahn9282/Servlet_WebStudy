<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>이번 주 번호입니당.</h1>
	<jsp:useBean id="lotto" class="edu.sejong.ex.Lotto" />
	<jsp:setProperty property="numstr" name="lotto" value="로또" />
	번호 : <jsp:getProperty property="numstr" name="lotto"  />
	
</body>
</html>