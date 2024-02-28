package jsp_ahn_board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ahn_board.dao.Tdao;
import jsp_ahn_board.dto.Tdto;

public class CommandListBoard implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Tdao dao = new Tdao();
		List<Tdto> list = dao.list();
		request.setAttribute("list", list);
		
	}

}
