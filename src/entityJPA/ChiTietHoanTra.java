package entityJPA;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
public class ChiTietHoanTra {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maSach")
	private Sach sach;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maVanPhongPham")
	private VanPhongPham vanPhongPham;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hoaDonHoanTra")
	private HoaDonHoanTra hoaDonHoanTra;
	private int soLuong;
	private double thanhTien;
	
	
}
