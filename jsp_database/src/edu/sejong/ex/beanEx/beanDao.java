package edu.sejong.ex.beanEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.sejong.ex.empD.EmpDto;

public class beanDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	String id = "scott";
	String pw = "tiger";
	ArrayList<BeanDto> emplist = new ArrayList<>();

	public beanDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
		}
	}

	public void setList(String sql) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

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
				String hiredate = rs.getString("hiredate");
				String deptno = rs.getString("deptno");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");

				BeanDto empdto = new BeanDto(empno, ename, job, mgr, deptno, hiredate, sal, comm);
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
	}

	public String getList() {
		String str = "";
		for (BeanDto b : emplist) {
			str +=" 사원 번호 : " + b.getEmpno() + 
					" 사원 이름 : " + b.getEname() + 
					" 직업 : " + b.getJob() +
					"급여 : " + b.getSal() + 
					" 입사일 : " + b.getHiredate() +
					" 커미션 : " + b.getComm() +
					" 매니저 : " + b.getMgr() + 
					" 부서 번호 : " + b.getDeptno() + "<br>";
					
		}

		return str;
	}
}
