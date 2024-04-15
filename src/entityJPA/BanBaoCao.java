package entityJPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@OneToMany(mappedBy = "banBaoCao")
	private List<ChiTietBanBaoCao> chiTietBanBaoCaos;



	public BanBaoCao(String tenBanBaoCao, String tenNhanVien, double doanhThu, String thoiGianBaoCao) {
		this.tenBanBaoCao = tenBanBaoCao;
		this.tenNhanVien = tenNhanVien;
		this.doanhThu = doanhThu;
		this.thoiGianBaoCao = thoiGianBaoCao;
	}
}
