package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Sach")
public class Sach extends SanPham{
	
	
	@Column(columnDefinition = "nvarchar(50)")
	private String tacGia;
	
	private int namXuatBan;
	@Column(columnDefinition = "nvarchar(50)")
	private String nhaSanXuat;
	private int soTrang;

	
	
	
}
