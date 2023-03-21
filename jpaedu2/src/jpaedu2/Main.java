package jpaedu2;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
		EntityManager em = factory.createEntityManager();
		
		EmpDto dto = new EmpDto();
		dto.setEmpno(8000);
		dto.setEname("길똥");
		dto.setHiredate(Date.valueOf("2023-02-21"));
		dto.setDept(new DeptDto(10));
		dto.setJob("개발자");
		dto.setSal(8000L);	// long 형 상수 숫자뒤에 l 또는 L 붙임
		dto.setComm(200);
		
		em.getTransaction().begin();
		em.persist(dto);	// 데이터 추가
		em.getTransaction().commit();
		
		TypedQuery<EmpDto> q = em.createQuery("select a from EmpDto a", EmpDto.class);
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(e->{
			System.out.println(e.ename + " " + e.getDept().deptno +" " + e.getDept().dname);
		});
		
		em.close();
		factory.close();
	}
}
