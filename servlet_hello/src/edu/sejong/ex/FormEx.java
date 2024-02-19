package edu.sejong.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/FormEx")
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() ..");
		response.setContentType(("text/html;charset = UTF-8"));
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String[] hobbys = request.getParameterValues("hobby");//체크박스 처리 
									//다수의 값들 처리
		String major = request.getParameter("major");//옵션 처리
		String protocol = request.getParameter("protocol");
		
		PrintWriter wr = response.getWriter();
		wr.println("<html>");
		
		wr.println("<head>");
		
		wr.println("</head>");
		
		wr.println("<body>");
		wr.println("<h1>이름 :"+ name + "</h1>");
		wr.println("<h1>아이디 :"+ id + "</h1>");
		wr.println("<h1>pw :"+ pw + "</h1>");
		wr.println("<h1>취미 :"+ Arrays.toString(hobbys) + "</h1>");
		wr.println("<h1>전공 :"+ major + "</h1>");
		wr.println("<h1>프로토콜 :"+ protocol + "</h1>");
		
		wr.println("</body>");
		wr.close();
		System.out.println("Post 호출!!");	
		}

}
