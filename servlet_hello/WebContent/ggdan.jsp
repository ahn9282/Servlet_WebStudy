<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">

tr:nth-child(odd){
background-color:#333D51 ;
text-align:center;
}
</style>
</head>
<body>
	<table border="5" id = "tb1" bordercolor="purple">
		<th></th>
		<th bgcolor="DBC1AD ">2단</th>
		<th bgcolor="green">3단</th>
		<th bgcolor="D3AC2B ">4단</th>
		<th bgcolor="333D51 ">5단</th>
		<th bgcolor="934A5F">6단</th>
		<th bgcolor="C2B4D6 ">7단</th>
		<th bgcolor="A3C6C4 ">8단</th>
		<th bgcolor="872642  ">9단</th>
		<%
			for (int i = 1; i <= 9; i++) {
		%>


		<tr id = "tr1">
			<td><%=i %></td>
			<%
				for (int j = 2; j <= 9; j++) {
			%>
			<td><%=(j + " X " + i + " = " + (i * j))
			%></td>
			<%
				}
			%>
		</tr>
		<%} %>
	
</body>
</html>