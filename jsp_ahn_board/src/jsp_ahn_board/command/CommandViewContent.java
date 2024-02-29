package jsp_ahn_board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ahn_board.dao.Tdao;
import jsp_ahn_board.dto.Tdto;

public class CommandViewContent implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		int bidnum = Integer.valueOf(bid);
		Tdao dao = new Tdao();
		dao.increaseHit(bidnum);

		Tdto dto = dao.viewContent(bidnum);
		request.setAttribute("content_view", dto);

	}

}
