package entityJPA;


import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "ChiTietDoiHang")
public class ChiTietDoiHang {
	@EmbeddedId
	private ChiTietDoiHangID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHoaDonDoi",insertable=false, updatable=false)
	private HoaDonDoiHang hoaDonDoiHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSanPham", insertable=false, updatable=false)
	private SanPham sanPham;
	
	private int soLuong;
	private float thanhTien;

	@Override
	public String toString() {
		return "ChiTietDoiHang{" +
				", hoaDonDoiHang=" + hoaDonDoiHang.getMaHoaDonDoi() +
				", sanPham=" + sanPham.getMaSanPham() +
				", soLuong=" + soLuong +
				", thanhTien=" + thanhTien +
				'}';
	}
}
