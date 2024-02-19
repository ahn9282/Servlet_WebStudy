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
<%double radius = Double.parseDouble(request.getParameter("rad"));%>
	<jsp:useBean id="circle123" class="edu.sejong.ex.Circle" />
	<jsp:setProperty property="radius" name="circle123" value="<%=radius %>" />
	<jsp:setProperty property="area" name="circle123" value="<%=radius %>" />
	
	반지름 : <jsp:getProperty property="radius" name="circle123" /><br>
	원넓이 : <jsp:getProperty property="area" name="circle123" /><br>
</body>
</html>