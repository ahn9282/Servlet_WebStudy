<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Front Controller 예제입니다.</h1>
<!-- http://localhost:8282/jsp_ajs_front/front_example.jsp -->
<a href="insert.do">insert</a><br>
<!-- http://localhost:8282/front_example.jsp -->
<a href="/insert.do">/insert</a>

<hr>

<a href="http://localhost:8282<%=request.getContextPath()%>/update.do">update</a><br>
<hr>
<a href="http://localhost:8282${pageContext.request.contextPath}/select.do">select</a>
<hr>
<a href="${pageContext.request.contextPath}/delete.do">delete</a><!-- 제일 많이 쓰이는 방식  -->
<hr>
<a href="${pageContext.request.contextPath}/modify.do">modify</a><!-- 제일 많이 쓰이는 방식  -->



</body>
</html>