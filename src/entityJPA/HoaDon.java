package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HoaDon {
	@Id
	@Column(columnDefinition = "nvarchar(50)")
	private String maHoaDon;
	private LocalDateTime ngayLap;
	@Column(columnDefinition = "nvarchar(500)")
	private String ghiChu;
	private int tinhTrangHoaDon;
	private float tongTien;
	private float chietKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String khuyenMai;
	
	
}
