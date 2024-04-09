package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
public class Sach extends SanPham{
	
	
	@Column(columnDefinition = "nvarchar(50)")
	private String tacGia;
	
	private int namXuatBan;
	@Column(columnDefinition = "nvarchar(50)")
	private String nhaSanXuat;
	private int soTrang;
	
	public Sach(String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon, double donGiaNhap,
			String moTa, String tinhTrang, double donGiaBan, double VAT, LocalDateTime ngayTao, double giamGia,
			String tacGia, int namXuatBan, String nhaSanXuat, int soTrang) {
		super(tenSanPham, nhomSanPham, nhaCungCap, soLuongTon, donGiaNhap, moTa, tinhTrang, donGiaBan, VAT, ngayTao,
				giamGia);
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.nhaSanXuat = nhaSanXuat;
		this.soTrang = soTrang;
	}
	
	
	
	
	
}
