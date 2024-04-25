package entityJPA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhuyenMai;

    @Column(columnDefinition = "nvarchar(50)")
    private String tenKhuyenMai;
    @Column(columnDefinition = "nvarchar(255)")
    private String ghiChu;
    @Column(columnDefinition = "nvarchar(50)")
    private String trangThai;
    private Double tiLeKhuyenMai;
    private Double tienToiThieu;

    private Double giaTriKhuyenMaiToiDa;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKhuyenMai=" + maKhuyenMai +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", tiLeKhuyenMai=" + tiLeKhuyenMai +
                ", tienToiThieu=" + tienToiThieu +
                ", giaTriKhuyenMaiToiDa=" + giaTriKhuyenMaiToiDa +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                '}';
    }

}
