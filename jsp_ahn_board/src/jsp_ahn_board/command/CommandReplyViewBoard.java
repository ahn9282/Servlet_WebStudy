package jsp_ahn_board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ahn_board.dao.Tdao;
import jsp_ahn_board.dto.Tdto;

public class CommandReplyViewBoard implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bidnum = Integer.valueOf(request.getParameter("bid"));

		
		Tdao dao = new Tdao();
		Tdto dto = dao.replyView(bidnum);
		System.out.println("비아이디확인 : " + dto.getBid());
		System.out.println("비그룹확인 : " + dto.getBgroup());
		request.setAttribute("reply_view", dto);
		
	}

}
