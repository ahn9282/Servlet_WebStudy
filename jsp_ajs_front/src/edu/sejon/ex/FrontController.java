package edu.sejon.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejon.ex.dto.MemberDto;
import edu.sejon.ex.service.MemberCommand;
import edu.sejon.ex.service.MemberDeleteCommand;
import edu.sejon.ex.service.MemberInsertCommand;
import edu.sejon.ex.service.MemberListCommand;
import edu.sejon.ex.service.MemberModifyCommand;
import edu.sejon.ex.service.MemberService;
import edu.sejon.ex.service.MemberServiceImpl;

/**
 * Servlet implementation class front_controller
 */

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
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
	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo() ..");

		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);

		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);

		String command = uri.substring(contextPath.length());
		System.out.println("command : " + command);

		MemberService service = null;
		MemberCommand mCommand = null;
		String viewPage=null;

		if (command.equals("/insert.do")) {
			System.out.println("데이터 추가 처리");
			System.out.println("-------------------------------");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			mCommand = new MemberInsertCommand();

			PrintWriter writer = response.getWriter();

			mCommand.execute(request, response);
			writer.println("<html><head></head><body>");

			writer.println("유저가 추가되었음");
			writer.println("</body></html>");

		} else if (command.equals("/select.do")) {

			System.out.println("데이터 보여 주기");
			System.out.println("-------------------------------");
			response.setContentType("text/html;charset=UTF-8");

			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");

			service = new MemberServiceImpl();
			MemberDto member = service.execute(request, response);

			writer.println("아이디 : " + member.getId() + "<br>");
			writer.println("패스워드 : " + member.getPw() + "<br>");
			writer.println("이메일 : " + member.getEmail() + "<br>");
			writer.println("주소 : " + member.getAddress() + "<br>");

			writer.println("여기서 DAO 객체 생성 후 데이터 가져와서 보여주기");
			writer.println("</body></html>");

		} else if (command.equals("/modify.do")) {

			System.out.println("업데이트된 데이터 보여 주기");
			System.out.println("-------------------------------");

			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");

			mCommand = new MemberModifyCommand();

			PrintWriter writer = response.getWriter();

			mCommand.execute(request, response);

			writer.println("<html><head></head><body>");

			writer.println("업데이트 되었습니다.");

			writer.println("</body></html>");

		}  else if (command.equals("/delete.do")) {

			System.out.println("멤버 삭제");
			System.out.println("-------------------------------");

			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");

			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			mCommand = new MemberDeleteCommand();


			mCommand.execute(request, response);


			writer.println("삭제 되었습니다.");

			writer.println("</body></html>");
			
		}  else if (command.equals("/list.do")) {
			System.out.println("멤버 나열");
			System.out.println("-------------------------------");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");

			mCommand = new MemberListCommand();
			mCommand.execute(request, response);


			List<MemberDto> list = (List<MemberDto>) request.getAttribute("list");
			request.setAttribute("list", list);
			 viewPage = "member_list.jsp";

		}
			if(viewPage != null) {
			RequestDispatcher dispatcher = 
			        request.getRequestDispatcher(viewPage);
					dispatcher.forward(request, response);
			}

	}

}
