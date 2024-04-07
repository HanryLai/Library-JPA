/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author TANLOC
 */
public class BanBaoCao {
    private String maBanBaoCao;
    private String tenBanBaoCao;
    private String tenNhanVien;
    private String thoiGianBaoCao;
    private double doanhThu;
    private String ghiChu;

    public BanBaoCao(String maBanBaoCao, String tenBanBaoCao, String tenNhanVien, String thoiGianBaoCao, double doanhThu, String ghiChu) {
        this.maBanBaoCao = maBanBaoCao;
        this.tenBanBaoCao = tenBanBaoCao;
        this.tenNhanVien = tenNhanVien;
        this.thoiGianBaoCao = thoiGianBaoCao;
        this.doanhThu = doanhThu;
        this.ghiChu = ghiChu;
    }
    public BanBaoCao(String maBanBaoCao, String tenBanBaoCao, String tenNhanVien, String thoiGianBaoCao) {
        this.maBanBaoCao = maBanBaoCao;
        this.tenBanBaoCao = tenBanBaoCao;
        this.tenNhanVien = tenNhanVien;
        this.thoiGianBaoCao = thoiGianBaoCao;
    }

    public BanBaoCao(String maBanBaoCao){
        this.maBanBaoCao = maBanBaoCao;
    }
    
    public String getMaBanBaoCao() {
        return maBanBaoCao;
    }

    public void setMaBanBaoCao(String maBanBaoCao) {
        this.maBanBaoCao = maBanBaoCao;
    }

    public String getTenBanBaoCao() {
        return tenBanBaoCao;
    }

    public void setTenBanBaoCao(String tenBanBaoCao) {
        this.tenBanBaoCao = tenBanBaoCao;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    
    
    public String getThoiGianBaoCao() {
        return thoiGianBaoCao;
    }

    public void setThoiGianBaoCao(String thoiGianBaoCao) {
        this.thoiGianBaoCao = thoiGianBaoCao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "BanBaoCao{" + "maBanBaoCao=" + maBanBaoCao + ", tenBanBaoCao=" + tenBanBaoCao + ", tenNhanVien=" + tenNhanVien + ", thoiGianBaoCao=" + thoiGianBaoCao + ", ghiChu=" + ghiChu + '}';
    }
    
    
}
