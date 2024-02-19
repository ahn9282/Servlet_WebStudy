<head><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스코프세션</h1>
	<%
		String user = (String) pageContext.getAttribute("user_name");
		// Session  영역
		String address = (String)session.getAttribute("address");
		String password = (String)application.getAttribute("password");
		//request 는 안넘어가기에 이렇게 error처리를 해줘야 한다.
		int age = 0;
		if(request.getAttribute("age") != null){
		age = (int)request.getAttribute("age");
		}
		
	%>

	
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
</body>
</html>