package jpaeduexam.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// 테이블명과 클래스 이름이 다를 때 꼭 이 어노테이션 써야함
@Table(name="emp")
public class EmpDto {
	@Id
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate; 
	private int sal;
	private Integer comm;
	private Integer deptno;
	
	public EmpDto() {
		super();
	}
	
	
	@Override
	public String toString() {
		return String.format("%d %s %d %d %d %s %d", empno,ename, deptno, sal, comm, hiredate, mgr);
	}



	public EmpDto(int empno, String ename, Date hiredate, int sal, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
		this.deptno = deptno;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
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
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	
}
