package entityJPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

	@OneToMany(mappedBy = "banBaoCao", cascade = CascadeType.ALL)
	private List<ChiTietBanBaoCao> chiTietBanBaoCaos;
}
