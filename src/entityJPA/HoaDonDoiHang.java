package entityJPA;

import java.io.Serializable;
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
public class HoaDonDoiHang implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoaDonDoi;
	
	@OneToMany(mappedBy = "hoaDonDoiHang",fetch = FetchType.LAZY)
	private List<ChiTietDoiHang> chiTietDoiHang;

	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maHoaDonHoanTra")
    private HoaDonHoanTra hoaDonHoanTra;

	@Column(columnDefinition = "nvarchar(500)")
	private String ghiChu;
	private Double tienHoanTra;
	private Double chietKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String khuyenMai;

	public HoaDonDoiHang(HoaDonHoanTra hoaDonHoanTra, String ghiChu, Double tienHoanTra, Double chietKhau, String khuyenMai) {
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
