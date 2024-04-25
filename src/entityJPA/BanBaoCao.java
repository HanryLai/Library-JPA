package entityJPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "BanBaoCao")
public class BanBaoCao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maBanBaoCao;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String tenBanBaoCao;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String tenNhanVien;
	private double doanhThu;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String thoiGianBaoCao;

	@OneToMany(mappedBy = "banBaoCao")
	private List<ChiTietBanBaoCao> chiTietBanBaoCaos;

	@Override
	public String toString() {
		return "BanBaoCao{" +
				"maBanBaoCao=" + maBanBaoCao +
				", tenBanBaoCao='" + tenBanBaoCao + '\'' +
				", tenNhanVien='" + tenNhanVien + '\'' +
				", doanhThu=" + doanhThu +
				", thoiGianBaoCao='" + thoiGianBaoCao + '\'' +
				'}';
	}
}


