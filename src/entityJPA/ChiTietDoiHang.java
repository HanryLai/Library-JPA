package entityJPA;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ChiTietDoiHang")
public class ChiTietDoiHang {
	
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maHoaDonDoi")
	private HoaDonDoiHang hoaDonDoiHang;
	
	
	@ManyToOne
	@JoinColumn(name = "maSach", insertable=false, updatable=false, referencedColumnName = "maSanPham")
	private Sach sach;
	
	@ManyToOne
	@JoinColumn(name = "maVanPhongPham", insertable=false, updatable=false, referencedColumnName = "maSanPham")
	private VanPhongPham vanPhongPham;
	
	private int soLuong;
	private float thanhTien;

}
