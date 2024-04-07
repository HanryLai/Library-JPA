package entity;

import java.time.LocalDateTime;

public class VanPhongPham extends SanPham {

    private MauSac mauSac;
    private String noiSanXuat;

    public VanPhongPham() {

    }

    public VanPhongPham(String ma) {
        super(ma);
    }

    public VanPhongPham(String maSanPham, String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap,
            int soLuongTon, double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double vAT,
            LocalDateTime ngayTao, double giamGia) {
        super(maSanPham, tenSanPham, nhomSanPham, nhaCungCap, soLuongTon, donGiaNhap, moTa, tinhTrang, donGiaBan, vAT, ngayTao,
                giamGia);
        // TODO Auto-generated constructor stub
    }

    public VanPhongPham(String maSanPham, String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap,
            int soLuongTon, double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double vAT,
            LocalDateTime ngayTao, double giamGia, MauSac mauSac, String noiSanXuat) {
        super(maSanPham, tenSanPham, nhomSanPham, nhaCungCap, soLuongTon, donGiaNhap, moTa, tinhTrang, donGiaBan, vAT,
                ngayTao, giamGia);
        this.mauSac = mauSac;
        this.noiSanXuat = noiSanXuat;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public String getNoiSanXuat() {
        return noiSanXuat;
    }

    public void setNoiSanXuat(String noiSanXuat) {
        this.noiSanXuat = noiSanXuat;
    }

    @Override
    public String toString() {
        return "VanPhongPham [mauSac=" + mauSac + ", noiSanXuat=" + noiSanXuat + "]";
    }

}
