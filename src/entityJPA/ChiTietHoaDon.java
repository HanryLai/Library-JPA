package entityJPA;

import entityJPA.otherID.ChiTietHoaDonID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon {
	
	@EmbeddedId
	private ChiTietHoaDonID id;

	@ManyToOne
	@JoinColumn(name = "hoaDon", insertable = false, updatable = false)
	private HoaDon maHoaDon;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maSach", insertable = false, updatable = false)
	private SanPham maSanPham;
	
		
	private int soLuong;
	private double thanhTien;
	
}

