package entityJPA;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon {
	
	@EmbeddedId
	private ChiTietHoaDonID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hoaDon", insertable = false, updatable = false)
	private HoaDon maHoaDon;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSach", insertable = false, updatable = false)
	private SanPham maSanPham;
	
		
	private int soLuong;
	private double thanhTien;


	@Override
	public String toString() {
		return "ChiTietHoaDon{" +
				"id=" + id +
				", maHoaDon=" + maHoaDon.getMaHoaDon() +
				", maSanPham=" + maSanPham.getMaSanPham() +
				", soLuong=" + soLuong +
				", thanhTien=" + thanhTien +
				'}';
	}
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class ChiTietHoaDonID implements Serializable{
	private static final long serialVersionUID = 1L;
	private int maHoaDon;
	private int maSanPham;
}
