package entityJPA;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "NhomSanPham")
public class NhomSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhomSanPham;
	
	private String tenNhomSanPham;
	
	@OneToMany(mappedBy = "nhomSanPham")
	private Set<SanPham> sanPham;
	
	@Override
	public String toString() {
		return "NhomSanPham [maNhomSanPham=" + maNhomSanPham + ", tenNhomSanPham=" + tenNhomSanPham + "]";
	}

	
}
