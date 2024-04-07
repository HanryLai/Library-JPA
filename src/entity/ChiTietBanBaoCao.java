/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import javax.annotation.processing.Generated;

/**
 *
 * @author TANLOC
 */
public class ChiTietBanBaoCao {
    private BanBaoCao banBaoCao;
    private String tenSanPham;
    private int soLuongBan;
    private int soLuongNhap;
    private double thanhTien;
    private int tonKho;
    private String ghiChu;

    public ChiTietBanBaoCao(){
        
    }
    
    public ChiTietBanBaoCao(BanBaoCao banBaoCao, String tenSanPham, int soLuongBan, double thanhTien, int soLuongNhap, int tonKho, String ghiChu) {
        this.banBaoCao = banBaoCao;
        this.tenSanPham = tenSanPham;
        this.soLuongBan = soLuongBan;
        this.thanhTien = thanhTien;
        this.soLuongNhap = soLuongNhap;
        this.tonKho = tonKho;
        this.ghiChu = ghiChu;
    }

    public ChiTietBanBaoCao(String tenSanPham, int soLuongBan, double thanhTien, String ghiChu) {
        this.tenSanPham = tenSanPham;
        this.soLuongBan = soLuongBan;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
    }
    
    public ChiTietBanBaoCao(String tenSanPham, int soLuongNhap, int tonKho, String ghiChu) {
        this.tenSanPham = tenSanPham;
        this.soLuongNhap = soLuongNhap;
        this.tonKho = tonKho;
        this.ghiChu = ghiChu;
    }

    public BanBaoCao getBanBaoCao() {
        return banBaoCao;
    }

    public void setBanBaoCao(BanBaoCao banBaoCao) {
        this.banBaoCao = banBaoCao;
    }

    
    
    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    
    
    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "ChiTietBanBaoCao{" + "banBaoCao=" + banBaoCao + ", tenSanPham=" + tenSanPham + ", soLuongBan=" + soLuongBan + ", soLuongNhap=" + soLuongNhap + ", tonKho=" + tonKho + ", ghiChu=" + ghiChu + '}';
    }
    
}
