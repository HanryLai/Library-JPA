package entityJPA;

import entityJPA.HoaDonDoiHang;
import entityJPA.SanPham;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ChiTietHoaDonDoi")
public class ChiTietHoaDonDoi {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maHoaDonDoi")
	private HoaDonDoiHang hoaDonDoiHang;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maSanPham")
    private SanPham sanPham;
    private int soLuong;
    private double thanhTien;
    
        public ChiTietHoaDonDoi(HoaDonDoiHang hoaDonDoiHang, SanPham sanPham, int soLuong, double thanhTien) {
        	super();
        	this.hoaDonDoiHang = hoaDonDoiHang;
        	this.sanPham = sanPham;
        	this.soLuong = soLuong;
        	this.thanhTien = thanhTien;
        }
    
	@Override
	public String toString() {
		return "ChiTietHoaDonDoi [hoaDonDoiHang=" + hoaDonDoiHang + ", sanPham=" + sanPham + ", soLuong=" + soLuong
				+ ", thanhTien=" + thanhTien + "]";
	}
    
    
}
