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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
	%>
	아이디 :<%=id%><br /> 
	비밀번호 :<%=pw%><br />
	<hr>
	아이디 : ${param.id }
	비밀번호 : ${param.pw }<br>
	아이디 : ${param["id"] }
	비밀번호 : ${param["pw"]}<br>
	<hr>
	어플리케이션 스코프 :${applicationScope.application_name}<br> 
	세션 스코프 :${sessionScope.session_name}<br> 
	page 스코프 :${pageContextScope.page_name}<br> <%--범위 이탈로 안나옴 --%>
	request 스코프 :${requestScope.request_name}<br>  <%--범위 이탈로 안나옴 --%>
</body>
</html>