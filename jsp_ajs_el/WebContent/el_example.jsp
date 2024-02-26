<%@page import="edu.sejong.ex.Student"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 리터럴 표현식</h1>

문자열 : ${"홍길동"}<br>
문자열 : <%="홍길동" %><br>
정수 : ${20}<br>
실수 : ${2.14}<br>
boolean : ${true}, ${false}<br>
null : ${null}<br>
<hr>

<%
int a = 10;
String str = "바다";
%>

<h1>!!!!!!!!EL과 스크립틀릿 차이 중요함~~~~!!!!!!!!!!!!!!!!!!!!!!!</h1>

변수 a 출력 :  <%=a %><br>
변수 str 출력 :  <%=str %><br>
변수 a 출력 : ${a }<br>  <%--EL은 변수이름으로 출력이 안됨 --%>
변수 str 출력 :  ${str}<br> <%--EL은 안에 내용에 있어서는 타입마다의 방식을 지켜서 출력하려는 값 자체(리터럴)을 넣어야한다. --%>

<hr>
<h1>EL 표현 식으로 값 꺼내기</h1>
	<%
		pageContext.setAttribute("sea", "바다");
		pageContext.setAttribute("scores", new int[] { 90, 80, 70 });

		Map<String, Integer> map = new HashMap<>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);

		session.setAttribute("map", map);

		Student student = new Student();
		student.setName("안준섭");
		student.setAge(123);
		pageContext.setAttribute("student", student);
	%>
	EL str 출력 : ${sea }<br>
EL scores1 출력 : ${scores[0]}<br>
EL scores2 출력 : ${scores[1]}<br>
EL scores3 출력 : ${scores[2]}<br>
EL map 출력 : ${map["1"]}<br>
EL map 출력 : ${map["2"]}<br>
EL map 출력 : ${map["3"]}<br>

El student출력 : ${student.getAge() }<br><%--EL은 메서드르ㅡㄹ 통해서만 호출을 할 수 있다 그래서 getter and setter함수를 항상 만들어두는게 중요 --%>
El student출력 : ${student.getName() }<br><%-- PageContext를 통해 속성에다가 함수를 호출도 가능 --%>
${student.setName("강아지") }
El student출력 : ${student.getName() }<br>

<hr>
<h1>산술 연산자</h1>
${10 + 20}<br>
${"10 + 20"}<br>
${10 / 20}<br><%-- div로 대체 --%>
${10 mod 20}<br>
${10 % 20}<br>

<hr>
<h1>EL 관계 연산자</h1>
${10 == 11 }<br>
${10 lt 11 }<br><%--lt(less than) : "<"--%>
${10 gt 11 }<br><%-- gt(Greater than) : ">"--%>

<hr>
<h1>EL에서 null check</h1>
<%
pageContext.setAttribute("title", "EL 연산자");
%>
널체크 결과 : ${empty title }<br><%-- null 이면 true  null이 아니면 false반환 --%>
널체크 결과 : ${empty title2 }<br>
${title != null }<br>
</body>
</html>