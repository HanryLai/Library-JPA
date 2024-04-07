package Entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDonHoanTra {

    private String maHoaDonHoanTra;
    private LocalDateTime ngayHoan;
    private NhanVien nhanVien;
    private HoaDon hoaDon;
    private String ghiChu;
    private int tinhTrangHoaDon;
    private double tienHoanTra;

    public HoaDonHoanTra (String ma) {
        super();
        this.maHoaDonHoanTra = ma;
    }

    public HoaDonHoanTra() {

    }

    public HoaDonHoanTra(String maHoaDonHoanTra, LocalDateTime ngayHoan, NhanVien nhanVien, HoaDon hoaDon,
            String ghiChu, int tinhTrangHoaDon, double tienHoanTra) {
        super();
        this.maHoaDonHoanTra = maHoaDonHoanTra;
        this.ngayHoan = ngayHoan;
        this.nhanVien = nhanVien;
        this.hoaDon = hoaDon;
        this.ghiChu = ghiChu;
        this.tinhTrangHoaDon = tinhTrangHoaDon;
        this.tienHoanTra = tienHoanTra;
    }

    public String getMaHoaDonHoanTra() {
        return maHoaDonHoanTra;
    }

    public void setMaHoaDonHoanTra(String maHoaDonHoanTra) {
        this.maHoaDonHoanTra = maHoaDonHoanTra;
    }

    public LocalDateTime getNgayHoan() {
        return ngayHoan;
    }

    public void setNgayHoan(LocalDateTime ngayHoan) {
        this.ngayHoan = ngayHoan;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTinhTrangHoaDon() {
        return tinhTrangHoaDon;
    }

    public void setTinhTrangHoaDon(int tinhTrangHoaDon) {
        this.tinhTrangHoaDon = tinhTrangHoaDon;
    }

    public double getTienHoanTra() {
        return tienHoanTra;
    }

    public void setTienHoanTra(double tienHoanTra) {
        this.tienHoanTra = tienHoanTra;
    }

    @Override
    public String toString() {
        return "HoaDonHoanTra [maHoaDonHoanTra=" + maHoaDonHoanTra + ", ngayHoan=" + ngayHoan + ", nhanVien=" + nhanVien
                + ", hoaDon=" + hoaDon + ", ghiChu=" + ghiChu + ", tinhTrangHoaDon=" + tinhTrangHoaDon
                + ", tienHoanTra=" + tienHoanTra + "]";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.maHoaDonHoanTra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDonHoanTra other = (HoaDonHoanTra) obj;
        return Objects.equals(this.maHoaDonHoanTra, other.maHoaDonHoanTra);
    }

}
