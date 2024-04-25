package entityJPA;

import entityJPA.otherID.ChiTietDoiHangID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "ChiTietHoanTra")
public class ChiTietHoanTra implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ChiTietHoanTraID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSanPham",insertable=false, updatable=false)
	private SanPham sanPham;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHoaDonHoanTra",insertable=false, updatable=false)
	private HoaDonHoanTra hoaDonHoanTra;
	
	private int soLuong;
	private double thanhTien;

	public ChiTietHoanTra(HoaDonHoanTra hoaDonHoanTra,SanPham sanPham,  int soLuong, double thanhTien) {
		this.id = new ChiTietHoanTraID(hoaDonHoanTra.getMaHoaDonHoanTra(), sanPham.getMaSanPham());
		this.sanPham = sanPham;
		this.hoaDonHoanTra = hoaDonHoanTra;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietHoanTra{" +
				"id=" + id +
				", sanPham=" + sanPham.getMaSanPham() +
				", hoaDonHoanTra=" + hoaDonHoanTra.getMaHoaDonHoanTra() +
				", soLuong=" + soLuong +
				", thanhTien=" + thanhTien +
				'}';
	}
}
