package jpaeduexam.test;

import java.util.Scanner;

import jpeaduexam.dao.EmpDao;

public class EmpTest {
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		Scanner sc = new Scanner(System.in);
//		dao.printAll();
//	
//		//입력시 S%
//		System.out.println("찾을 이름 : ");
//		String name = sc.next();
//		dao.searchName(name);
//		
//		//F, A
//		System.out.println("직업 : ");
//		String job = sc.next();
//		dao.searchNameAndJob2(name, job);
		
		dao.groupFunctionTest();
		dao.updateSal2(7902, 99999);
		dao.close();
	}
}