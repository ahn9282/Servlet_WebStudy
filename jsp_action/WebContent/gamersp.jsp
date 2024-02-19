<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
response.setContentType(("text/html;charset = UTF-8"));
request.setCharacterEncoding("UTF-8");
String rspv = request.getParameter("rrsspp"); 
int a = 10;
%>
<jsp:useBean id="rsp" class="edu.sejong.ex.GameRSP" />
<jsp:setProperty property="rspv" name="rsp" value="<%=rspv %>" />
나 : <jsp:getProperty property="rspv" name="rsp"/><br>
<jsp:setProperty property="csv" name="rsp" value="<%=rspv %>" />
상대 : <jsp:getProperty property="csv" name="rsp"/><br>
<jsp:setProperty property="result" name="rsp" value="<%=rspv %>" />
결과
 : <jsp:getProperty property="result" name="rsp"/><br>
</body>
</html>