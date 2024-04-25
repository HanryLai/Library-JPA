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

public class DAO_HoaDon{

    public DAO_HoaDon() {

    }

    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from HoaDon order by ngayLap desc";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                Timestamp time = rs.getTimestamp(2);
                LocalDateTime ngayLap = time.toLocalDateTime();
                NhanVien nhanVien = new NhanVien(rs.getString("nhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("khachHang"));
                String ghiChu = rs.getString(5);
                int tinhTrang = rs.getInt(6);
                double tongTien = rs.getDouble(7);
                double chietKhau = rs.getDouble(8);
                String khuyenMai = rs.getString(9);

                HoaDon hd = new HoaDon(maHD, ngayLap, nhanVien, khachHang, ghiChu, tinhTrang, tongTien,chietKhau,khuyenMai);
                dsHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsHD;
    }

    public boolean createHoaDon(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("insert into "
                    + "HoaDon(maHoaDon,ngayLap,nhanVien,khachHang,ghiChu,tinhTrangHoaDon,tongTien,chietKhau,khuyenMai)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)");
            state.setString(1, hd.getMaHoaDon());
            state.setTimestamp(2, Timestamp.valueOf(hd.getNgayLap()));
            state.setString(3, hd.getNhanVien().getMaNhanVien());
            state.setString(4, hd.getKhachHang().getMaKhachHang());
            state.setString(5, hd.getGhiChu());
            state.setInt(6, hd.getTinhTrangHoaDon());
            state.setDouble(7, hd.getTongTien());
            state.setDouble(8, hd.getChietKhau());
            state.setString(9, hd.getKhuyenMai());
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

    public boolean updateHoaDon(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement(
                    "update HoaDon set ngayLap=?,nhanVien=?,khachHang=?,ghiChu=?,tinhTrangHoaDon=?,tongTien=?,chietKhau=?,khuyenMai=? where maHoaDon=?");

            state.setTimestamp(1, Timestamp.valueOf(hd.getNgayLap()));
            state.setString(2, hd.getNhanVien().getMaNhanVien());
            state.setString(3, hd.getKhachHang().getMaKhachHang());
            state.setString(4, hd.getGhiChu());
            state.setInt(5, hd.getTinhTrangHoaDon());
            state.setDouble(6, hd.getTongTien());
            state.setDouble(7, hd.getChietKhau());
            state.setString(8, hd.getKhuyenMai());
            state.setString(9, hd.getMaHoaDon());

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

    public HoaDon getHoaDontheoMa(String ma) {
        HoaDon hd = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from HoaDon where maHoaDon = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString(1);
                Timestamp time = rs.getTimestamp(2);
                LocalDateTime ngayLap = time.toLocalDateTime();
                NhanVien nv = new NhanVien(rs.getString("nhanVien"));
                KhachHang kh = new KhachHang(rs.getString("khachHang"));
                String ghiChu = rs.getString(5);

                int tinhTrang = rs.getInt(6);
                double tongTien = rs.getDouble(7);
                double chietKhau = rs.getDouble(8);
                String khuyenMai = rs.getString(9);

                hd = new HoaDon(maHoaDon, ngayLap, nv, kh, ghiChu, tinhTrang, tongTien,chietKhau,khuyenMai);
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

    public void deleteHoaDon(String maHD) {
        ConnectDB.getInstance();
        PreparedStatement pst = null;
        Connection con = ConnectDB.getConnection();

        String sql = "DELETE FROM HoaDon WHERE maHoaDon=?";
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
    
    public String getMaHoaDonTheoNgay(String ngayLapHD){
        String maHD = "";
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "   SELECT TOP 1 LEFT(maHoaDon, CHARINDEX('-', maHoaDon) - 1)\n" +
                            "  FROM HoaDon\n" +
                            "  WHERE CONVERT(DATE, ngayLap) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ngayLapHD);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maHD = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maHD;
    }
}
