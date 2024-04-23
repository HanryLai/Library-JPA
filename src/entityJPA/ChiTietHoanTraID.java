package entityJPA;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Embeddable
public class ChiTietHoanTraID implements Serializable{

	private int maHoaDonHoaTra;
	private int maSanPham;

}
