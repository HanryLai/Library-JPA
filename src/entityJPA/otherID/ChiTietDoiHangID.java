package entityJPA.otherID;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Embeddable
public class ChiTietDoiHangID implements Serializable{
	private static final long serialVersionUID = 1L;
	private int maHoaDonDoi;
	private int maSanPham;
}
