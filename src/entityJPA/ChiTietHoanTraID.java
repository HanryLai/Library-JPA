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
	private static final long serialVersionUID = 1L;
	private int maHoaDonHoaTra;
	private int maSanPham;

}
