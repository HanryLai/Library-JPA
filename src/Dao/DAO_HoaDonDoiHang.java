/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connectDB.ConnectDB;
import Entity.HoaDon;
import Entity.HoaDonDoiHang;
import Entity.HoaDonHoanTra;
import Entity.KhachHang;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DAO_HoaDonDoiHang {

    public DAO_HoaDonDoiHang() {

    }

    public ArrayList<HoaDonDoiHang> getAllHoaDonDoiHang() {
        ArrayList<HoaDonDoiHang> dsHD = new ArrayList<HoaDonDoiHang>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from HoaDonDoiHang";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                HoaDonHoanTra h = new HoaDonHoanTra(rs.getString("hoaDonHoanTra"));
                String ghiChu = rs.getString(3);
                double tongTien = rs.getDouble(4);
                double chietKhau = rs.getDouble(5);
                String khuyenMai = rs.getString(6);
                HoaDonDoiHang hdht = new HoaDonDoiHang(maHD, h, ghiChu, tongTien, chietKhau, khuyenMai);
                dsHD.add(hdht);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsHD;
    }

    public boolean createHoaDonDoiHang(HoaDonDoiHang hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("insert into "
                    + "HoaDonDoiHang(maHoaDonDoi,hoaDonHoanTra,ghiChu,tienHoanTra,chietKhau,khuyenMai)"
                    + "VALUES(?,?,?,?,?,?)");
            state.setString(1, hd.getMaHoaDonDoi());
            state.setString(2, hd.getHoaDonHoanTra().getMaHoaDonHoanTra());
            state.setString(3, hd.getGhiChu());
            state.setDouble(4, hd.getTienHoanTra());
            state.setDouble(5, hd.getChietKhau());
            state.setString(6, hd.getKhuyenMai());
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

    public boolean updateHoaDonDoiHang(HoaDonDoiHang hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement(
                    "update HoaDonDoiHang set hoaDonHoanTra=?,ghiChu=?,tienHoanTra=?,chietKhau=?,khuyenMai=? where maHoaDonDoi=?");

            state.setString(1, hd.getHoaDonHoanTra().getMaHoaDonHoanTra());
            state.setString(2, hd.getGhiChu());
            state.setDouble(3, hd.getTienHoanTra());
            state.setDouble(4, hd.getChietKhau());
            state.setString(5, hd.getKhuyenMai());
            state.setString(6, hd.getMaHoaDonDoi());
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

    public HoaDonDoiHang getHoaDonDoiHangtheoMa(String ma) {
        HoaDonDoiHang hd = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from HoaDonDoiHang where maHoaDonDoi = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString(1);
                HoaDonHoanTra h = new HoaDonHoanTra(rs.getString("hoaDonHoanTra"));
                String ghiChu = rs.getString(3);
                double tongTien = rs.getDouble(4);
                double chietKhau = rs.getDouble(5);
                String khuyenMai = rs.getString(6);
                hd = new HoaDonDoiHang(maHD, h, ghiChu, tongTien,chietKhau,khuyenMai);
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
        return hd;
    }
    
    public HoaDonDoiHang getHoaDonDoiHangtheoMaHT(String ma) {
        HoaDonDoiHang hd = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from HoaDonDoiHang where hoaDonHoanTra = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString(1);
                HoaDonHoanTra h = new HoaDonHoanTra(rs.getString("hoaDonHoanTra"));
                String ghiChu = rs.getString(3);
                double tongTien = rs.getDouble(4);
                double chietKhau = rs.getDouble(5);
                String khuyenMai = rs.getString(6);
                hd = new HoaDonDoiHang(maHD, h, ghiChu, tongTien,chietKhau,khuyenMai);
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
        return hd;
    }

    public void deleteHoaDonDoi(String ma) {
        ConnectDB.getInstance();
        PreparedStatement pst = null;
        Connection con = ConnectDB.getConnection();

        String sql = "DELETE FROM HoaDonDoiHang WHERE maHoaDonDoi=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, ma);
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
}
