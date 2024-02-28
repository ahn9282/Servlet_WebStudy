package jsp_ahn_board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ahn_board.dao.Tdao;
import jsp_ahn_board.dto.Tdto;

public class CommandModifyBoard implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bidnum = Integer.valueOf(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		Tdao dao = new Tdao();
		dao.modify(bidnum,bname,btitle,  bcontent);
		
	}

}
