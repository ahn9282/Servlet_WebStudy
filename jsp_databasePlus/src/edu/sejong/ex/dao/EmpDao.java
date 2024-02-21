package edu.sejong.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpDto;


public class EmpDao {
	
	
	  private String driver= "oracle.jdbc.driver.OracleDriver"; 
	  private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	  private String id = "scott";
	  private String pw = "tiger";
	 
		private DataSource datasource = null;
		
	public EmpDao() {
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public List<EmpDto> empList(){
		
		List<EmpDto> emps = new ArrayList<>();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql = "select * from emp";
		
		try {
	
	    	con = datasource.getConnection();
	    	stmt = con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	
			
	      	while(rs.next()){
	    		
	      		int empno = rs.getInt("empno");
	    		String ename = rs.getString("ename");
	    		String job = rs.getString("job");
	    		
	    		int mgr = rs.getInt("mgr");
	    		
	    		String hiredate = rs.getString("hiredate");
	    		int sal = rs.getInt("sal");
	    		String comm = rs.getString("comm");
	    		int deptno = rs.getInt("deptno");
	    		
	    		EmpDto dto = new EmpDto(empno, ename,  job, mgr, hiredate, sal, deptno);
	    	
	    		emps.add(dto);
	    	}  	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
					if(rs != null)
						rs.close();
					
					if(stmt != null)
						stmt.close();
		
					if(con != null)
						con.close();		
					
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return emps;
	}
	public int insert(EmpDto emp) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) "
				+ "values(?,?,?,?,?,?,?,?)";

		System.out.println("sql 확인:" + sql);
		int result = -1;
		try {

			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setString(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}
	

	public int insertempEX(EmpDto emp) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into empEx (empno,ename,job,manager,hiredate,comm,sal,dname) "
				+ "values(?,?,?,?,?,?,?,?)";

		System.out.println("sql 확인:" + sql);
		int result = -1;
		try {

			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setString(4, emp.getManager());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());		
			pstmt.setString(7, emp.getComm());
			pstmt.setString(8, emp.getDname());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}
	public List<EmpDto> empList2(){
		List<EmpDto> emps = new ArrayList<>();	
		
		String sql = "select * from emp";
		//Try-with-resources
		try(Connection con =  DriverManager.getConnection(url,id,pw);
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				) {
			
	      	while(rs.next()){
	    		
	      		int empno = rs.getInt("empno");
	    		String ename = rs.getString("ename");
	    		String job = rs.getString("job");
	    		
	    		int mgr = rs.getInt("mgr");
	    		
	    		String hiredate = rs.getString("hiredate");
	    		int sal = rs.getInt("sal");
	    		String comm = rs.getString("comm");
	    		int deptno = rs.getInt("deptno");
	    		
	    		EmpDto dto = new EmpDto(empno, ename,  job, mgr, hiredate, sal, deptno);
	    	
	    		emps.add(dto);
	    	}  	
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return emps;
	}
	
	public String getHtml() {
		String html = "";
		List<EmpDto> emps = empList();
		
		for (EmpDto emp : emps) {
			html  = html + emp.toString() + "<br>";
		}
		
		return html;
	}
	
	
	//자바 1.11 이상 일때
//		public List<EmpDto> empList3(){
//			List<EmpDto> emps = new ArrayList<>();	
//			
//			String sql = "select * from emp";
//			//Try-with-resources
//			Connection con =  DriverManager.getConnection(url,id,pw);
//			Statement stmt = con.createStatement();
//			ResultSet rs=stmt.executeQuery(sql);
//			
//			try(con; stmt; rs) {
//				
//		      	while(rs.next()){
//		    		
//		      		int empno = rs.getInt("empno");
//		    		String ename = rs.getString("ename");
//		    		String job = rs.getString("job");
//		    		
//		    		int mgr = rs.getInt("mgr");
//		    		
//		    		String hiredate = rs.getString("hiredate");
//		    		int sal = rs.getInt("sal");
//		    		String comm = rs.getString("comm");
//		    		int deptno = rs.getInt("deptno");
//		    		
//		    		EmpDto dto = new EmpDto(empno, ename,  job, mgr, hiredate, sal, deptno);
//		    	
//		    		emps.add(dto);
//		    	}  	
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} 
//			
//			return emps;
//		}
	
	
}
