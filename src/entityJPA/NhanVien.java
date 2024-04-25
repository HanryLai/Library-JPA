package entityJPA;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhanVien;

	@Column(columnDefinition = "nvarchar(50)")
	private String hoTenNV;

	private LocalDate ngaySinh;
	@Column(columnDefinition = "nvarchar(20)")
	private String soDienThoai;
	@Column(columnDefinition = "nvarchar(10)")
	private String gioiTinh;
	@Column(columnDefinition = "nvarchar(100)")
	private String email;

	@OneToOne
	@JoinColumn(name = "tenDangNhap", unique = true, nullable = false)
	private TaiKhoan taiKhoan;
	private int tinhTrangLamViec;

	@ManyToOne
	@JoinColumn(name = "maCa")
	private CaLamViec caLamViec;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "nvarchar(10)")
	private ChucVu chucVu;

	@OneToMany
	private List<HoaDon> hoaDons;

	@OneToMany
	private List<HoaDonHoanTra> hoaDonHoanTras;


	public NhanVien(String hoTenNV, LocalDate ngaySinh, String soDienThoai, String gioiTinh, String email,
			TaiKhoan taiKhoan, int tinhTrangLamViec, CaLamViec caLamViec, ChucVu chucVu) {
		super();
		this.hoTenNV = hoTenNV;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.taiKhoan = taiKhoan;
		this.tinhTrangLamViec = tinhTrangLamViec;
		this.caLamViec = caLamViec;
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien
				+ ", hoTenNV=" + hoTenNV
				+ ", ngaySinh=" + ngaySinh
				+ ", soDienThoai=" + soDienThoai
				+ ", gioiTinh=" + gioiTinh
				+ ", email=" + email
				+ ", taiKhoan=" + taiKhoan.getTenDangNhap()
				+ ", tinhTrangLamViec=" + tinhTrangLamViec
				+ ", caLamViec=" + caLamViec.getMaCa()
				+ ", chucVu=" + chucVu.toString() + "]";
	}
}
