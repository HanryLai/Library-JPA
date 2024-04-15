package entityJPA;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Embeddable
public class ChiTietHoanTraID implements Serializable{

	private int maHoaDonHoaTra;
	private int maSanPham;
	

}
