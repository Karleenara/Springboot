package jpaedu2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class DeptDto {
	@Id
	int deptno;
	String dname;
	String loc_code;
	
	public DeptDto() {
		
	}
	
	// EmpDto 객체 insert 시 사용
	public DeptDto(int deptno) {
		super();
		this.deptno = deptno;
		this.dname = "";
		this.loc_code = "";
	}
	
	// DeptDto 객체 insert시 사용 
	public DeptDto(int deptno, String dname, String loc_code) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc_code = loc_code;
	}
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc_code() {
		return loc_code;
	}
	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}
	
	
}
