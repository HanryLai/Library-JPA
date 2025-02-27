package entityJPA;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@NoArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoaDon;
	private LocalDateTime ngayLap;
	@Column(columnDefinition = "nvarchar(500)")
	private String ghiChu;
	private int tinhTrangHoaDon;
	private float tongTien;
	private float chietKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String khuyenMai;

	public HoaDon(LocalDateTime ngayLap, String ghiChu, int tinhTrangHoaDon, float tongTien, float chietKhau, String khuyenMai) {
		this.ngayLap = ngayLap;
		this.ghiChu = ghiChu;
		this.tinhTrangHoaDon = tinhTrangHoaDon;
		this.tongTien = tongTien;
		this.chietKhau = chietKhau;
		this.khuyenMai = khuyenMai;
	}

	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
	private List<HoaDonHoanTra> hoaDonHoanTras;

	@OneToMany(mappedBy = "maHoaDon", fetch = FetchType.LAZY)
	private List<ChiTietHoaDon> chiTietHoaDons;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", ghiChu=" + ghiChu + ", tinhTrangHoaDon="
				+ tinhTrangHoaDon + ", tongTien=" + tongTien + ", chietKhau=" + chietKhau + ", khuyenMai=" + khuyenMai
				+ ", maKhachHang=" + khachHang.getMaKhachHang() + ", maMhanVien=" + nhanVien.getMaNhanVien() + "]";
	}	
}
