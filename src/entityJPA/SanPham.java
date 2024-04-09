package entityJPA;

import java.time.LocalDateTime;

import com.lowagie.text.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int maSanPham;
	private String tenSanPham;
	
	@ManyToOne
	@JoinColumn(name = "maNhomSanPham")
	private NhomSanPham nhomSanPham;
	
	@ManyToOne
	@JoinColumn(name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;
	
	protected int soLuongTon;
	protected double donGiaNhap;
	protected String moTa;
	protected String tinhTrang;
	protected double donGiaBan;
	protected double VAT;
	protected LocalDateTime ngayTao;
	protected double giamGia;
	

	
	public SanPham(String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon, double donGiaNhap,
			String moTa, String tinhTrang, double donGiaBan, double VAT, LocalDateTime ngayTao, double giamGia) {
		this.tenSanPham = tenSanPham;
		this.nhomSanPham = nhomSanPham;
		this.nhaCungCap = nhaCungCap;
		this.soLuongTon = soLuongTon;
		this.donGiaNhap = donGiaNhap;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.donGiaBan = donGiaBan;
		this.VAT = VAT;
		this.ngayTao = ngayTao;
		this.giamGia = giamGia;
	}
}