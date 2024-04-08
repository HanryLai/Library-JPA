package entityJPA;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ChiTietHoaDon {

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hoaDon")
	private HoaDon hoaDon;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maSach")
	private Sach sach;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maVanPhongPham")
	private VanPhongPham vanPhongPham;
	
	
	private int soLuong;
	private double thanhTien;
	
}
