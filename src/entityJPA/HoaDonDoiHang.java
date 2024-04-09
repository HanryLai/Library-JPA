package entityJPA;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "HoaDonDoiHang")
public class HoaDonDoiHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoaDonDoi;
	
	@OneToMany(mappedBy = "hoaDonDoiHang")
	private List<ChiTietDoiHang> chiTietDoiHang;
	
	@OneToOne
    @JoinColumn(name = "maHoaDonHoanTra")
    private HoaDonHoanTra hoaDonHoanTra;

	
	private String ghiChu;
	private float tienHoanTra;
	private float chietKhau;
	private String khuyenMai;
}
