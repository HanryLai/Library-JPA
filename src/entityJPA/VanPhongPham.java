package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "VanPhongPham")
public class VanPhongPham  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSanPham;
    private String tenSanPham;
    
//    private NhomSanPham nhomSanPham;
//    private NhaCungCap nhaCungCap;
    
    private int soLuongTon;
    private double donGiaNhap;
    private String moTa;
    private double donGiaBan;
    private double VAT;
//    private MauSac mauSac;
    private String noiSanXuat;
    private LocalDateTime ngayTao;
    private double giamGia;
    private String tinhTrang;
    
    // Tạm Thời
	public VanPhongPham(String tenSanPham, int soLuongTon, double donGiaNhap, String moTa, double donGiaBan, double VAT,
			String noiSanXuat, LocalDateTime ngayTao, double giamGia, String tinhTrang) {
		this.tenSanPham = tenSanPham;
		this.soLuongTon = soLuongTon;
		this.donGiaNhap = donGiaNhap;
		this.moTa = moTa;
		this.donGiaBan = donGiaBan;
		this.VAT = VAT;
		this.noiSanXuat = noiSanXuat;
		this.ngayTao = ngayTao;
		this.giamGia = giamGia;
		this.tinhTrang = tinhTrang;
	}
    
}
