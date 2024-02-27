package edu.sejon.ex.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejon.ex.dao.MemberDao;
import edu.sejon.ex.dto.MemberDto;

public class MemberListCommand implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.printMember();
		request.setAttribute("list", list);
	}

}
