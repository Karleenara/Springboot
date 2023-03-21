package address;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AddressManager {
	Scanner k = new Scanner(System.in);
	int menu = 0;
	int menu2 = 0;
	int seq=0;

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("addresstest");
	EntityManager em = factory.createEntityManager();

	public void close() {
		em.close();
		factory.close();
	}

	public void ShowMenu() {
		System.out.println("1. 등록");
		System.out.println("2. 검색");
		System.out.println("3. 수정 (번호)");
		System.out.println("4. 삭제 (번호)");
		System.out.println("5. 전체출력");
		System.out.println("0. 종료");
		System.out.println();
		System.out.print("선택: ");
		menu = k.nextInt();
	}

	public void Start() {
		try {
			while (true) {
				ShowMenu();
				if (menu == 0) {
					break;
				} else if(menu == 1) {
					insert();
				} else if(menu == 2) {
					System.out.println("1. 이름으로");
					System.out.println("2. 전화번호");
					System.out.println("3. 이메일");
					System.out.print("선택: ");
					menu = k.nextInt();
					if(menu == 1) {
						searchName();
					} else if(menu==2) {
						searchPhone();
					} else if(menu==3) {
						searchEmail();
					}
					
				} else if(menu == 3) {
					update();
				} else if (menu == 5) {
					printAll();
				}
			}
		} catch (Exception e) {
			System.out.println("잘못입력");
		}
	}

	public void printAll() {
		TypedQuery<AddressDto> query = em.createQuery("select t from AddressDto t", AddressDto.class);
		List<AddressDto> list = query.getResultList();
		list.stream().forEach(e -> {
			System.out.println(e);
		});
	}
	
	public void insert() {
		AddressDto dto = new AddressDto();
		try {
			System.out.print("이름: ");
			dto.setName(k.next());
			System.out.print("전화번호: ");
			dto.setPhone(k.next());
			System.out.print("이메일: ");
			dto.setEmail(k.next());
			dto.setWdate(LocalDateTime.now());
			em.getTransaction().begin();
			em.persist(dto);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void searchName() {
		System.out.print("찾을 이름: ");
		String name = k.next();
		String sql = "select t from AddressDto t where t.name like :name";
		TypedQuery q = em.createQuery(sql, AddressDto.class);
		q.setParameter("name", "%"+name+"%");
		
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void searchPhone() {
		System.out.print("찾을 번호: ");
		String phone = k.next();
		String sql = "select t from AddressDto t where t.phone like :phone";
		TypedQuery q = em.createQuery(sql, AddressDto.class);
		q.setParameter("phone", "%"+phone+"%");
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(String.format("%d %s %s %s", item.getSeq(), item.getName(), item.getPhone(), item.getEmail()));
		});
	}
	
	public void searchEmail() {
		System.out.print("찾을 메일: ");
		String email = k.next();
		String sql = "select t from AddressDto t where t.email like :email";
		TypedQuery q = em.createQuery(sql, AddressDto.class);
		q.setParameter("phone", "%"+email+"%");
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void update() {
		AddressDto adrdto = new AddressDto();
		System.out.print("수정할 번호: ");
		seq = k.nextInt();
		adrdto.setSeq(seq);
		
		try {
			em.getTransaction().begin();
			AddressDto dto = em.find(AddressDto.class, seq);
			System.out.print("변경 이름:");
			String name = k.next();
			dto.setName(name);
			System.out.print("변경 번호:");
			String phone = k.next();
			dto.setPhone(phone);
			System.out.print("변경 메일:");
			String email = k.next();
			dto.setEmail(email);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
