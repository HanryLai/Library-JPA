package entityJPA;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "HoaDonDoiHang")
public class HoaDonDoiHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoaDonDoi;
	
	@OneToMany(mappedBy = "hoaDonDoiHang")
	private Set<ChiTietDoiHang> chiTietDoiHang;
	
	@OneToOne
    @JoinColumn(name = "maHoaDonHoanTra")
    private HoaDonHoanTra hoaDonHoanTra;

	@Column(columnDefinition = "nvarchar(500)")
	private String ghiChu;
	private float tienHoanTra;
	private float chietKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String khuyenMai;

	public HoaDonDoiHang(HoaDonHoanTra hoaDonHoanTra, String ghiChu, float tienHoanTra, float chietKhau, String khuyenMai) {
		this.hoaDonHoanTra = hoaDonHoanTra;
		this.ghiChu = ghiChu;
		this.tienHoanTra = tienHoanTra;
		this.chietKhau = chietKhau;
		this.khuyenMai = khuyenMai;
	}

	@Override
	public String toString() {
		return "HoaDonDoiHang{" +
				"maHoaDonDoi=" + maHoaDonDoi +
				", hoaDonHoanTra=" + hoaDonHoanTra.getMaHoaDonHoanTra() +
				", ghiChu='" + ghiChu + '\'' +
				", tienHoanTra=" + tienHoanTra +
				", chietKhau=" + chietKhau +
				", khuyenMai='" + khuyenMai + '\'' +
				'}';
	}
}
