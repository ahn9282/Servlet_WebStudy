package edu.sejong.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gugudan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ..");
		response.setContentType(("text/html;charset = UTF-8"));
		request.setCharacterEncoding("UTF-8");
      String gugu = request.getParameter("gugudan");  
      int num = Integer.parseInt(gugu);
      
      PrintWriter wr = response.getWriter();
		wr.println("<html>");
		
		wr.println("<head>");
		
		wr.println("</head>");
        
        wr.println("<body>");
		wr.println("<h1>"+num +" 단 </h1>");
		
        
        for(int i = 1; i<=9;i++) {
        	wr.println("<h1>"+num+" X "+i+" = "+ (num * i) + "</h1>");
        }
		
		
		wr.println("</body>");
		wr.close();
	}

}
