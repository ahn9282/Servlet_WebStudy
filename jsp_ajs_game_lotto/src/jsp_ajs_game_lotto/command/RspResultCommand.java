package jsp_ajs_game_lotto.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ajs_game_lotto.vo.LottoVO;
import jsp_ajs_game_lotto.vo.RspVO;

public class RspResultCommand implements LottoCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String rsp = request.getParameter("rsp");
		System.out.println(rsp);
		RspVO com = new RspVO();
		if(rsp == null) rsp="no-state";
		System.out.println(rsp);
			RspVO user = new RspVO(rsp);
		
			user.img="https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAxNjEwMDdfMjQx%2FMDAxNDc1ODA5NzI3MTU0.hyt8VNKUQJUEfzYZgSvgW0PfvdV34QMh2NF1G73WE_kg.gTFZYfJpkMoq1x92WrdMCno1c7gWB02z7PAFPCdRqXsg.JPEG.minjea3636%2F2.jpg&type=a340";
		com.img="https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAxNjEwMDdfMjQx%2FMDAxNDc1ODA5NzI3MTU0.hyt8VNKUQJUEfzYZgSvgW0PfvdV34QMh2NF1G73WE_kg.gTFZYfJpkMoq1x92WrdMCno1c7gWB02z7PAFPCdRqXsg.JPEG.minjea3636%2F2.jpg&type=a340";
		request.setAttribute("com", com);
		request.setAttribute("user", user);
	}

}
