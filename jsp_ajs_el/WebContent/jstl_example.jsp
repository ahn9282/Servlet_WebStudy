<%@page import="edu.sejong.ex.Student"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_example.jsp</title>
</head>
<body>
<h1>Tag - out 태그</h1>
<c:out value="${'welcome to JSTL'}"></c:out>
<c:out value="${'홍길동'}"></c:out>
<c:out value="${'서울시 동작구'}"></c:out>

<h1>Tag - set 태그</h1>
<c:set var="data" value="my_data"/>
<c:out value="${data}"/>

<!-- pageContext.setAttribute("name","홍길동) -->
<!--<c:set var="name">홍길동</c:set>
<!-- request.Context.setAttribute("name","홍길동) -->
<c:set scope="request" var="name">홍길동</c:set> <!-- scope를 통하여 default는 page이나 변경가능 -->
<c:out value="${name}"/>
${"스코프는 리퀘스트" }<br>
<%
   int a = 123;

%>
<c:set var="num" value="<%=a%>"></c:set>
<c:out value="${num}"/>

<c:set var="income" value="${400*900 }"/>
<c:out value="${income }"/>

<hr>
<h1>Tag - set remove(변수 삭제)</h1>
<!-- pageContext.removeAttribute("income");  --> 
<c:remove var="income"/>
인컴 :  <c:out value="${income }"/>

<h1>Tag - 조건문</h1>
<c:set var="salary" value="${100*100 }"/>
<c:if test="${salary > 100 }">
<p>나의 봉급은 ${salary } 입니다.</p>
</c:if>

<c:remove var="salary"/>


<c:if test="${empty salary }">
<p>수입이 없습니다.</p>
</c:if>

<hr>
<h1>Tag - choose when</h1>
<c:set var="grade" value="${90 }"/>
<c:choose>
<c:when test="${grade >= 90 }">
수 입니다.
</c:when>

<c:when test="${grade >= 90 }">
우입니다.
</c:when>

<c:when test="${grade >= 90 }">
미 입니다.
</c:when>

<c:otherwise>
가요.
</c:otherwise>
</c:choose>

<hr>
<h1>Tag - 반복문</h1>
<c:forEach var="i" begin="1" end="10" step="2">
${i }<br>
</c:forEach>

<hr>

<c:forEach var="i" begin="1" end="10">
${i }<br>
</c:forEach>

<%
ArrayList<Student> list = new ArrayList<>();
list.add(new Student(10,"준1"));
list.add(new Student(13,"준2"));
list.add(new Student(12,"준3"));
list.add(new Student(14,"준4"));

pageContext.setAttribute("students",list);
int[] intArr = {1,2,3,4,5};

pageContext.setAttribute("intArr",intArr);
%>
<c:forEach var="student" items="${students }">
나이 : ${student.age } 이름 : ${student.name } <br>

</c:forEach>

<hr>

<c:forEach var="num" items="${intArr}">
번호 : ${num } <br>

</c:forEach>

<hr>

<c:forTokens var = "fruit" items="사과,포도,바나나,수박,딸기" delims=",">
	과일 : ${fruit }<br>
</c:forTokens>


</body>
</html>