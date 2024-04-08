package entityJPA;

import groovy.transform.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ChiTietDoiHang")
public class ChiTietDoiHang {
	@Id
	private String hoaDonDoiHang;
	@Id
	private String sanPham;
	private int soLuong;
	private float thanhTien;
	public ChiTietDoiHang(String hoaDonDoiHang, String sanPham, int soLuong, float thanhTien) {
		super();
		this.hoaDonDoiHang = hoaDonDoiHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	
	
	

}
