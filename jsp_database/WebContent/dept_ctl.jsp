<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
<%@page import="edu.sejong.ex.vo.DeptVO"%>
<%@page import="edu.sejong.ex.dao.DeptDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Input dept01.</h1>
   <form action="dept_insert.jsp" method="post">
      부서 번호: <input type="text" name="deptno" size="10"><br/>
     부서 이름: <input type="text" name="dname" size="10"><br/>
   지역: <input type="text" name="loc" size="10"><br/>
      <input type="submit" value="submit">
      <input type="reset" value="reset">
   </form>
<%
DeptDao deptDao = new DeptDao();
List<DeptVO> dtos = deptDao.deptList();

for (DeptVO vo : dtos) {
	out.println("부서번호 :  " +vo.getDeptno()+ 
			" || 직종이름 : " +vo.getDname()+ 
			" || 지역 이름 : " +vo.getLoc()+ "<br>");
}
%>
<hr>

   <h1>Delete dept01.</h1>
   <form action="dept_delet.jsp" method="post">
     부서 번호: <input type="number" name="deleteno" size="10"><br/>
      <input type="submit" value="delete">
      <input type="reset" value="reset">
   </form>

</body>
</html>