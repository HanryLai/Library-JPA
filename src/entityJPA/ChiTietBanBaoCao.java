package entityJPA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name = "ChiTietBanBaoCao")
public class ChiTietBanBaoCao {
	@Id
	@ManyToOne
	@JoinColumn(name = "maBanBaoCao")
	private BanBaoCao banBaoCao;

	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham")
	private SanPham sanPham;

	private int soLuongBan;
	private double thanhTien;
	private int soLuongNhap;
	private int tonKho;
	private String ghiChu;

	public ChiTietBanBaoCao(BanBaoCao banBaoCao, SanPham sanPham, int soLuongBan, double thanhTien, int soLuongNhap,
			int tonKho, String ghiChu) {
		this.banBaoCao = banBaoCao;
		this.sanPham = sanPham;
		this.soLuongBan = soLuongBan;
		this.thanhTien = thanhTien;
		this.soLuongNhap = soLuongNhap;
		this.tonKho = tonKho;
		this.ghiChu = ghiChu;
	}

}
