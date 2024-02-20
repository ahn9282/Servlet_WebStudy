<%@page import="java.util.*"%>
<%@page import="edu.sejong.ex.vo.DeptVO"%>
<%@page import="edu.sejong.ex.dao.*"%>
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
		DeptDao deptDao = new DeptDao();
		List<DeptVO> dtos = deptDao.deptList();

		for (DeptVO vo : dtos) {
			out.println("부서번호 :  " +vo.getDeptno()+ 
					" || 직종이름 : " +vo.getDname()+ 
					" || 지역 이름 : " +vo.getLoc()+ "<br>");
		}
	%>

</body>
</html>