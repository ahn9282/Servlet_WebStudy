<%@ page import = "edu.sejong.ex.Circle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
String strrad;
double rad;
double pi= 3.14;
%>
<% 
response.setContentType(("text/html;charset = UTF-8"));
request.setCharacterEncoding("UTF-8");

strrad = request.getParameter("rad"); 
rad = Double.parseDouble(strrad);
%>

원의 넓이: <%=(rad*rad*pi) %>
원의 넓이: <%=(rad*rad*Math.PI) %>
<a href="circle.html">되돌리기</a>

<%
Circle circle = new Circle(rad);

%>
원 넓이는 <%=circle.getCircleArea() %>
</body>
</html>




