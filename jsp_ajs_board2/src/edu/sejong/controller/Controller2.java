package edu.sejong.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.command.Command;
import edu.sejong.command.ContentViewCommand;
import edu.sejong.command.DeleteCoammand;
import edu.sejong.command.ListViewCoammand;
import edu.sejong.command.ModifyCommand;
import edu.sejong.command.ReplyCommand;
import edu.sejong.command.ReplyViewCommand;
import edu.sejong.command.WriteCommand;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("*.do")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do get() ..");
		doAction(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do post() ..");
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo() ..");

		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		Command comm = null;

		String uri = request.getRequestURI();
		String conP = request.getContextPath();
		String command = uri.substring(conP.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conP);
		System.out.println("com : " + command);

		if (command.equals("/list.do")) {

			comm = new ListViewCoammand();
			comm.execute(request, response);
			viewPage = "/board_tables.jsp";

		} else if (command.equals("/write_view.do")) {

			viewPage = "/write_view.jsp";

		} else if (command.equals("/write.do")) {

			comm = new WriteCommand();
			comm.execute(request, response);
			viewPage = "/list.do";

		} else if (command.equals("/content_view.do")) {
			comm = new ContentViewCommand();
			comm.execute(request, response);
			System.out.println();
			viewPage = "/content_view.jsp";

		} else if (command.equals("/delete.do")) {
			comm = new DeleteCoammand();
			comm.execute(request, response);
			viewPage = "/list.do";

		} else if (command.equals("/modify.do")) {
			comm = new ModifyCommand();
			comm.execute(request, response);
			viewPage = "/list.do";

		} else if (command.equals("/reply_view.do"))

		{
			comm = new ReplyViewCommand();
			comm.execute(request, response);
			viewPage = "/reply_view.jsp";

		} else if (command.equals("/reply.do")) {
			comm = new ReplyCommand();
			comm.execute(request, response);
			viewPage = "/list.do";

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
