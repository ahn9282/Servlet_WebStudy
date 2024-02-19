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
		for(int j =1;j <= 5;j++){
			for (int i = 1; i <= j; i++) {
					out.print("*");
			}
			%>
			<br />
			<% 
		}
				%>
				<br />
					<%
		for(int j =5;j >= 0;j--){
			for (int i = 5; i > 5-j; i--) {
					out.print("*");
			}
			%>
			<br />
			<% 
		}
				%>
				
</body>
</html>