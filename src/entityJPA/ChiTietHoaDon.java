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

//	[soLuong] [int] NULL,
//	[thanhTien] [float] NULL,

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hoaDon")
	HoaDon hoaDon;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sanPham")
	Sach sanPham;
	private int soLuong;
	private double thanhTien;
	
}
