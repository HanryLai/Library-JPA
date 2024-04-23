package entityJPA;

import entityJPA.otherID.ChiTietHoaDonDoiID;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
	
	@EmbeddedId
	private ChiTietHoaDonDoiID id;
	
	@ManyToOne
	@JoinColumn(name = "maHoaDonDoi", insertable = false, updatable = false)
	private HoaDonDoiHang hoaDonDoiHang;
	
	
	@ManyToOne
	@JoinColumn(name = "maSanPham", insertable = false, updatable = false)
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

