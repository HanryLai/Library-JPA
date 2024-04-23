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
public class ChiTietBanBaoCaoID implements Serializable {
    private static final long serialVersionUID = 1L;
    private int maSanPham;
    private int maBanBaoCao;
}
