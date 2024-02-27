package edu.sejon.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class front_controller
 */

@WebServlet("/dispatch")
public class DispatchCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatchCotroller() {
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
		System.out.println("doaction() ..");
		
		
		request.setAttribute("id", "abcde");
		request.setAttribute("pw", "12345");
		
		//서블릿 파일에서 jsp로 request를 forwarding 하는 구문
		RequestDispatcher dispatcher = request.getRequestDispatcher("/show.jsp");
		dispatcher.forward(request, response);
	}

}
