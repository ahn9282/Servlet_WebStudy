<%@ page import ="java.util.Arrays" %>
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
	String name, id, pw,major,protocol;
	String[] hobbys;
	%>
	<%
	response.setContentType(("text/html;charset = UTF-8"));
	request.setCharacterEncoding("UTF-8");
	
	 name = request.getParameter("name");
	 id = request.getParameter("ID");
	 pw = request.getParameter("PW");
	 hobbys = request.getParameterValues("hobby");//체크박스 처리 
								//다수의 값들 처리
	 major = request.getParameter("major");//옵션 처리
	 protocol = request.getParameter("protocol"); %>
	 
	 이름 : <%=name %><br/>
	 아이디 : <%=id %><br/>
	 비밀번호 : <%=pw %><br/>
	 취미 : <%=Arrays.toString(hobbys) %><br/>
	 전공 : <%=major %><br/>
	 프로토콜 : <%=request.getParameter("protocol") %><br/>
</body>
</html>