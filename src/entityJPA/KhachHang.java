package entityJPA;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class KhachHang {
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
	@OneToMany(mappedBy = "khachHang")
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
