package edu.sejong.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.DeptDao;
import edu.sejong.ex.vo.DeptVO;

public class DeptInsertCommand implements DeptCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int deptno = Integer.valueOf(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		DeptVO dv = new DeptVO(deptno, dname, loc);
		DeptDao dao = new DeptDao();
		dao.insert(dv);
		
	}

}
