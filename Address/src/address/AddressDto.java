package address;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(name="ADDERESS_SEQ_GENERATOR",
sequenceName="SEQ_ADDERESS",
initialValue=1,
allocationSize=100)
@Entity
@Table(name="address")
public class AddressDto {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_ADDRESS")
	private int seq;
	private String name;
	private String phone;
	private String email;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime wdate;
	
	public AddressDto() {
		super();
	}

	public AddressDto(int seq, String name, String phone, String email, LocalDateTime wdate) {
		super();
		this.seq = seq;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.wdate = wdate;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return String.format("%d %s %s %s %s", seq, name, phone, email, wdate);
	}
	
	
	
	
	
}
