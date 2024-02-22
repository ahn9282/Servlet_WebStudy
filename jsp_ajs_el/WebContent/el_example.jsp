<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% // 로그인 페이지로 올 때 session의 member가 null이 아니면( sessionid가 존재) main.jsp를 forward하여 login.jsp에서 main.jsp로 나타냄
	if(session.getAttribute("member") != null){ %>
		<jsp:forward page="main.jsp"></jsp:forward>
	<% }%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지</h1>


<form action="login_ok.jsp" method="post">
아이디 : <input type="text" name="id"><br>
패스워드 : <input type="text" name="pw"><br>
 <input type="submit" value="로그인">
 <input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'"><br>

 <input type="reset" name="초기화"><br>

</form>




</body>
</html>