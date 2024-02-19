<%@ page import = "edu.sejong.ex.RSP" %>
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
 int rspv = Integer.parseInt(request.getParameter("rrsspp"));
 RSP rsp = new RSP(rspv);
%>
컴퓨터 : <%=rsp.getcv() %>
<br/>
당신 : <%=rsp.getrspv() %>
<br/>
결과  : <%=rsp.getwinner() %>
<br/>
<a href="RSP.html" >다시하기</a>
</body>
</html>