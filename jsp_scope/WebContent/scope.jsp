<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스코프 예제</h1>
	<% // page 영역
		pageContext.setAttribute("user_name", "admin");

		String user = (String) pageContext.getAttribute("user_name");
	%>
	<%
		// Session  영역
		session.setAttribute("address", "서울시 종로구");
	String address = (String)session.getAttribute("address");
	%>
	<% //Application 영역(웹사이트(톰캣)가 죽을 때까지)
	
	application.setAttribute("password", "1234");
	String password = (String)application.getAttribute("password");
	%>
	<% // request 영역 -- request는 page에서 forward까지 포함
	request.setAttribute("age", 20);
	int age = (int)request.getAttribute("age");
	%>
	<jsp:forward page="scope_session.jsp" />
	
	유저 :
	<%=user%>
	<br>
	주소:
	<%=address%>
	<br>
	비밀번호:
	<%=password%>
	<br>
	나이:
	<%=age%>
	<br>
	
	<a href="scope_session.jsp">세션영역 확인</a>
	<br>

</body>
</html>