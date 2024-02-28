package jsp_ahn_board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ahn_board.dao.Tdao;
import jsp_ahn_board.dto.Tdto;

public class CommandDeleteBoard implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bidnum = Integer.valueOf(request.getParameter("bid"));

		
		Tdao dao = new Tdao();
		dao.delete(bidnum);
		
	}

}
