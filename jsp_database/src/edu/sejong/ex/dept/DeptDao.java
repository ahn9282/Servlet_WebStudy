package edu.sejong.ex.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.sejong.ex.vo.DeptVO;

//Data Access Object의 약자 DAO

public class DeptDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	String id = "scott";
	String pw = "tiger";

	public DeptDao() {
		try {
			Class.forName(driver); // "oracle.jdbc.driver.OracleDriver" 를 new(객체 생성)

		} catch (Exception e) {
		}
	}


	
	public int delete(DeptDto dept){
	      
	      Connection con=null;
	      PreparedStatement pstmt = null;
	         
	      String sql = "delete from dept01 where deptno = ?";
	            
	      System.out.println("sql 확인:" + sql);
	      int result = -1;
	      try {
	       
	          con = DriverManager.getConnection(url,id,pw);
	          pstmt = con.prepareStatement(sql);
	          
	          pstmt.setInt(1, dept.getDeptno());          
	          result =pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         
	         try {
	            
	               if(pstmt != null)
	                  pstmt.close();
	      
	               if(con != null)
	                  con.close();      
	               
	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }         
	      }
	      
	      return result;
	   }
	
	public int insert(DeptDto dept) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		/*
		 * String sql = "insert into dept01(deptno, dname, loc)" + " values(" +
		 * dept.getDeptno() + ", '" + dept.getDname() + "', '" + dept.getLoc() + "')";
		 */
		String sql = "insert into dept01(deptno, dname, loc)" +  " values(?,?,? )";
		System.out.println("Check the sql" + sql);
		int result = -1;
		
		try {

			
			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,dept.getDeptno());
			pstmt.setString(2,dept.getDname());
			pstmt.setString(3,dept.getLoc());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 필수 이고 닫는 순서도 지켜야함
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
}
