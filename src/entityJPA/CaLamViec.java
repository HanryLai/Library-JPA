package entityJPA;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CaLamViec")
public class CaLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCa;
	private String tenCa;
	private LocalDateTime thoiGianBatDau;
	private LocalDateTime thoiGianKetThuc;
	@OneToMany(mappedBy = "caLamViec")
	private List<NhanVien> nhanViens;

	public CaLamViec(String tenCa, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc) {
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
