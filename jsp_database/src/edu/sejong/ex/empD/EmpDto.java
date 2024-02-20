package edu.sejong.ex.empD;

public class EmpDto {
	private String empno;
	private String ename;
	private String job;
	private String mgr;
	private String deptno;
	private String comm;
	public EmpDto() {
		
	}
	public EmpDto(String empno, String ename, String job, String mgr, String deptno, String comm) {
		// TODO Auto-generated constructor stub
	this.empno=empno;
	this.ename=ename;
	this.job=job;
	this.mgr=mgr;
	this.deptno=deptno;
	this.comm=comm;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
@Override
public String toString() {
	return "부서번호 :  " +this.getDeptno()+ 
			" || 사원 이름 : " +this.getEname()+ 
			" || 직업 : " +this.getJob()+ 
			" || 커미션 : " +this.getComm()+ 
			" || 매니저 : " +this.getMgr()+ 
			" || 사원번호 : " +this.getEmpno()+ "<br>";
}
}
