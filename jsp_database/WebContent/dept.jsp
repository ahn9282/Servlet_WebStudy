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
String url =  "jdbc:oracle:thin:@//localhost:1521/xe";
String id="scott";
String pw="tiger";

String query = "select * from dept";
try{
	Class.forName(driver);
	connection = DriverManager.getConnection(url,id,pw);
	statement = connection.createStatement();
	rs = statement.executeQuery(query);
	
	while(rs.next()){
		
		String deptno = rs.getString("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
		
		out.println("부서 번호 : " + deptno + " 부서 이름 : " + dname + " 지역 : " + loc + "<br>");
	}
}catch(Exception e){
	
}
%>

</body>
</html>