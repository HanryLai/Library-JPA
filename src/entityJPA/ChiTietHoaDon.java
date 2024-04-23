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
	@JoinColumn(name = "maHoaDon", insertable=false, updatable=false)
	private HoaDon maHoaDon;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSanPham", insertable=false, updatable=false)
	private SanPham maSanPham;
	
		
	private int soLuong;
	private double thanhTien;

	public ChiTietHoaDon(HoaDon HoaDon, SanPham SanPham, int soLuong, double thanhTien) {
		this.id = new ChiTietHoaDonID(HoaDon.getMaHoaDon(), SanPham.getMaSanPham());
		this.maHoaDon = HoaDon;
		this.maSanPham = SanPham;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

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


