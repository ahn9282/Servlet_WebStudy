package jsp_ajs_game_lotto.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ajs_game_boarddto.Board_listDtio;
import jsp_ajs_game_lotto.vo.BoardVO;

public class BoardViewCommand implements LottoCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bidnumber = request.getParameter("bid");
	BoardVO vo = new BoardVO();
	vo.increaseHit(bidnumber);
	Board_listDtio dto = vo.view(bidnumber);
	request.setAttribute("dto", dto);
	
	}

}
