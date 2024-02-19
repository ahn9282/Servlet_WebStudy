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
 * Servlet implementation class TestLogin
 */
@WebServlet("/TestLogin")
public class TestLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(("text/html;charset = UTF-8"));
		PrintWriter wr = response.getWriter();
		wr.println("<html>");
		
		wr.println("<head>");
		
		wr.println("</head>");
		
		wr.println("<body>");
		wr.println("<h1>로그인 해요!!</h1>");
		
		wr.println("<form action=\"TestLogin\" method=\"post\">");
		
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
		wr.println("<body>");
		wr.println("<h1>이름 :"+ name);
		wr.println("<h1>아이디 :"+ id + "</h1>");
		wr.println("<h1>취미 :"+ Arrays.toString(hobbys));
		wr.println("<h1>전공 :"+ major + "</h1>");
		wr.println("<h1>프로토콜 :"+ protocol + "</h1>");
		wr.println("<form action=\"TestLogin\" method=\"get\">");
		wr.println("<input type=\"submit\" value=\"Log-Out\">");
		wr.println("</form>");
		wr.println("<form action=\"FormEx\" method=\"post\">");
		wr.println("<input type=\"submit\" value=\"마이페이지\">");
		wr.println("</form>");
		wr.println("</head>");
		
		wr.println("</body>");
		wr.close();
	}

}
