package edu.sejon.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejon.ex.dao.MemberDao;
import edu.sejon.ex.dto.MemberDto;

public class MemberServiceImpl implements MemberService{

	@Override
	public MemberDto execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberDto member = dao.getMember("junsub");
		
		return member;
	}

	
}
