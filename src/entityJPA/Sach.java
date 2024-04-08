package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Sach")
@DiscriminatorValue("Sach")
public class Sach extends SanPham{
	private String tacGia;
	private String nhaXuatBan;
	private int namXuatBan;
	private int soTrang;
	
	public Sach(String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon, double donGiaNhap,
			String moTa, String tinhTrang, double donGiaBan, LocalDateTime ngayTao, double VAT, double giamGia,
			String tacGia, String nhaXuatBan, int namXuatBan, int soTrang) {
		super(tenSanPham, nhomSanPham, nhaCungCap, soLuongTon, donGiaNhap, moTa, tinhTrang, donGiaBan, ngayTao, VAT,
				giamGia);
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.namXuatBan = namXuatBan;
		this.soTrang = soTrang;
	}
	
}
