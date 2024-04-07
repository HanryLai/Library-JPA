/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.MauSac;
import entity.NhaCungCap;
import entity.NhomSanPham;
import entity.VanPhongPham;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nguyen chau tai
 */
public class DAO_VanPhongPham {

    public DAO_VanPhongPham() {

    }

    public ArrayList<VanPhongPham> getAllVanPhongPhan() {
        ArrayList<VanPhongPham> dsVpp = new ArrayList<VanPhongPham>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from VanPhongPham";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
                NhomSanPham nhomSP = new NhomSanPham(rs.getString(3));
                NhaCungCap nhaCC = new NhaCungCap(rs.getString(4));
                int soLuong = rs.getInt(5);
                double donGiaNhap = rs.getDouble(6);
                String moTa = rs.getString(7);
                double donGiaBan = rs.getDouble(8);
                double Vat = rs.getDouble(9);
                MauSac mauSac = new MauSac(rs.getString(10));
                String noiSanXuat = rs.getString(11);
                //
                Timestamp time = rs.getTimestamp(12);
                LocalDateTime ngayTao = time.toLocalDateTime();
                //
                double giamGia = rs.getDouble(13);
                String tinhTrang = rs.getString(14);
                // sửa constructor mauSac, nhaCC, nhomSP
                VanPhongPham vpp = new VanPhongPham(maSP, tenSP, nhomSP, nhaCC, soLuong, donGiaNhap, moTa, tinhTrang,
                        donGiaBan, Vat, ngayTao, giamGia, mauSac, noiSanXuat);
                dsVpp.add(vpp);

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsVpp;
    }

    public boolean update(VanPhongPham vpp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("update VanPhongPham set tenSanPham = ?, nhomSanPham = ?,"
                    + "nhaCungCap = ?, soLuongTon = ?, " + "donGiaNhap = ?, moTa = ?, donGiaBan = ?"
                    + ", mauSac = ?, noiSanXuat =? where maSanPham = ?");

            state.setString(1, vpp.getTenSanPham());
            state.setString(2, vpp.getNhomSanPham().getMaNhomSanPham());
            state.setString(3, vpp.getNhaCungCap().getMaNCC());
            state.setInt(4, vpp.getSoLuongTon());
            state.setDouble(5, vpp.getDonGiaNhap());
            state.setString(6, vpp.getMoTa());
            state.setDouble(7, vpp.getDonGiaBan());
            state.setString(8, vpp.getMauSac().getMaMau());
            state.setString(9, vpp.getNoiSanXuat());
            state.setString(10, vpp.getMaSanPham());
            n = state.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
        return n > 0;
    }

