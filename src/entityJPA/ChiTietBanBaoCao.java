package entityJPA;

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
@Table(name = "ChiTietBanBaoCao")
public class ChiTietBanBaoCao {
	@Id
	private int banBaoCao;
	@Id
	private int sanPham;
	
	private int soLuongBan;
	private double thanhTien;
	private int soLuongNhap;
	private int tonKho;
	private String ghiChu;
	
	public ChiTietBanBaoCao(int banBaoCao, int sanPham, int soLuongBan, double thanhTien, int soLuongNhap, int tonKho,
			String ghiChu) {
		this.banBaoCao = banBaoCao;
		this.sanPham = sanPham;
		this.soLuongBan = soLuongBan;
		this.thanhTien = thanhTien;
		this.soLuongNhap = soLuongNhap;
		this.tonKho = tonKho;
		this.ghiChu = ghiChu;
	}

}
