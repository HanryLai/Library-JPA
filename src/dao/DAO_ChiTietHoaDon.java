/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
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

public class DAO_ChiTietHoaDon {

    public DAO_ChiTietHoaDon() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
        ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from ChiTietHoaDon";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString("hoaDon"));
                SanPham sanPham = new SanPham(rs.getString("sanPham"));
                int soLuong = rs.getInt(3);
                double thanhTien = rs.getDouble(4);
                ChiTietHoaDon cthd = new ChiTietHoaDon(hoaDon, sanPham, soLuong, thanhTien);
                dsCTHD.add(cthd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCTHD;
    }

    public boolean createChiTietHoaDonVPP(ChiTietHoaDon cthd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("insert into "
                    + "ChiTietHoaDon(hoaDon,sanPham,soLuong,thanhTien)"
                    + "VALUES(?,?,?,?)");
            state.setString(1, cthd.getHoaDon().getMaHoaDon());
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

    public boolean createChiTietHoaDon(ChiTietHoaDon cthd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("insert into "
                    + "ChiTietHoaDon(hoaDon,sanPham,soLuong,thanhTien)"
                    + "VALUES(?,?,?,?)");
            state.setString(1, cthd.getHoaDon().getMaHoaDon());
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

//    public boolean updateChiTietHoaDon(ChiTietHoaDon cthd) {
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement state = null;
//        int n = 0;
//        try {
//            state = con.prepareStatement(
//                    "update ChiTietHoaDon set soLuong=?,thanhTien=? where hoaDon=?");
//
//            state.setString(1, cthd.getHoaDon().getMaHoaDon());
//            state.setString(2, cthd.getSanPham().getMaSanPham());
//            state.setInt(3, cthd.getSoLuong());
//            state.setDouble(4, cthd.getThanhTien());
//
//            n = state.executeUpdate();
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            try {
//                state.close();
//            } catch (SQLException e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
//        return n > 0;
//    }
    public void deleteChiTietHoaDonVaSanPham(String maHD, String maSP) {
        ConnectDB.getInstance();
        PreparedStatement pst = null;
        Connection con = ConnectDB.getConnection();

        String sql = "DELETE FROM ChiTietHoaDon WHERE hoaDon=? and sanPham=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, maHD);
            pst.setString(2, maSP);
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
    
    public void deleteChiTietHoaDon(String maHD) {
        ConnectDB.getInstance();
        PreparedStatement pst = null;
        Connection con = ConnectDB.getConnection();

        String sql = "DELETE FROM ChiTietHoaDon WHERE hoaDon=?";
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

    public ChiTietHoaDon getCTHoaDontheoMa(String ma1, String ma2) {
        ChiTietHoaDon ht = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from ChiTietHoaDon where hoaDon=? and sanPham=?";
            state = con.prepareStatement(sql);
            state.setString(1, ma1);
            state.setString(2, ma2);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString("hoaDon"));
                SanPham sanPham = new SanPham(rs.getString("sanPham"));
                int soLuong = rs.getInt(3);
                double thanhTien = rs.getDouble(4);
                ht = new ChiTietHoaDon(hoaDon, sanPham, soLuong, thanhTien);
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

    public boolean updateCTHoaDon(ChiTietHoaDon cthd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement(
                    "update ChiTietHoaDon set soLuong=?,thanhTien=? where hoaDon=? and sanPham=?");

            state.setInt(1, cthd.getSoLuong());
            state.setDouble(2, cthd.getThanhTien());
            state.setString(3, cthd.getHoaDon().getMaHoaDon());
            state.setString(4, cthd.getSanPham().getMaSanPham());

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
}
