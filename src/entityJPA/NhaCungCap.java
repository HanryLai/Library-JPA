package entityJPA;

import groovy.transform.ToString;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {
	@Id
	@Column(columnDefinition = "nvarchar(50)")
	private String maNCC;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String tenNCC;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String diaChiNCC;
	
	//soDienThoai, email, ghiChu
	@Column(columnDefinition = "nvarchar(50)")
	private String soDienThoai;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String email;
	
	@Column(columnDefinition = "nvarchar(200)")
	private String ghiChu;
	

}
