package jsp_ajs_game_lotto.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ajs_game_lotto.vo.LottoVO;

public class LottoListCommand implements LottoCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		LottoVO lotto = new LottoVO();
		request.setAttribute("lotto", lotto);
	}

}
