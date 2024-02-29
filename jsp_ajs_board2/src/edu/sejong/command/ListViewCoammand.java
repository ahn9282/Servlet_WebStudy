package edu.sejong.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.dao.Bdao;
import edu.sejong.dto.Bdto;

public class ListViewCoammand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Bdao dao = new Bdao();
		List<Bdto> list = dao.list();
		System.out.println("확인 : " + list.size());
		request.setAttribute("list", list);
	}

}
