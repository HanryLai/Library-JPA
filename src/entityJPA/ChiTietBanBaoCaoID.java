package entityJPA;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

@Embeddable
public class ChiTietBanBaoCaoID implements Serializable {
    private int maSanPham;
    private int maBanBaoCao;



}
