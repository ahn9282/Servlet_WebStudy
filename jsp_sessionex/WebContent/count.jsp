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
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			session.setAttribute("count", (int) session.getAttribute("count") + 1);
		}
		int count = (Integer) session.getAttribute("count");
		out.println("총 " + count + " 번 접속하셨습니다.");
	%>
</body>
</html>