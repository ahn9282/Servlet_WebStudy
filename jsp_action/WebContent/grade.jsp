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
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int math = Integer.parseInt(request.getParameter("math"));

%>
	<jsp:useBean id="gradecal" class="edu.sejong.ex.Grade" />
	<jsp:setProperty property="kor" name="gradecal" value="<%=kor %>" />
	<jsp:setProperty property="eng" name="gradecal" value="<%=eng %>" />
	<jsp:setProperty property="math" name="gradecal" value="<%=math %>" />
	
	국어 : <jsp:getProperty property="kor" name="gradecal" /><br>
	영어 : <jsp:getProperty property="eng" name="gradecal" /><br>
	수학 : <jsp:getProperty property="eng" name="gradecal" /><br>
	
		<jsp:setProperty property="total" name="gradecal" value="<%=kor %>"/>
	총 점 : <jsp:getProperty property="total" name="gradecal" /><br>
		<jsp:setProperty property="avg" name="gradecal" value="<%=kor %>"/>
	평균 : <jsp:getProperty property="avg" name="gradecal" /><br>
	
</body>
</html>