    public VanPhongPham getVPPtheoMa(String ma) {
        VanPhongPham vpp = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from VanPhongPham where maSanPham = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                String tenSP = rs.getString("tenSanPham");
                NhomSanPham nhomSP = new NhomSanPham(rs.getString("nhomSanPham"));
                NhaCungCap nhaCC = new NhaCungCap(rs.getString("nhaCungCap"));
                int soLuong = rs.getInt("soLuongTon");
                double donGiaNhap = rs.getDouble("donGiaNhap");
                String moTa = rs.getString("moTa");
                String tinhTrang = rs.getString("tinhTrang");
                double donGiaBan = rs.getDouble("donGiaBan");
                double vat = rs.getDouble("VAT");
                MauSac mauSac = new MauSac(rs.getString("mauSac"));
                String noiSanXuat = rs.getString("noiSanXuat");
                Timestamp time = rs.getTimestamp("ngayTao");
                LocalDateTime ngayTao = time.toLocalDateTime();
                double giamGia = rs.getDouble("giamGia");
                vpp = new VanPhongPham(maSP, tenSP, nhomSP, nhaCC, soLuong, donGiaNhap, moTa, tinhTrang, donGiaBan, vat,
                        ngayTao, giamGia, mauSac, noiSanXuat);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
        finally {
            try {
                state.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return vpp;
    }

    public VanPhongPham getVpptheoTen(String ten) {
        VanPhongPham vpp = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from VanPhongPham where tenSanPham = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ten);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                String tenSP = rs.getString("tenSanPham");
                NhomSanPham nhomSP = new NhomSanPham(rs.getString("nhomSanPham"));
                NhaCungCap nhaCC = new NhaCungCap(rs.getString("nhaCungCap"));
                int soLuong = rs.getInt("soLuongTon");
                double donGiaNhap = rs.getDouble("donGiaNhap");
                String moTa = rs.getString("moTa");
                String tinhTrang = rs.getString("tinhTrang");
                double donGiaBan = rs.getDouble("donGiaBan");
                double vat = rs.getDouble("VAT");
                MauSac mauSac = new MauSac(rs.getString("mauSac"));
                String noiSanXuat = rs.getString("noiSanXuat");
                Timestamp time = rs.getTimestamp("ngayTao");
                LocalDateTime ngayTao = time.toLocalDateTime();
                double giamGia = rs.getDouble("giamGia");
                vpp = new VanPhongPham(maSP, tenSP, nhomSP, nhaCC, soLuong, donGiaNhap, moTa, tinhTrang,
                        donGiaBan, vat, ngayTao, giamGia, mauSac, noiSanXuat);

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                state.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return vpp;
    }

    public ArrayList<VanPhongPham> getDsVpptheoMa(String ma) {
        ArrayList<VanPhongPham> dsVpp = new ArrayList<VanPhongPham>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from VanPhongPham where maSanPham = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                String tenSP = rs.getString("tenSanPham");
                NhomSanPham nhomSP = new NhomSanPham(rs.getString("nhomSanPham"));
                NhaCungCap nhaCC = new NhaCungCap(rs.getString("nhaCungCap"));
                int soLuong = rs.getInt("soLuongTon");
                double donGiaNhap = rs.getDouble("donGiaNhap");
                String moTa = rs.getString("moTa");
                String tinhTrang = rs.getString("tinhTrang");
                double donGiaBan = rs.getDouble("donGiaBan");
                double vat = rs.getDouble("VAT");
                MauSac mauSac = new MauSac(rs.getString("mauSac"));
                String noiSanXuat = rs.getString("noiSanXuat");
                Timestamp time = rs.getTimestamp("ngayTao");
                LocalDateTime ngayTao = time.toLocalDateTime();
                double giamGia = rs.getDouble("giamGia");
                VanPhongPham vpp = new VanPhongPham(maSP, tenSP, nhomSP, nhaCC, soLuong, donGiaNhap, moTa, tinhTrang,
                        donGiaBan, vat, ngayTao, giamGia, mauSac, noiSanXuat);
                dsVpp.add(vpp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                state.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return dsVpp;
    }

    public void insertVpp(VanPhongPham vpp) {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "insert into VanPhongPham values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, vpp.getMaSanPham());
            stmt.setString(2, vpp.getTenSanPham());
            stmt.setString(3, vpp.getNhomSanPham().getMaNhomSanPham());
            stmt.setString(4, vpp.getNhaCungCap().getMaNCC());
            stmt.setInt(5, vpp.getSoLuongTon());
            stmt.setDouble(6, vpp.getDonGiaNhap());
            stmt.setString(7, vpp.getMoTa());
            stmt.setDouble(8, vpp.getDonGiaBan());
            stmt.setDouble(9, vpp.getVAT());
            stmt.setString(10, vpp.getMauSac().getMaMau());
            stmt.setString(11, vpp.getNoiSanXuat());
            stmt.setTimestamp(12, Timestamp.valueOf(vpp.getNgayTao()));
            stmt.setDouble(13, vpp.getGiamGia());
            stmt.setString(14, vpp.getTinhTrang());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lưu thất bại");
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
}
