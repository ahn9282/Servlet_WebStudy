package edu.sejong.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.command.BCommand;
import edu.sejong.ex.command.BContentCommand;
import edu.sejong.ex.command.BDeleteCommand;
import edu.sejong.ex.command.BListCommand;
import edu.sejong.ex.command.BModifyCommand;
import edu.sejong.ex.command.BReplyCommand;
import edu.sejong.ex.command.BReplyViewCommand;
import edu.sejong.ex.command.BWriteCommand;

/**
 * Servlet implementation class front_controller
 */

@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() ..");

		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() ..");

		actionDo(request, response);
	}

	// actionDo로 Get과 Post의 처리를 모은다
	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo() ..");

		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		BCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("com : " + com);

		if (com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";

		} else if (com.equals("/write_view.do")) {

			viewPage = "write_view.jsp";

		} else if (com.equals("/write.do")) {

			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "/list.do";
			
		} else if (com.equals("/content_view.do")) {

			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
			
		}else if (com.equals("/modify.do")) {

			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "/list.do";
			
		}else if (com.equals("/delete.do")) {

			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "/list.do";
			
		}else if (com.equals("/reply_view.do")) {

			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "/reply_view.jsp";
			
		}else if (com.equals("/reply.do")) {

			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "/list.do";
			
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
