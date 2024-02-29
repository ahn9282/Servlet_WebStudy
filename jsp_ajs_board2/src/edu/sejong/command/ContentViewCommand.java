package edu.sejong.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.dao.Bdao;
import edu.sejong.dto.Bdto;

public class ContentViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	int bidnum = Integer.valueOf(request.getParameter("bid"));
	System.out.println("확인 : " + bidnum);
	Bdao dao = new Bdao();
	dao.increaseHit(bidnum);
			Bdto dto = dao.view(bidnum);
			request.setAttribute("content_view", dto);
	}

}
