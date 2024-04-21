package entityJPA;

import java.io.Serializable;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ChiTietHoaDonDoi")
public class ChiTietHoaDonDoi {
	
	@EmbeddedId
	private chiTietHoaDonDoiID id;
	
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class chiTietHoaDonDoiID implements Serializable{
	private static final long serialVersionUID = 1L;
	private int maHoaDonDoi;
	private int maSanPham;
}
