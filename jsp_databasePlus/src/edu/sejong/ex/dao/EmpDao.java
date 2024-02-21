package edu.sejong.ex.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpDto;


public class EmpDao {
	
	private String driver= "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
		
	public EmpDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
	
	    	con = DriverManager.getConnection(url,id,pw);
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
	
	//자바 1.7 이상 일때
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
