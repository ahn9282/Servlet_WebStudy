package edu.sejong.ex.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

@WebServlet("/context")
public class ContextExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public ContextExample() {
		super();
		System.out.println("생성자 호출");
	}
	@PostConstruct
	private void initPostConstruct() {
		System.out.println("initPostConstruct...");
	}
@PreDestroy
private void destroyPreDestroy() {
	System.out.println("destroyPreDestroy...");
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kor = getServletContext().getInitParameter("kor");
		String eng= getServletContext().getInitParameter("eng");
		String math = getServletContext().getInitParameter("math");

		System.out.println("성적 : " + kor + eng + math);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	

}
