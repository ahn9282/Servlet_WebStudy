package edu.sejong.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.dao.Bdao;
import edu.sejong.dto.Bdto;

public class WriteCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	String bname = request.getParameter("bname");
	String bcontent = request.getParameter("bcontent");
	String btitle = request.getParameter("btitle");
	
	Bdao dao = new Bdao();
			dao.write(bname,bcontent,btitle);
	}

}
