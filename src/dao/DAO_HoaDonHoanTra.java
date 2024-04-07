/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author nguyen chau tai
 */
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.HoaDonHoanTra;
import entity.KhachHang;
import entity.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DAO_HoaDonHoanTra {

    public DAO_HoaDonHoanTra() {

    }

    public ArrayList<HoaDonHoanTra> getAllHoaDonHoanTra() {
        ArrayList<HoaDonHoanTra> dsHD = new ArrayList<HoaDonHoanTra>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select top 20 * from HoaDonHoanTra order by ngayHoan desc";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Timestamp time = rs.getTimestamp(2);
                LocalDateTime ngayLap = time.toLocalDateTime();
                NhanVien nhanVien = new NhanVien(rs.getString("nhanVien"));
                HoaDon h = new HoaDon(rs.getString("hoaDon"));
                String ghiChu = rs.getString(5);
                int tinhTrang = rs.getInt(6);
                double tongTienTra = rs.getDouble(7);

                HoaDonHoanTra hdht = new HoaDonHoanTra(maHD, ngayLap, nhanVien, h, ghiChu, tinhTrang, tongTienTra);
                dsHD.add(hdht);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsHD;
    }

    public boolean createHoaDonHoanTra(HoaDonHoanTra hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("insert into "
                    + "HoaDonHoanTra(maHoaDonHoanTra,ngayHoan,nhanVien,hoaDon,ghiChu,tinhTrangHoaDon,tienHoanTra)"
                    + "VALUES(?,?,?,?,?,?,?)");
            state.setString(1, hd.getMaHoaDonHoanTra());
            state.setTimestamp(2, Timestamp.valueOf(hd.getNgayHoan()));
            state.setString(3, hd.getNhanVien().getMaNhanVien());
            state.setString(4, hd.getHoaDon().getMaHoaDon());
            state.setString(5, hd.getGhiChu());
            state.setInt(6, hd.getTinhTrangHoaDon());
            state.setDouble(7, hd.getTienHoanTra());
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

    public boolean updateHoaDonHoanTra(HoaDonHoanTra hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement(
                    "update HoaDonHoanTra set ngayHoan=?,nhanVien=?,hoaDon=?,ghiChu=?,tinhTrangHoaDon=?,tienHoanTra=? where maHoaDonHoanTra=?");

            state.setTimestamp(1, Timestamp.valueOf(hd.getNgayHoan()));
            state.setString(2, hd.getNhanVien().getMaNhanVien());
            state.setString(3, hd.getHoaDon().getMaHoaDon());
            state.setString(4, hd.getGhiChu());
            state.setInt(5, hd.getTinhTrangHoaDon());
            state.setDouble(6, hd.getTienHoanTra());
            state.setString(7, hd.getMaHoaDonHoanTra());

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

    public HoaDonHoanTra getHoaDonHoanTratheoMa(String ma) {
        HoaDonHoanTra hd = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from HoaDonHoanTra where maHoaDonHoanTra = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maHoaDonHoanTra = rs.getString(1);
                Timestamp time = rs.getTimestamp(2);
                LocalDateTime ngayLap = time.toLocalDateTime();
                NhanVien nv = new NhanVien(rs.getString("nhanVien"));
                HoaDon h = new HoaDon(rs.getString("hoaDon"));
                String ghiChu = rs.getString(5);
                int tinhTrang = rs.getInt(6);
                double tongTien = rs.getDouble(7);

                hd = new HoaDonHoanTra(maHoaDonHoanTra, ngayLap, nv, h, ghiChu, tinhTrang, tongTien);
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

    public void deleteHoaDonHoanTra(String ma) {
        ConnectDB.getInstance();
        PreparedStatement pst = null;
        Connection con = ConnectDB.getConnection();

        String sql = "DELETE FROM HoaDonHoanTra WHERE maHoaDonHoanTra=?";
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
