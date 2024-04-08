package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "SanPham")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "loaiSanPham")
public abstract class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "maSanPham")
	private int maSanPham;
	private String tenSanPham;
	
	@ManyToOne
	@JoinColumn(name = "maNhomSanPham")
	private NhomSanPham nhomSanPham;
	
	@ManyToOne
	@JoinColumn(name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;
	
	private int soLuongTon;
	private double donGiaNhap;
	private String moTa;
	private String tinhTrang;
	private double donGiaBan;
	private LocalDateTime ngayTao;
	private double VAT;

	private double giamGia;
	
	public SanPham(String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon, double donGiaNhap,
			String moTa, String tinhTrang, double donGiaBan, LocalDateTime ngayTao, double VAT, double giamGia) {
		this.tenSanPham = tenSanPham;
		this.nhomSanPham = nhomSanPham;
		this.nhaCungCap = nhaCungCap;
		this.soLuongTon = soLuongTon;
		this.donGiaNhap = donGiaNhap;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.donGiaBan = donGiaBan;
		this.ngayTao = ngayTao;
		this.VAT = VAT;
		this.giamGia = giamGia;
	}
}