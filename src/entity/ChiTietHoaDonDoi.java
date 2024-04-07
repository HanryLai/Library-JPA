/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguyen chau tai
 */
public class ChiTietHoaDonDoi {
    private HoaDonDoiHang hoaDonDoiHang;
    private SanPham sanPham;
    private int soLuong;
    private double thanhTien;

    public ChiTietHoaDonDoi() {

    }

    public ChiTietHoaDonDoi(HoaDonDoiHang hoaDonDoiHang, SanPham sanPham, int soLuong, double thanhTien) {
        super();
        this.hoaDonDoiHang = hoaDonDoiHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public HoaDonDoiHang getHoaDonDoiHang() {
        return hoaDonDoiHang;
    }

    public void setHoaDonDoiHang(HoaDonDoiHang hoaDonDoiHang) {
        this.hoaDonDoiHang = hoaDonDoiHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
