package jsp_ahn_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jsp_ahn_board.dto.Tdto;

public class Tdao {

	private DataSource dataSource = null;

	public Tdao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 */
	public List<Tdto> list() {
		List<Tdto> list = new ArrayList<>();

		String sql = "select * from testboard order by bgroup desc, bstep asc";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				Tdto dto = new Tdto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	public Tdto viewContent(int bidnum) {
		Tdto dto = null;

		String sql = "select * from testboard where bid = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bidnum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new Tdto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void inset(String bname, String btitle, String bcontent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "insert into testboard (bid, bname, btitle,bcontent,bhit,bgroup,bstep,bindent) values(testboard_seq.nextval,?,?,?,0,testboard_seq.currval,0,0)";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);

			int rn = pstmt.executeUpdate();
			System.out.println("insert된 갯수" + rn);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void modify(int bidnum, String bname, String btitle, String bcontent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "update testboard set bname = ?, btitle = ?, bcontent = ? where bid = ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bidnum);

			int rn = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(int bidnum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "delete from testboard where bgroup = ? or bid = ?";

			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, bidnum);
			pstmt.setInt(2, bidnum);

			int rn = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void repliShape(int bgroupnum,int bstepnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "update into testboard set bstep = bstep + 1 where bgroup = ? and bstep > ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bgroupnum);
			pstmt.setInt(2, bstepnum);
		

			int rn = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void reply(int bidnum, String bname, String btitle, String bcontent, int bgroupnum, int bstepnum,
			int bindentnum) {
		repliShape(bgroupnum, bstepnum);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "insert into testboard (bid, bname, btitle,bcontent,bgroup,bstep,bindent) "
					+ "values(testboard_seq.nextval,?,?,?,?,?,?)";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroupnum);
			pstmt.setInt(5, bstepnum + 1);
			pstmt.setInt(6, bindentnum + 1);

			int rn = pstmt.executeUpdate();
			System.out.println("달린 댓글" + rn);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public Tdto replyView(int bidnum) {
		Tdto dto = null;

		String sql = "select * from testboard where bid = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bidnum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new Tdto(bid, bname, btitle, bcontent, 
						bdate, bhit, bgroup, bstep, bindent);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	public void increaseHit(int bidnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "update testboard set bhit = bhit + 1 where bid = ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bidnum);

			int rn = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
