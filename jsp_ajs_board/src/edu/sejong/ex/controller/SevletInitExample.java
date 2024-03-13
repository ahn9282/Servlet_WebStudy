package edu.sejong.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class front_controller
 */

//@WebServlet("/linitServlet")
@WebServlet(urlPatterns = {"/test","/test2"}, 
initParams = { @WebInitParam(name = "id", value="abcd"),@WebInitParam(name = "pw", value="1234")})
public class SevletInitExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SevletInitExample() {
		super();
		System.out.println("생성자 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do get() ..");
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		
		System.out.println("id : " + id + " pw : " + pw);
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();

		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id);
		writer.println("패스워드 : " + pw);
		
		String kor = getServletContext().getInitParameter("kor");
		String eng= getServletContext().getInitParameter("eng");
		String math = getServletContext().getInitParameter("math");

		System.out.println("성적 : " + kor + eng + math);

		writer.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
