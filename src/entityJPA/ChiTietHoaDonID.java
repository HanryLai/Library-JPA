package entityJPA;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ChiTietHoaDonID implements Serializable {
    private static final long serialVersionUID = 1L;
    private int maHoaDon;
    private int maSanPham;
}