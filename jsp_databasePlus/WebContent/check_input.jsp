<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.*"%>
<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="edu.sejong.ex.dao.EmpDao"%>
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
	request.setCharacterEncoding("UTF-8");

	Connection conn = null;
	PreparedStatement ps = null;
	
 String sql = "select * from empEx";
	Context initContext = new InitialContext();
	DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oracle");

	
	conn = ds.getConnection();
    
	ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	int i=1;
	while(rs.next()){
		out.println(i + " : " + rs.getString("empno") + " , " +
	    rs.getString("ename")  +" , " + 
	    rs.getString("job")  +" , " + 
	    rs.getString("sal") +" , " + 
	    rs.getString("comm")  +" , " + 
	    rs.getString("dname")  +" , " + 
	    rs.getString("manager")  +" , " + 
	    rs.getString("hiredate") + "<br>");
	i++;
	}
	rs.close();
	ps.close();
	conn.close();

	%>
	<a href=emp_list.jsp>확인 list</a>

</body>
</html>