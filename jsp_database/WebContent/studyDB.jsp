<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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
		//데이터베이스 연결 3종 세트
		Connection connection;
		Statement statement;
		ResultSet rs;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String id = "scott";
		String pw = "tiger";

		String query = "select empno, ename, deptno,mgr,comm from emp";
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, id, pw);
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
	%>
	<table border="1">
		<tr>
			<th>사원 번호</th>
			<th>사원 이름</th>
			<th>부서 번호</th>
			<th>매니저</th>
			<th>커미션</th>
		</tr>


		<%
			while (rs.next()) {
					out.println("<tr>");
					
					String empno = rs.getString("empno");
					
					 String ename = rs.getString("ename");
					
					 String deptno = rs.getString("deptno");
					
					String mgr = rs.getString("mgr");
					
					String comm = rs.getString("comm");
					String[] arr = { empno, ename, deptno, mgr, comm };

					for (String s : arr) {

						out.println("<td>" + s + "</td>");

					}
				
					out.println("</tr>");
				}

			} catch (Exception e) {

			}
		%>

	</table>

</body>
</html>