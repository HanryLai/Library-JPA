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
public class ChiTietDoiHangID implements Serializable{
	private int maHoaDonDoi;
	private int maSanPham;
}
