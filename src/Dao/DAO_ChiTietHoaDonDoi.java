/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author nguyen chau tai
 */
import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonDoi;
import Entity.HoaDon;
import Entity.HoaDonDoiHang;
import Entity.SanPham;
import connectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DAO_ChiTietHoaDonDoi {

    public DAO_ChiTietHoaDonDoi() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<ChiTietHoaDonDoi> getAllChiTietDonDoi() {
        ArrayList<ChiTietHoaDonDoi> dsCTHD = new ArrayList<ChiTietHoaDonDoi>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from ChiTietDoiHang";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                HoaDonDoiHang hd = new HoaDonDoiHang(rs.getString("hoaDonDoiHang"));
                SanPham sanPham = new SanPham(rs.getString("sanPham"));
                int soLuong = rs.getInt(3);
                double thanhTien = rs.getDouble(4);
                ChiTietHoaDonDoi cthd = new ChiTietHoaDonDoi(hd, sanPham, soLuong, thanhTien);
                dsCTHD.add(cthd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCTHD;
    }

    public boolean createChiTietDonDoi(ChiTietHoaDonDoi cthd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("insert into "
                    + "ChiTietDoiHang(hoaDonDoiHang,sanPham,soLuong,thanhTien)"
                    + "VALUES(?,?,?,?)");
            state.setString(1, cthd.getHoaDonDoiHang().getMaHoaDonDoi());
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

    

    public void deleteChiTietDonDoi(String maHD) {
        ConnectDB.getInstance();
        PreparedStatement pst = null;
        Connection con = ConnectDB.getConnection();

        String sql = "DELETE FROM ChiTietDoiHang WHERE hoaDonDoiHang=?";
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
    public ChiTietHoaDonDoi getHoaDontheoMa(String ma1, String ma2) {
        ChiTietHoaDonDoi ht = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from ChiTietDoiHang where hoaDonDoiHang=? and sanPham=?";
            state = con.prepareStatement(sql);
            state.setString(1, ma1);
            state.setString(2, ma2);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                HoaDonDoiHang hoaDonDoiHang = new HoaDonDoiHang(rs.getString("hoaDonDoiHang"));
                SanPham sanPham = new SanPham(rs.getString("sanPham"));
                int soLuong = rs.getInt(3);
                double thanhTien = rs.getDouble(4);
                ht = new ChiTietHoaDonDoi(hoaDonDoiHang, sanPham, soLuong, thanhTien);
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
