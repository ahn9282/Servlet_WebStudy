<%@ page import = "edu.sejong.ex.Rectangle" %>
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
double width = Double.parseDouble(request.getParameter("width"));
double height = Double.parseDouble(request.getParameter("height"));
Rectangle rec = new Rectangle(width,height);
%>

사각형 넓이 : <%=rec.getRectangleArea() %>
</body>
</html>




