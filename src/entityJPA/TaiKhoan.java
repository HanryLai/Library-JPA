package entityJPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "nvarchar(100)")
	private String tenDangNhap;
	@Column(columnDefinition = "nvarchar(50)")
	private String matKhau;
	@Column(columnDefinition = "nvarchar(100)")
	private String email;


	public TaiKhoan(String tenDangNhap, String matKhau, String email) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap
				+ ", matKhau=" + matKhau
				+ ", email=" + email + "]";
	}
}
