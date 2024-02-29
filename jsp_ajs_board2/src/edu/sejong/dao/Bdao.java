package edu.sejong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.dto.Bdto;

public class Bdao {
	private DataSource dataSource = null;

	public Bdao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Bdto> list(){
		List<Bdto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from testboard order by bgroup desc, bstep asc";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				Bdto dto = new Bdto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				list.add(dto);
			}
			
		} catch (Exception e) {
			
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null)  pstmt.close();
				if(conn != null)  conn.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}
	public void write(String bname,String btitle,String bcontent){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "insert into testboard (bid, bname, btitle,bcontent,bhit,bgroup,bstep,bindent)\r\n" + 
					"values(testboard_seq.nextval,?,?,?,0,testboard_seq.currval,0,0)";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bname);
			pstmt.setString(2,btitle);
			pstmt.setString(3,bcontent);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null)  pstmt.close();
				if(conn != null)  conn.close();
			} catch (Exception e2) {
			}
		}
	}
	public Bdto view(int bidnum){
		Bdto dto = new Bdto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from testboard where bid =? or bgroup = ?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bidnum);
			pstmt.setInt(2, bidnum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				dto = new Bdto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
			
		} catch (Exception e) {
			
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null)  pstmt.close();
				if(conn != null)  conn.close();
			} catch (Exception e2) {
			}
		}
		return dto;
	}
public void delete(int bidnum){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "delete from testboard where bid = ?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bidnum);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null)  pstmt.close();
				if(conn != null)  conn.close();
			} catch (Exception e2) {
			}
		}
	}
public void modify(int bidnum,String bname,String btitle,String bcontent){
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "update testboard set bname = ?, btitle = ?, bcontent = ? where bid = ?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bname);
		pstmt.setString(2,btitle);
		pstmt.setString(3,bcontent);
		pstmt.setInt(4, bidnum);
		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		
	}finally {
		try {
			if(rs != null)  rs.close();
			if(pstmt != null)  pstmt.close();
			if(conn != null)  conn.close();
		} catch (Exception e2) {
		}
	}
}
public Bdto replyView(int bidnum){
	Bdto dto = new Bdto();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "select * from testboard where bid =?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bidnum);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			int bid = rs.getInt("bid");
			String bname = rs.getString("bname");
			String btitle = rs.getString("btitle");
			String bcontent = rs.getString("bcontent");
			Timestamp bdate = rs.getTimestamp("bdate");
			int bhit = rs.getInt("bhit");
			int bgroup = rs.getInt("bgroup");
			int bstep = rs.getInt("bstep");
			int bindent = rs.getInt("bindent");
			dto = new Bdto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
		}
		
	} catch (Exception e) {
		
	}finally {
		try {
			if(rs != null)  rs.close();
			if(pstmt != null)  pstmt.close();
			if(conn != null)  conn.close();
		} catch (Exception e2) {
		}
	}
	return dto;
}
public void reply(int bidnum, String bname,String btitle,String bcontent,int bgroupnum,int bstepnum, int bindentnum){
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	replyShape( bgroupnum, bstepnum);
	
	try {
		String sql = "insert into testboard (bid, bname, btitle,bcontent,bgroup,bstep,bindent)\r\n" + 
				"values(testboard_seq.nextval,?,?,?,?,?,?)";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bname);
		pstmt.setString(2,btitle);
		pstmt.setString(3,bcontent);
		pstmt.setInt(4, bgroupnum);
		pstmt.setInt(5, bstepnum+1);
		pstmt.setInt(6, bindentnum+1);
		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		
	}finally {
		try {
			if(rs != null)  rs.close();
			if(pstmt != null)  pstmt.close();
			if(conn != null)  conn.close();
		} catch (Exception e2) {
		}
	}
}
public void replyShape(int bgroupnum,int bstepnum){
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "update testboard set bstep = bstep =1 where bgroup = ? and step > ?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bgroupnum);
		pstmt.setInt(2, bstepnum);
		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		
	}finally {
		try {
			if(rs != null)  rs.close();
			if(pstmt != null)  pstmt.close();
			if(conn != null)  conn.close();
		} catch (Exception e2) {
		}
	}
}
public void increaseHit(int bidnum){
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "update testboard set bhit = bhit +1 where bid = ?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
	
		pstmt.setInt(1, bidnum);
		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		
	}finally {
		try {
			if(rs != null)  rs.close();
			if(pstmt != null)  pstmt.close();
			if(conn != null)  conn.close();
		} catch (Exception e2) {
		}
	}
}

}
