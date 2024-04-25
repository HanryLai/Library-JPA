package entityJPA;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "HoaDonHoanTra")
public class HoaDonHoanTra implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoaDonHoanTra;
	
	private LocalDate ngayHoan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "hoaDonHoanTra",fetch = FetchType.LAZY)
	private List<ChiTietHoanTra> ChiTietHoanTra;

	@OneToOne(fetch = FetchType.LAZY,mappedBy = "hoaDonHoanTra")
	private HoaDonDoiHang hoaDonDoiHang;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHoaDon")
	private HoaDon hoaDon;

	private String ghiChu;
	private int tinhTrangHoaDon;
	private Double tienHoanTra;


	public HoaDonHoanTra(LocalDate ngayHoan, HoaDon hoaDon, String ghiChu, int tinhTrangHoaDon, Double tienHoanTra) {
		this.ngayHoan = ngayHoan;
		this.hoaDon = hoaDon;
		this.ghiChu = ghiChu;
		this.tinhTrangHoaDon = tinhTrangHoaDon;
		this.tienHoanTra = tienHoanTra;
	}

	@Override
	public String 	toString() {
		return "HoaDonHoanTra{" +
				"maHoaDonHoanTra=" + maHoaDonHoanTra +
				", ngayHoan=" + ngayHoan +
				", nhanVien=" + nhanVien +
				", hoaDon=" + hoaDon.getMaHoaDon() +
				", ghiChu='" + ghiChu + '\'' +
				", tinhTrangHoaDon=" + tinhTrangHoaDon +
				", tienHoanTra=" + tienHoanTra +
				", maHoaDon=" + hoaDon.getMaHoaDon() +
				'}';
	}
}
