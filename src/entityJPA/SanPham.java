package entityJPA;

import java.io.Serializable;
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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maSanPham;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhomSanPham")
	private NhomSanPham nhomSanPham;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;

	@OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
	private Set<ChiTietBanBaoCao> chiTietBanBaoCaos;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String tenSanPham;
	protected int soLuongTon;
	protected double donGiaNhap;

	@Column(columnDefinition = "NVARCHAR(255)")
	protected String moTa;
	@Column(columnDefinition = "NVARCHAR(255)")
	protected String tinhTrang;
	protected double donGiaBan;
	protected double VAT;
	protected LocalDateTime ngayTao;
	protected double giamGia;

	public SanPham(int maSanPham, String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon, double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double VAT, LocalDateTime ngayTao, double giamGia) {
		this.maSanPham = maSanPham;
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

	@Override
	public String toString() {
		return "SanPham{" +
				"maSanPham=" + maSanPham +
				", tenSanPham='" + tenSanPham + '\'' +
				", nhomSanPham=" + nhomSanPham.getSanPham() +
				", nhaCungCap=" + nhaCungCap.getMaNCC() +
				", soLuongTon=" + soLuongTon +
				", donGiaNhap=" + donGiaNhap +
				", moTa='" + moTa + '\'' +
				", tinhTrang='" + tinhTrang + '\'' +
				", donGiaBan=" + donGiaBan +
				", VAT=" + VAT +
				", ngayTao=" + ngayTao +
				", giamGia=" + giamGia +
				'}';
	}
}