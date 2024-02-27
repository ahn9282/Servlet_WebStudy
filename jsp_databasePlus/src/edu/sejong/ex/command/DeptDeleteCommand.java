package edu.sejong.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.DeptDao;
import edu.sejong.ex.vo.DeptVO;

public class DeptDeleteCommand implements DeptCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int deptno = Integer.valueOf(request.getParameter("deptno"));
		
		DeptVO dv = new DeptVO();
		dv.setDeptno(deptno);
		DeptDao dao = new DeptDao();
		dao.delete(dv);
	}

}
