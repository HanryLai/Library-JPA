package Entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class SanPham {

    private String maSanPham;
    private String tenSanPham;
    private NhomSanPham nhomSanPham;
    private NhaCungCap nhaCungCap;
    private int soLuongTon;
    private double donGiaNhap;
    private String moTa;
    private String tinhTrang;
    private double donGiaBan;
    private double VAT;
    private LocalDateTime ngayTao;
    private double giamGia;

    public SanPham() {

    }

    public SanPham(String ma) {
        super();
        this.maSanPham = ma;
    }

    public SanPham(String maSanPham, String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon,
            double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double vAT, LocalDateTime ngayTao,
            double giamGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.nhomSanPham = nhomSanPham;
        this.nhaCungCap = nhaCungCap;
        this.soLuongTon = soLuongTon;
        this.donGiaNhap = donGiaNhap;
        this.moTa = moTa;
        this.tinhTrang = tinhTrang;
        this.donGiaBan = donGiaBan;
        VAT = vAT;
        this.ngayTao = ngayTao;
        this.giamGia = giamGia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public NhomSanPham getNhomSanPham() {
        return nhomSanPham;
    }

    public void setNhomSanPham(NhomSanPham nhomSanPham) {
        this.nhomSanPham = nhomSanPham;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(double donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double vAT) {
        VAT = vAT;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    @Override
    public String toString() {
        return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", nhomSanPham=" + nhomSanPham
                + ", nhaCungCap=" + nhaCungCap + ", soLuongTon=" + soLuongTon + ", donGiaNhap=" + donGiaNhap + ", moTa="
                + moTa + ", tinhTrang=" + tinhTrang + ", donGiaBan=" + donGiaBan + ", VAT=" + VAT + ", ngayTao="
                + ngayTao + ", giamGia=" + giamGia + "]";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.maSanPham);
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
        final SanPham other = (SanPham) obj;
        return Objects.equals(this.maSanPham, other.maSanPham);
    }

}
