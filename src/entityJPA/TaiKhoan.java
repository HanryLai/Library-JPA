package entityJPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
	@Id
	@Column(columnDefinition = "nvarchar(50)")
	private String tenDangNhap;
	@Column(columnDefinition = "nvarchar(50)")
	private String matKhau;
	@Column(columnDefinition = "nvarchar(50)")
	private String email;
	
	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", email=" + email + "]";
	}
}
