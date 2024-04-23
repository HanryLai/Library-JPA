package entityJPA;

import java.util.List;

import jakarta.persistence.Column;
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
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNCC;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String tenNCC;
	
	@Column(columnDefinition = "nvarchar(200)")
	private String diaChiNCC;
	
	//soDienThoai, email, ghiChu
	@Column(columnDefinition = "nvarchar(50)")
	private String soDienThoai;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String email;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String ghiChu;
	
	@OneToMany(mappedBy = "nhaCungCap")
	private List<SanPham> sanPhams;

	@Override
	public String toString() {
		return "NhaCungCap{" +
				"maNCC=" + maNCC +
				", tenNCC='" + tenNCC + '\'' +
				", diaChiNCC='" + diaChiNCC + '\'' +
				", soDienThoai='" + soDienThoai + '\'' +
				", email='" + email + '\'' +
				", ghiChu='" + ghiChu + '\'' +

				'}';
	}
}
