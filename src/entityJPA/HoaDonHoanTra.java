package entityJPA;

import java.time.LocalDate;

import groovy.transform.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "HoaDonHoanTra")
public class HoaDonHoanTra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int maHoaDonHoanTra;
	
	private LocalDate ngayHoan;
	private int nhanVien;
	private int hoaDon;
	private String ghiChu;
	private int tinhTrangHoaDon;
	private float tienHoanTra;
	public HoaDonHoanTra(LocalDate ngayHoan, int nhanVien, int hoaDon, String ghiChu, int tinhTrangHoaDon,

			float tienHoanTra) {
		super();
		this.ngayHoan = ngayHoan;
		this.nhanVien = nhanVien;
		this.hoaDon = hoaDon;
		this.ghiChu = ghiChu;
		this.tinhTrangHoaDon = tinhTrangHoaDon;
		this.tienHoanTra = tienHoanTra;
	}
	
	

	

}
