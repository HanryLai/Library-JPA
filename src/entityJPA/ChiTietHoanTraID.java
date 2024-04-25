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
	private int maHoaDonHoanTra;
	private int maSanPham;

	public ChiTietHoanTraID(int maHoaDonHoaTra, int maSanPham) {
		this.maHoaDonHoanTra = maHoaDonHoaTra;
		this.maSanPham = maSanPham;
	}
}
