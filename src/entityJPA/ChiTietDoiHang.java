package entityJPA;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

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

@Getter
@Setter
@NoArgsConstructor
@ToString


@Embeddable
class ChiTietDoiHangID implements Serializable {
	private int maHoaDonDoi;
	private int maSanPham;
}
