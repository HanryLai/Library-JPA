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

	private String tenSanPham;
	protected int soLuongTon;
	protected double donGiaNhap;
	protected String moTa;
	protected String tinhTrang;
	protected double donGiaBan;
	protected double VAT;
	protected LocalDateTime ngayTao;
	protected double giamGia;

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