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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "ChiTietBanBaoCao")
public class ChiTietBanBaoCao {
	@EmbeddedId
	private ChiTietBanBaoCaoID id;

	private int soLuongBan;
	private double thanhTien;
	private int soLuongNhap;
	private int tonKho;
	private String ghiChu;

	@ManyToOne
	@JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham", insertable = false, updatable = false)
	private SanPham sanPham;

	@ManyToOne
	@JoinColumn(name = "maBanBaoCao", referencedColumnName = "maBanBaoCao", insertable = false, updatable = false)
	private BanBaoCao banBaoCao;
	


}
