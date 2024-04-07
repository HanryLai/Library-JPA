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
@Table(name = "HoaDonDoiHang")
public class HoaDonDoiHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maHoaDonDoi;
	
	private String hoaDonHoanTra;
	private String ghiChu;
	private float tienHoanTra;
	private float chietKhau;
	private String khuyenMai;
	
	public HoaDonDoiHang(String hoaDonHoanTra, String ghiChu, float tienHoanTra, float chietKhau, String khuyenMai) {
		super();
		this.hoaDonHoanTra = hoaDonHoanTra;
		this.ghiChu = ghiChu;
		this.tienHoanTra = tienHoanTra;
		this.chietKhau = chietKhau;
		this.khuyenMai = khuyenMai;
	}
	
	
	
}
