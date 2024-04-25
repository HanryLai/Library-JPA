package entityJPA;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maKhachHang;
	@Column(columnDefinition = "nvarchar(100)")
	private String tenKhachHang;
	@Column(columnDefinition = "nvarchar(20)", unique = true)
	private String soDienThoai;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "nvarchar(50)")
	private NhomKhachHang nhomKhachHang;
	private double tongTienMua;
	private int soLuongHoaDon;
	@OneToMany(mappedBy = "khachHang",fetch = FetchType.LAZY)
	private List<HoaDon> hoaDons;
	
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang +
				", tenKhachHang=" + tenKhachHang +
				", soDienThoai=" + soDienThoai +
				", nhomKhachHang=" + nhomKhachHang +
				", tongTienMua=" + tongTienMua +
				", soLuongHoaDon=" + soLuongHoaDon + "]";
	}
}
