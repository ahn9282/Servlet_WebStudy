package edu.sejong.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.ex.dto.BDto;

public class BDao {

	// 커넥션 풀 객체
	private DataSource dataSource = null;

	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BDto> list() {
		List<BDto> dtos = new ArrayList<BDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from mvc_board order by bgroup desc, bstep asc";
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

				BDto dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);

			}

		} catch (Exception e) {
			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return dtos;

	}


		public void write(String bname, String btitle, String bcontent) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				
				int rn = pstmt.executeUpdate();
				System.out.println("insert된 갯수" + rn);
				
			} catch (Exception e) {
				try {
					
					if (pstmt != null)
						pstmt.close();
					
					if (con != null)
						con.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	public BDto contentView(String bid) {
				
				increasehit(bid);
				
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from mvc_board where bid = ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(bid));
			
			
			rs = pstmt.executeQuery();
			
			
			

			if (rs.next()) {
				int id = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BDto(id, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dto;

	}
	public void modify(String bid,String bname, String btitle, String bcontent) {
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "update mvc_board set bname = ?, btitle=?, bcontent = ? where bid = ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(4, Integer.valueOf(bid));
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);

			int rn = pstmt.executeUpdate();

		
		} catch (Exception e) {
			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	public BDto delete(String bid) {
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "delete from mvc_board where bid = ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(bid));

			rs = pstmt.executeQuery();

			
		} catch (Exception e) {
			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dto;

	}
	public void increasehit(String bid) {
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "update mvc_board set bhit = (select bhit from mvc_board where bid = ?) + 1 where bid = ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(bid));
			pstmt.setInt(2, Integer.valueOf(bid));
			

			int rn = pstmt.executeUpdate();

		
		} catch (Exception e) {
			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	public BDto replyView(String bid) {
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from mvc_board where bid = ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(bid));
			
			
			rs = pstmt.executeQuery();
			
			
			

			if (rs.next()) {
				int id = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BDto(id, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dto;

	}
	private void replyShape(String bgroup, String bstep) {
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "update mvc_board set bstep = bstep + 1 where bgroup = ? and bstep > ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(bgroup));
			pstmt.setInt(2, Integer.valueOf(bstep));

			int rn = pstmt.executeUpdate();
System.out.println("업데이트 스텝된 객수   : " + rn);
		
		} catch (Exception e) {
			try {


				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void reply(String bid, String bname, String btitle, String bcontent,String bgroup, String bstep, String bindent ) {

		replyShape(bgroup, bstep);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values \r\n"
		               + "(mvc_board_seq.nextval, ?, ?, ?, ?, ?, ? )";
		
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, Integer.valueOf(bgroup));
			pstmt.setInt(5, Integer.valueOf(bstep)+1);
			pstmt.setInt(6, Integer.valueOf(bindent)+1);

			int rn = pstmt.executeUpdate();
			System.out.println("댓글" + rn);

		} catch (Exception e) {
			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}