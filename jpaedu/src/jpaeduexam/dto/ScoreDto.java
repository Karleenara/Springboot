package jpaeduexam.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// 오라클 시퀀스 - 어노테이션을 이용해 오라클에 SEQ_SCORE 이라는 시퀀스 만들어짐
// RDBMS 중에서 오라클만 필요. 다른 dbms 필요 없음
@SequenceGenerator(name="SCORE_SEQ_GENERATOR",
						sequenceName="SEQ_SCORE",
						initialValue=1,
						allocationSize=10)
// RDBMS 테이블과 DTO 개체 연결
@Entity
// oracle의 TB_SCORE라는 이름의 table 생성
@Table(name="TB_SCORE")
public class ScoreDto {
	// primary key 로 사용
	@Id		 
	// 자동 생성, DBMS마다 다르게 표시
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_SCORE")	
	private int seq;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime wdate;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}
	
	
}
