package jsp_ajs_game_lotto.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ajs_game_boarddto.Board_listDtio;
import jsp_ajs_game_lotto.vo.BoardVO;

public class BoardListCommand implements LottoCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	BoardVO bvo = new BoardVO();
	List<Board_listDtio> list = bvo.list();
	System.out.println(list.size());
	int listsize = list.size();
	request.setAttribute("list", list);
	request.setAttribute("list.size", listsize);
	
	}

}
