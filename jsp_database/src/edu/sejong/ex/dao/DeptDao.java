package edu.sejong.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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

	public List<DeptVO> deptList() {
		ArrayList<DeptVO> deptlist = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";
		try {

			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String dname = rs.getString("dname");

				String loc = rs.getString("loc");

				int deptno = rs.getInt("deptno");

				DeptVO vo = new DeptVO(deptno, dname, loc);
				deptlist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 필수 이고 닫는 순서도 지켜야함
			try {
				if (rs != null)
					rs.close();
				
				if (stmt != null)
					stmt.close();
				
				if (con != null)
					con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return deptlist;
	}
}
