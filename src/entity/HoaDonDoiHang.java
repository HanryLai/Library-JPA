/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author nguyen chau tai
 */
public class HoaDonDoiHang {
    private String maHoaDonDoi;
    private HoaDonHoanTra hoaDonHoanTra;
    private String ghiChu;
    private double tienHoanTra;
    private double chietKhau;
    private String khuyenMai;

    public HoaDonDoiHang(String maHoaDonDoi, HoaDonHoanTra hoaDonHoanTra, String ghiChu, double tienHoanTra, double chietKhau, String khuyenMai) {
        this.maHoaDonDoi = maHoaDonDoi;
        this.hoaDonHoanTra = hoaDonHoanTra;
        this.ghiChu = ghiChu;
        this.tienHoanTra = tienHoanTra;
        this.chietKhau = chietKhau;
        this.khuyenMai = khuyenMai;
    }
    public HoaDonDoiHang() {
    }
    public HoaDonDoiHang(String maHoaDonDoi) {
        this.maHoaDonDoi = maHoaDonDoi;
    }

    public String getMaHoaDonDoi() {
        return maHoaDonDoi;
    }

    public void setMaHoaDonDoi(String maHoaDonDoi) {
        this.maHoaDonDoi = maHoaDonDoi;
    }

    public HoaDonHoanTra getHoaDonHoanTra() {
        return hoaDonHoanTra;
    }

    public void setHoaDonHoanTra(HoaDonHoanTra hoaDonHoanTra) {
        this.hoaDonHoanTra = hoaDonHoanTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTienHoanTra() {
        return tienHoanTra;
    }

    public void setTienHoanTra(double tienHoanTra) {
        this.tienHoanTra = tienHoanTra;
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
    public int hashCode() {
        int hash = 5;
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
        final HoaDonDoiHang other = (HoaDonDoiHang) obj;
        return Objects.equals(this.maHoaDonDoi, other.maHoaDonDoi);
    }
    
}
