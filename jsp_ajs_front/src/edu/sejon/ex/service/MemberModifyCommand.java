package edu.sejon.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejon.ex.dao.MemberDao;
import edu.sejon.ex.dto.MemberDto;

public class MemberModifyCommand implements MemberCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		 String pw= request.getParameter("pw");
		 String email= request.getParameter("email");
		 String address= request.getParameter("address");
		 
		 MemberDto dto = new MemberDto(id,pw,email,address);
		 MemberDao dao = new MemberDao();
		 dao.modifyMember(dto);
	}

}
