<%@page import="edu.sejong.ex.beanEx.BeanDto"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>emp_use_list</h1>
<jsp:useBean id="BeanDto" class="edu.sejong.ex.beanEx.BeanDto" />
	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String id = "scott";
		String pw = "tiger";

		String query = "select * from emp";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				%>
<jsp:setProperty property="empno" name="BeanDto" value="<%=empno %>" />
<jsp:setProperty property="ename" name="BeanDto" value="<%=ename %>" />
<jsp:setProperty property="job" name="BeanDto" value="<%=job %>" />
<jsp:setProperty property="mgr" name="BeanDto" value="<%=mgr %>" />
<jsp:setProperty property="hiredate" name="BeanDto" value="<%=hiredate %>" />
<jsp:setProperty property="sal" name="BeanDto" value="<%=sal %>" />
<jsp:setProperty property="comm" name="BeanDto" value="<%=comm %>" />
<jsp:setProperty property="deptno" name="BeanDto" value="<%=deptno %>" />
	사원번호 : <jsp:getProperty property="empno" name="BeanDto" />
	사원이름 : <jsp:getProperty property="ename" name="BeanDto" />
	직업 :<jsp:getProperty property="job" name="BeanDto" />
	매니저 :<jsp:getProperty property="mgr" name="BeanDto" />
	입사일 :<jsp:getProperty property="hiredate" name="BeanDto" />
	급여 : <jsp:getProperty property="sal" name="BeanDto" />
	커미션 : <jsp:getProperty property="comm" name="BeanDto" />
	부서번호 : <jsp:getProperty property="deptno" name="BeanDto" /> <br>
				
				<%
				
			}
		} catch (Exception e) {

		}
	%>


</body>
</html>