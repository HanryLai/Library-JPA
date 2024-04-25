/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChiTietHoanTra;
import entity.HoaDon;
import entity.HoaDonHoanTra;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DAO_ChiTietHoaDonHoanTra {

    public DAO_ChiTietHoaDonHoanTra() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<ChiTietHoanTra> getAllChiTietHoanTra() {
        ArrayList<ChiTietHoanTra> dsCTHD = new ArrayList<ChiTietHoanTra>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from ChiTietHoanTra";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                HoaDonHoanTra hoaDon = new HoaDonHoanTra(rs.getString("hoaDonHoanTra"));
                SanPham sanPham = new SanPham(rs.getString("sanPham"));
                int soLuong = rs.getInt(3);
                double thanhTien = rs.getDouble(4);
                ChiTietHoanTra cthd = new ChiTietHoanTra(hoaDon, sanPham, soLuong, thanhTien);
                dsCTHD.add(cthd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCTHD;
    }
    public boolean createChiTietHoanTra(ChiTietHoanTra cthd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("insert into "
                    + "ChiTietHoanTra(hoaDonHoantra,sanPham,soLuong,thanhTien)"
                    + "VALUES(?,?,?,?)");
            state.setString(1, cthd.getHoaDonHoanTra().getMaHoaDonHoanTra());
            state.setString(2, cthd.getSanPham().getMaSanPham());
            state.setInt(3, cthd.getSoLuong());
            state.setDouble(4, cthd.getThanhTien());
            n = state.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                state.close();
            } catch (SQLException e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return n > 0;
    }

    

    public void deleteChiTietHoanTra(String maHD) {
        ConnectDB.getInstance();
        PreparedStatement pst = null;
        Connection con = ConnectDB.getConnection();

        String sql = "DELETE FROM ChiTietHoanTra WHERE hoaDonHoanTra=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, maHD);
            pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (SQLException e2) {
                // TODO: handle exceptione2 
                e2.printStackTrace();
            }
        }
    }
    public ChiTietHoanTra getHoaDontheoMa(String ma1, String ma2) {
        ChiTietHoanTra ht = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from ChiTietHoanTra where hoaDonHoanTra=? and sanPham=?";
            state = con.prepareStatement(sql);
            state.setString(1, ma1);
            state.setString(2, ma2);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                HoaDonHoanTra hoaDon = new HoaDonHoanTra(rs.getString("hoaDonHoanTra"));
                SanPham sanPham = new SanPham(rs.getString("sanPham"));
                int soLuong = rs.getInt(3);
                double thanhTien = rs.getDouble(4);
                ht = new ChiTietHoanTra(hoaDon, sanPham, soLuong, thanhTien);
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
        return ht;
    }
}
