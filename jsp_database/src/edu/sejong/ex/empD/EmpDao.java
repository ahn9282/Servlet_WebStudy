package edu.sejong.ex.empD;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	String id = "scott";
	String pw = "tiger";

	public EmpDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
		}
	}

	public List<EmpDto> empList() {

		ArrayList<EmpDto> emplist = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String deptno = rs.getString("deptno");
				String comm = rs.getString("comm");
				EmpDto empdto = new EmpDto(empno, ename, job, mgr, deptno, comm);
				emplist.add(empdto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {

				if (rs != null)
					rs.close();

				if (stmt != null)
					stmt.close();

				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return emplist;
	}

}
