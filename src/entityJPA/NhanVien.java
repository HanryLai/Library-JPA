package entityJPA;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
	private static final long serialVersionUID = 1L;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenDangNhap", unique = true)
	private TaiKhoan taiKhoan;

	private int tinhTrangLamViec;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "maCa")
	private CaLamViec caLamViec;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "nvarchar(10)")
	private ChucVu chucVu;

	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	private List<HoaDon> hoaDons;

	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
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
