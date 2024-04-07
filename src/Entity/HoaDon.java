package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDon {

    private String maHoaDon;
    private LocalDateTime ngayLap;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private String ghiChu;
    private int tinhTrangHoaDon;
    private double tongTien;
    private double chietKhau;
    private String khuyenMai;

    public HoaDon(String ma) {
        super();
        this.maHoaDon = ma;
    }

    public HoaDon(String maHoaDon, LocalDateTime ngayLap, NhanVien nhanVien, KhachHang khachHang, String ghiChu,
            int tinhTrangHoaDon, double tongTien, double chietKhau, String khuyenMai) {
        super();
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ghiChu = ghiChu;
        this.tinhTrangHoaDon = tinhTrangHoaDon;
        this.tongTien = tongTien;
        this.chietKhau = chietKhau;
        this.khuyenMai = khuyenMai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
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

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(double chietKhau) {
        this.chietKhau = chietKhau;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ghiChu=" + ghiChu + ", tinhTrangHoaDon=" + tinhTrangHoaDon + ", tongTien=" + tongTien + ", chietKhau=" + chietKhau + ", khuyenMai=" + khuyenMai + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.maHoaDon);
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
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.maHoaDon, other.maHoaDon);
    }

}
