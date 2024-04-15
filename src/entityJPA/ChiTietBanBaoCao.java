package entityJPA;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "ChiTietBanBaoCao")
public class ChiTietBanBaoCao implements Serializable{
	private static final long serialVersionUID = 1L;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Embeddable
class ChiTietBanBaoCaoID implements Serializable {
	private int maSanPham;
	private int maBanBaoCao;
}