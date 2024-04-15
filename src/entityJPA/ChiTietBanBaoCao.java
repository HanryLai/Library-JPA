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

@Table(name = "ChiTietBanBaoCao")
public class ChiTietBanBaoCao {
	@EmbeddedId
	private ChiTietBanBaoCaoID id;


	@ManyToOne
	@JoinColumn(name = "maBanBaoCao", insertable = false, updatable = false)
	private BanBaoCao banBaoCao;

	@ManyToOne
	@JoinColumn(name = "maSanPham", insertable = false, updatable = false)
	private SanPham sanPham;

	private int soLuongBan;
	private double thanhTien;
	private int soLuongNhap;
	private int tonKho;
	private String ghiChu;

	@Override
	public String toString() {
		return "ChiTietBanBaoCao{" +
				"id=" + id +
				", soLuongBan=" + soLuongBan +
				", thanhTien=" + thanhTien +
				", soLuongNhap=" + soLuongNhap +
				", tonKho=" + tonKho +
				", ghiChu='" + ghiChu + '\'' +
				'}';
	}
}
