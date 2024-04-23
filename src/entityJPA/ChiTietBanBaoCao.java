package entityJPA;

import entityJPA.otherID.ChiTietBanBaoCaoID;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

@Entity
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

	@Column(columnDefinition = "NVARCHAR(255)")
	private String ghiChu;

	@Override
	public String toString() {
		return "ChiTietBanBaoCao{" +
				"id=" + id +
				", banBaoCao=" + banBaoCao.getMaBanBaoCao() +
				", sanPham=" + sanPham.getMaSanPham() +
				", soLuongBan=" + soLuongBan +
				", thanhTien=" + thanhTien +
				", soLuongNhap=" + soLuongNhap +
				", tonKho=" + tonKho +
				", ghiChu='" + ghiChu + '\'' +
				'}';
	}
}

