package entityJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "MauSac")
public class MauSac {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maMau;
	private String tenMau;
	
	public MauSac(String tenMau) {
		this.tenMau = tenMau;
	}
	
	public MauSac(int maMau, String tenMau) {
		this.maMau = maMau;
		this.tenMau = tenMau;
	}
}
