package entityJPA;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maSanPham;
	private String tenSanPham;
	
	@ManyToOne
	@JoinColumn(name = "maNhomSanPham")
	private NhomSanPham nhomSanPham;
	
	@ManyToOne
	@JoinColumn(name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;

	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
	private List<ChiTietBanBaoCao> chiTietBanBaoCaos;

	@ManyToMany(mappedBy = "sanPhams")
	private Set<BanBaoCao> banBaoCaos = new HashSet<>();
	
	
	
	
	protected int soLuongTon;
	protected double donGiaNhap;
	protected String moTa;
	protected String tinhTrang;
	protected double donGiaBan;
	protected double VAT;
	protected LocalDateTime ngayTao;
	protected double giamGia;
	
	public SanPham( String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon,
			double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double vAT, LocalDateTime ngayTao,
			double giamGia) {
		super();
		this.tenSanPham = tenSanPham;
		this.nhomSanPham = nhomSanPham;
		this.nhaCungCap = nhaCungCap;
		this.soLuongTon = soLuongTon;
		this.donGiaNhap = donGiaNhap;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.donGiaBan = donGiaBan;
		VAT = vAT;
		this.ngayTao = ngayTao;
		this.giamGia = giamGia;
	}
	
}