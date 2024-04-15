package entityJPA;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Table(name = "HoaDonHoanTra")
public class HoaDonHoanTra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoaDonHoanTra;
	
	private LocalDate ngayHoan;
	private int nhanVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHoaDon")
	private HoaDon hoaDon;
	private String ghiChu;
	private int tinhTrangHoaDon;
	private float tienHoanTra;
	
	public HoaDonHoanTra(int maHoaDonHoanTra, LocalDate ngayHoan, int nhanVien, HoaDon hoaDon, String ghiChu,
			int tinhTrangHoaDon, float tienHoanTra) {
		super();
		this.maHoaDonHoanTra = maHoaDonHoanTra;
		this.ngayHoan = ngayHoan;
		this.nhanVien = nhanVien;
		this.hoaDon = hoaDon;
		this.ghiChu = ghiChu;
		this.tinhTrangHoaDon = tinhTrangHoaDon;
		this.tienHoanTra = tienHoanTra;
	}
	
	
	
	
	
	

}
