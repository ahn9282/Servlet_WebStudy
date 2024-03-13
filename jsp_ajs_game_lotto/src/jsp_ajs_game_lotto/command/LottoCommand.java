package jsp_ajs_game_lotto.command
;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LottoCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
		
	

}


