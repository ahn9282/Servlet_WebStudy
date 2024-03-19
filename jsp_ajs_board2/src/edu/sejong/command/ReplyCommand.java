package edu.sejong.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.dao.Bdao;
import edu.sejong.dto.Bdto;

public class ReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bidnum = Integer.valueOf(request.getParameter("bid"));
	String bname = request.getParameter("bname");
	String bcontent = request.getParameter("bcontent");
	String btitle = request.getParameter("btitle");
	int bgroupnum = Integer.valueOf(request.getParameter("bgroup"));
	int bstepnum = Integer.valueOf(request.getParameter("bstep"));
	int bindentnum = Integer.valueOf(request.getParameter("bindent"));
	Bdao dao = new Bdao();
			dao.reply(bidnum, bname,bcontent,btitle,bgroupnum,bstepnum,bindentnum);
	}

}
