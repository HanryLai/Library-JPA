package entityJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class ChiTietHoanTra {
//	[hoaDonHoanTra] [nvarchar](50) NOT NULL,
//	[sanPham] [nvarchar](50) NOT NULL,
//	[soLuong] [int] NULL,
//	[thanhTien] [float] NULL,
	
//	@Id
//	private Sach sach;
	@Id
	private int soLuong;
	private double thanhTien;
	
	
}
