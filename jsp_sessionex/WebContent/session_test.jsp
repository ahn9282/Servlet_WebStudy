<%@page import="java.util.Enumeration"%>
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
		//1.세션 객체에 있는 객체 전부 확인하기
		Enumeration enumeration = session.getAttributeNames();
		int i = 0;
		while (enumeration.hasMoreElements()) {
			i++;
			String name = enumeration.nextElement().toString();
			String value = (String) session.getAttribute(name).toString();
			out.println("Key : " + name + "<br>");
			out.println("Value : " + value + "<br>");
			out.println("=============================" + "<br>");

		}
		if (i == 0)
			out.println("해당 세션이 삭제 되었습니다.");
out.println("************************<br>");
		// 세션 아이디
		String sessionID = session.getId();
		out.println("sessionID : " + sessionID + "<br>");
		
		//2. 세션 안에 있는 전체 객체 지우기
		session.invalidate();
	%>

</body>
</html>