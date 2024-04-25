package entityJPA;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CaLamViec")
public class CaLamViec implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCa;
	@Column(columnDefinition = "nvarchar(25)")
	private String tenCa;
	@Column(columnDefinition = "time")
	private Time thoiGianBatDau;
	@Column(columnDefinition = "time")
	private Time thoiGianKetThuc;
	@OneToMany(mappedBy = "caLamViec")
	private List<NhanVien> nhanViens;

	public CaLamViec(String tenCa, Time thoiGianBatDau, Time thoiGianKetThuc) {
		this.tenCa = tenCa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	@Override
	public String toString() {
		return "CaLamViec [maCa=" + maCa
				+ ", tenCa=" + tenCa
				+ ", thoiGianBatDau=" + thoiGianBatDau
				+ ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}
	
}
