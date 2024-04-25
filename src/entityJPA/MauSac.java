package entityJPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "MauSac")
public class MauSac implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maMau;

	@Column(columnDefinition = "nvarchar(50)")
	private String tenMau;

	@OneToOne(mappedBy = "mauSac")
	private VanPhongPham vanPhongPham;
	
	public MauSac(String tenMau) {
		this.tenMau = tenMau;
	}
	
	public MauSac(int maMau, String tenMau) {
		this.maMau = maMau;
		this.tenMau = tenMau;
	}

	@Override
	public String toString() {
		return "MauSac [maMau=" + maMau + ", tenMau=" + tenMau + "]";
	}
}
