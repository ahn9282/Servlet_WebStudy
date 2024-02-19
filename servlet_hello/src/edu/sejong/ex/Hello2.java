package edu.sejong.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/hello2")
public class Hello2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append("Hello world?!!!").append("\n");
//		response.getWriter().append("I am a Programmer!!");
		response.setContentType(("text/html;charset = UTF-8"));
		PrintWriter wr = response.getWriter();
		wr.println("<html>");
		
		wr.println("<head>");
		
		wr.println("</head>");
		
		wr.println("<body>");
		wr.println("<h1>로그인 해요!!</h1>");
		
		wr.println("<form action=\"hello2\" method=\"post\">");
		
		wr.println("name : <input type=\"text\" name = \"name\" size = 10><br/>");
		wr.println("ID : <input type=\"text\" name = \"ID\" size = 10><br/>");
		wr.println("PW : <input type=\"password\" name = \"PW\" size = 10><br/>");
		wr.println("<hr>");
		
		wr.print("<input type=\"checkbox\" name = \"hobby\" value = \"요리\" >요리");
		wr.print("<input type=\"checkbox\" name = \"hobby\" value = \"달리기\" >달리기");
		wr.print("<input type=\"checkbox\" name = \"hobby\" value = \"수영\" >수영");
		wr.print("<input type=\"checkbox\" name = \"hobby\" value = \"잠 자기\" >잠자기");
		
		wr.println("<hr>");
		
		wr.println("<input type = \"radio\" name = \"major\" value=\"kor\">국어");
		wr.println("<input type = \"radio\" name = \"major\" value=\"eng\">영어");
		wr.println("<input type = \"radio\" name = \"major\" value=\"math\">수학");
		
		wr.println("<hr>");
		
		wr.println("<select name = \"protocol\">");
		wr.println("<option value = \"http\">http</option>");
		wr.println("<option value = \"ftp\"selected = \"selected\">ftp</option>");
		wr.println("<option value = \"smtp\">smtp</option>");
		wr.println("<option value = \"pop\">pop</option>");
		wr.println("</select></br>");
		
		wr.println("<hr>");
		
		wr.println("<input type=\"submit\" value=\"Log-in\">");
		wr.println("</form>");
		
		wr.println("</body>");
		
		wr.println("</html>");
		wr.close();
		
		System.out.println("안뇽하세요!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
