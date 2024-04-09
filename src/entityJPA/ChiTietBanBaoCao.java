package entityJPA;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@EmbeddedId
	@ManyToOne
	@JoinColumn(name = "maBanBaoCao")
	private BanBaoCao banBaoCao;
	
	@ManyToOne
	@JoinColumn(name = "maSach", insertable=false, updatable=false, referencedColumnName = "maSanPham")
	private Sach sach;
	
	@ManyToOne
	@JoinColumn(name = "maVanPhongPham", insertable=false, updatable=false, referencedColumnName = "maSanPham")
	private VanPhongPham vanPhongPham;

	private int soLuongBan;
	private double thanhTien;
	private int soLuongNhap;
	private int tonKho;
	private String ghiChu;
	
	public ChiTietBanBaoCao(BanBaoCao banBaoCao, int soLuongBan, double thanhTien, int soLuongNhap, int tonKho,
			String ghiChu) {
		this.banBaoCao = banBaoCao;
		this.soLuongBan = soLuongBan;
		this.thanhTien = thanhTien;
		this.soLuongNhap = soLuongNhap;
		this.tonKho = tonKho;
		this.ghiChu = ghiChu;
	}

}
