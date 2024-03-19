package jsp_ajs_game_lotto.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ajs_game_lotto.command.BoardAddCommand;
import jsp_ajs_game_lotto.command.BoardDeleteCommand;
import jsp_ajs_game_lotto.command.BoardListCommand;
import jsp_ajs_game_lotto.command.BoardUpdateCommand;
import jsp_ajs_game_lotto.command.BoardViewCommand;
import jsp_ajs_game_lotto.command.LottoCommand;
import jsp_ajs_game_lotto.command.LottoListCommand;
import jsp_ajs_game_lotto.command.RspResultCommand;

/**
 * Servlet implementation class lottoController
 */
@WebServlet("*.do")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() .. ");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() .. ");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo() .. ");

		request.setCharacterEncoding("UTF-8");

		LottoCommand command = null;
		String viewPage = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commandDo = uri.substring(conPath.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("commandDo : " + commandDo);

		if (commandDo.equals("/lotto.do")) {

			command = new LottoListCommand();
			command.execute(request, response);
			viewPage = "/lotto_list.jsp";

		} else if (commandDo.equals("/rsp.do")) {

			command = new RspResultCommand();
			command.execute(request, response);
			viewPage = "/rsp_game.jsp";

		}else if (commandDo.equals("/board.do")) {

			command = new BoardListCommand();
			command.execute(request, response);
			viewPage = "/board_list.jsp";

		}else if (commandDo.equals("/boarddelete.do")) {

			command = new BoardDeleteCommand();
			command.execute(request, response);
			viewPage = "/board.do";

		}else if (commandDo.equals("/boardupdate.do")) {
			String str=request.getParameter("bid");
			
			request.setAttribute("bid", str);
			command = new BoardViewCommand();
			command.execute(request, response);
			viewPage = "/boardupdate.jsp";

		}else if (commandDo.equals("/updateact.do")) {

			command = new BoardUpdateCommand();
			command.execute(request, response);
			viewPage = "/board.do";

		}else if (commandDo.equals("/gugudan.do")) {	
			viewPage = "/gugudan.jsp";

		}else if (commandDo.equals("/board_add.do")) {

			command = new BoardAddCommand();
			command.execute(request, response);
			viewPage = "/board.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}