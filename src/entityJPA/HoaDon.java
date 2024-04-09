package entityJPA;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class HoaDon {
	@Id
	@Column(columnDefinition = "nvarchar(50)")
	private String maHoaDon;
	private LocalDateTime ngayLap;
	@Column(columnDefinition = "nvarchar(500)")
	private String ghiChu;
	private int tinhTrangHoaDon;
	private float tongTien;
	private float chietKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String khuyenMai;
	
	@OneToMany(mappedBy = "hoaDon")
	private List<HoaDonHoanTra> hoaDonHoanTras;
	
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", ghiChu=" + ghiChu + ", tinhTrangHoaDon="
				+ tinhTrangHoaDon + ", tongTien=" + tongTien + ", chietKhau=" + chietKhau + ", khuyenMai=" + khuyenMai
				+ ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + "]";
	}
	
	
	
}
