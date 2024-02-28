package jsp_ahn_board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_ahn_board.command.Command;
import jsp_ahn_board.command.CommandDeleteBoard;
import jsp_ahn_board.command.CommandListBoard;
import jsp_ahn_board.command.CommandModifyBoard;
import jsp_ahn_board.command.CommandReplyBoard;
import jsp_ahn_board.command.CommandReplyViewBoard;
import jsp_ahn_board.command.CommandViewContent;
import jsp_ahn_board.command.CommandWriteBoard;

/**
 * Servlet implementation class TCotroller
 */
@WebServlet("*.do")
public class TCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("do action() ..");
	doaction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do action() ..");
		doaction(request, response);
	}

	protected void doaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() ..");
		
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		Command comm = null;
		
		 String uri = request.getRequestURI();
		 String conP= request.getContextPath();
		 String command = uri.substring(conP.length());
		 
		 System.out.println("uri : " + uri);
			System.out.println("conPath : " + conP);
			System.out.println("com : " + command);
			
			if(command.equals("/list.do")) {
				
				comm = new CommandListBoard();
				comm.execute(request, response);
				viewPage="/list.jsp";
				
			}else if(command.equals("/content_view.do")) {
				
				comm = new CommandViewContent();
				comm.execute(request, response);
				viewPage="/content_view.jsp";
				
			}else if(command.equals("/write_view.do")) {
				
				viewPage="/write_view.jsp";
				
			}else if(command.equals("/write.do")) {
				
				comm = new CommandWriteBoard();
				comm.execute(request, response);
				viewPage="/list.do";
				
			}else if(command.equals("/modify.do")) {
				
				comm = new CommandModifyBoard();
				comm.execute(request, response);
				viewPage="/list.do";
				
			}else if(command.equals("/delete.do")) {
				
				comm = new CommandDeleteBoard();
				comm.execute(request, response);
				viewPage="/list.do";
				
			}else if(command.equals("/reply_view.do")) {
				
				comm = new CommandReplyViewBoard();
				comm.execute(request, response);
				viewPage="/reply_view.jsp";
				
			}else if(command.equals("/reply.do")) {
				
				comm = new CommandReplyBoard();
				comm.execute(request, response);
				viewPage="/list.do";
				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		
	}
}
