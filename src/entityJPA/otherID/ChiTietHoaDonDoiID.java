package entityJPA.otherID;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Embeddable
public class ChiTietHoaDonDoiID implements Serializable {
    private static final long serialVersionUID = 1L;
    private int maHoaDonDoi;
    private int maSanPham;
}
