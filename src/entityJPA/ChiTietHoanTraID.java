package entityJPA;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Embeddable
public class ChiTietHoanTraID implements Serializable{

	private static final long serialVersionUID = 1L;
	private int maHoaDonHoaTra;

	private int maSanPham;

	public ChiTietHoanTraID(int maHoaDonHoaTra, int maSanPham) {
		this.maHoaDonHoanTra = maHoaDonHoaTra;
		this.maSanPham = maSanPham;
	}
}
