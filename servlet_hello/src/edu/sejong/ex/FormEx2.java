package edu.sejong.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/FormEx2")
public class FormEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(("text/html;charset = UTF-8"));
		PrintWriter wr = response.getWriter();
		wr.println("<html>");
		wr.println("<body>");
		wr.println("<form action=\"FormEx2\" method=\"post\">");
		wr.println("국어: <input type=\"text\" name = \"kor\" size = 10><br/>");
		wr.println("영어 : <input type=\"text\" name = \"eng\" size = 10><br/>");
		wr.println("수학 : <input type=\"text\" name = \"math\" size = 10><br/>");
		wr.println("<input type=\"submit\" value=\"Log-in\">");
		wr.println("</form>");
		wr.println("</body>");
		wr.println("</html>");
		wr.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() ..");
		response.setContentType(("text/html;charset = UTF-8"));
		request.setCharacterEncoding("UTF-8");
		
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String math = request.getParameter("math");
		int sum = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
		double avg = sum / 3.0;
		PrintWriter wr = response.getWriter();
		wr.println("<html>");
		
		wr.println("<head>");
		
		wr.println("</head>");
		
		wr.println("<body>");
		wr.println("<h1>국어 :"+ kor + "</h1>");
		wr.println("<h1>영어 :"+ eng + "</h1>");
		wr.println("<h1>수학 :"+ math + "</h1>");
		wr.println("<h1>총점 :"+ sum + "</h1>");
		wr.println("<h1>평균 :"+ avg + "</h1>");
		
		wr.println("</body>");
		wr.close();
		System.out.println("Post 호출!!");	
		}

}
