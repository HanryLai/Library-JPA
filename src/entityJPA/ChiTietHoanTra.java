package entityJPA;

import entityJPA.otherID.ChiTietDoiHangID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "ChiTietHoanTra")
public class ChiTietHoanTra {
	@EmbeddedId
	private ChiTietDoiHangID id;
	
	@ManyToOne()
	@JoinColumn(name = "maSanPham",insertable=false, updatable=false)
	private SanPham sanPham;
	

	@ManyToOne()
	@JoinColumn(name = "hoaDonHoanTra",insertable=false, updatable=false)
	private HoaDonHoanTra hoaDonHoanTra;
	
	private int soLuong;
	private double thanhTien;

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
