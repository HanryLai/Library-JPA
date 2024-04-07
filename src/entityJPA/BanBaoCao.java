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
@Table(name = "BanBaoCao")
public class BanBaoCao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maBanBaoCao;
	private String tenBanBaoCao;
	private String tenNhanVien;
	private double doanhThu;
	private String thoiGianBaoCao;
	
	public BanBaoCao(String tenBanBaoCao, String tenNhanVien, double doanhThu, String thoiGianBaoCao) {
		this.tenBanBaoCao = tenBanBaoCao;
		this.tenNhanVien = tenNhanVien;
		this.doanhThu = doanhThu;
		this.thoiGianBaoCao = thoiGianBaoCao;
	}
}
