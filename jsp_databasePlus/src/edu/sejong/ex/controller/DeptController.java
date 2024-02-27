package edu.sejong.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.command.DeptCommand;
import edu.sejong.ex.command.DeptDeleteCommand;
import edu.sejong.ex.command.DeptInsertCommand;
import edu.sejong.ex.command.DeptListCommand;
import edu.sejong.ex.command.DeptUpdateCommand;

/**
 * Servlet implementation class DeptController
 */
@WebServlet("/dept/*")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-------------------------------------------------------");
		System.out.println("doGet() ..");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------------------------------------------------");
		System.out.println("doPost() ..");
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("actionDo() ..");
		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		DeptCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commandDo = uri.substring(conPath.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("commandDo : " + commandDo);

		if (commandDo.equals("/dept/list.do")) {
			command = new DeptListCommand();
			command.execute(request, response);
			viewPage = "/dept_mvc_list.jsp";

			request.setAttribute("depts", request.getAttribute("depts"));

		} else if (commandDo.equals("/dept/insert.do")) {

			command = new DeptInsertCommand();
			command.execute(request, response);

			viewPage = "/dept/list.do";

		} else if (commandDo.equals("/dept/delete.do")) {

			command = new DeptDeleteCommand();
			command.execute(request, response);

			viewPage = "/dept/list.do";

		} else if (commandDo.equals("/dept/update.do")) {

			command = new DeptUpdateCommand();
			command.execute(request, response);

			viewPage = "/dept/list.do";

		} 

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
