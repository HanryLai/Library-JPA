package entity;

import java.time.LocalDateTime;

public class Sach extends SanPham {

    private String tacGia;
    private int namXuatBan;
    private String nhaXuatBan;
    private int soTrang;

    public Sach() {

    }

    public Sach(String ma) {
        super(ma);
    }

    public Sach(String maSanPham, String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon,
            double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double vAT, LocalDateTime ngayTao,
            double giamGia, String tacGia, int namXuatBan, String nhaXuatBan, int soTrang) {
        super(maSanPham, tenSanPham, nhomSanPham, nhaCungCap, soLuongTon, donGiaNhap, moTa, tinhTrang, donGiaBan, vAT,
                ngayTao, giamGia);
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.soTrang = soTrang;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public String toString() {
        return super.toString() + "Sach [tacGia=" + tacGia + ", namXuatBan=" + namXuatBan + ", nhaXuatBan=" + nhaXuatBan + ", soTrang="
                + soTrang + "]";
    }

}
