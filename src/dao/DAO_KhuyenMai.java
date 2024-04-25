/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.ctc.wstx.shaded.msv_core.reader.trex.ng.NGNameState;
import otherEntity.KhuyenMai;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DNCO
 */
public class DAO_KhuyenMai {
    public DAO_KhuyenMai(){
        
    }
    public ArrayList<KhuyenMai> getAlltbKM() {
        ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        try {
//            String sql = "select * from KhuyenMai";
//            Statement state = con.createStatement();
//            ResultSet rs = state.executeQuery(sql);
//            while (rs.next()) {
//                String maKM = rs.getString(1);
//                String tenKM = rs.getString(2);
//                String ghiChu = rs.getString(3);
//                String trangThai = rs.getString(4);
//                double tiLeKM = rs.getDouble(5);
//                double tienToiThieu = rs.getDouble(6);
//                double giaTriMAX = rs.getDouble(7);
//                Timestamp time = rs.getTimestamp(8);
//                LocalDateTime ngayBD = time.toLocalDateTime();
//                Timestamp time2 = rs.getTimestamp(9);
//                LocalDateTime ngayKT = time2.toLocalDateTime();
//                KhuyenMai km = new KhuyenMai(maKM, tenKM, ghiChu, trangThai, tiLeKM, 
//                    tienToiThieu, giaTriMAX, ngayBD, ngayKT);
//                dsKM.add(km);
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
        return dsKM;
    }
    
    public void createKhuyenMai(KhuyenMai s) {
//        ConnectDB.getInstance().connect();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement state = null;
//        int n = 0;
//        try {
//            String sql = "insert into KhuyenMai values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            state = con.prepareStatement(sql);
//            state.setString(1, s.getMaKhuyenMai());
//            state.setString(2, s.getTenKhuyenMai());
//            state.setString(3, s.getGhiChu());
//            state.setString(4, s.getTrangThai());
//            state.setDouble(5, s.getTiLeKM());
//            state.setDouble(6, s.getTienToiThieu());
//            state.setDouble(7, s.getGiaTriMAX());
//            state.setTimestamp(8, Timestamp.valueOf(s.getNgayBatDau()));
//            state.setTimestamp(9, Timestamp.valueOf(s.getNgayKetThuc()));
//            n = state.executeUpdate();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lưu thất bại");
//            e.printStackTrace();
//        } finally {
//            try {
//                state.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
    }
    
    public ArrayList<KhuyenMai> getAlltbKMTheoDangChay() {
        ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        try {
//
//            String sql = "SELECT * FROM KhuyenMai WHERE trangThai = 'Đang hoạt động'";
//            Statement state = con.createStatement();
//            ResultSet rs = state.executeQuery(sql);
//            while (rs.next()) {
//                String maKM = rs.getString(1);
//                String tenKM = rs.getString(2);
//                String ghiChu = rs.getString(3);
//                String trangThai = rs.getString(4);
//                double tiLeKM = rs.getDouble(5);
//                double tienToiThieu = rs.getDouble(6);
//                double giaTriMAX = rs.getDouble(7);
//                Timestamp time = rs.getTimestamp(8);
//                LocalDateTime ngayBD = time.toLocalDateTime();
//                Timestamp time2 = rs.getTimestamp(9);
//                LocalDateTime ngayKT = time2.toLocalDateTime();
//                
//                KhuyenMai km = new KhuyenMai(maKM, tenKM, ghiChu, trangThai, tiLeKM, 
//                        tienToiThieu, giaTriMAX, ngayBD, ngayKT);
//
//                dsKM.add(km);
//
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
        return dsKM;
    }
    
    public KhuyenMai getKMtheoMa(String ma) {
//        KhuyenMai km = null;
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement state = null;
//        try {
//            String sql = "select * from KhuyenMai where maKhuyenMai = ?";
//            state = con.prepareStatement(sql);
//            state.setString(1, ma);
//            ResultSet rs = state.executeQuery();
//            while (rs.next()) {
//                String maKM = rs.getString(1);
//                String tenKM = rs.getString(2);
//                String ghiChu = rs.getString(3);
//                String trangThai = rs.getString(4);
//                double tiLeKM = rs.getDouble(5);
//                double tienToiThieu = rs.getDouble(6);
//                double giaTriMAX = rs.getDouble(7);
//                Timestamp time = rs.getTimestamp(8);
//                LocalDateTime ngayBD = time.toLocalDateTime();
//                Timestamp time2 = rs.getTimestamp(9);
//                LocalDateTime ngayKT = time2.toLocalDateTime();
//
//                km = new KhuyenMai(maKM, tenKM, ghiChu, trangThai, tiLeKM,
//                        tienToiThieu, giaTriMAX, ngayBD, ngayKT);
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            try {
//                state.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
        return null;
    }
    public void updateKhuyenMai(KhuyenMai s) {
//        ConnectDB.getInstance().connect();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement state = null;
//        int n = 0;
//        try {
//            String sql = "update KhuyenMai set tenKhuyenMai = ?, ghiChu = ?, trangThai = ?, "
//                    + "tyLeKhuyenMai = ?, tienToiThieu = ?, giaTriKhuyenMaiToiDa = ?, ngayBatDau = ?,"
//                    + " ngayKetThuc = ? where maKhuyenMai = ?";
//            state = con.prepareStatement(sql);
//            
//            state.setString(1, s.getTenKhuyenMai());
//            state.setString(2, s.getGhiChu());
//            state.setString(3, s.getTrangThai());
//            state.setDouble(4, s.getTiLeKM());
//            state.setDouble(5, s.getTienToiThieu());
//            state.setDouble(6, s.getGiaTriMAX());
//            state.setTimestamp(7, Timestamp.valueOf(s.getNgayBatDau()));
//            state.setTimestamp(8, Timestamp.valueOf(s.getNgayKetThuc()));
//            state.setString(9, s.getMaKhuyenMai());
//            n = state.executeUpdate();
//        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, "Lưu thất bại");
//            e.printStackTrace();
//        } finally {
//            try {
//                state.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
    }
    
    public String getMaKhuyenMaiTNDB() {
        String tmp = "";
//        ConnectDB.getInstance().connect();
//        Connection con = ConnectDB.getConnection();
//
//        try {
//            String sql = "SELECT top 1 maKhuyenMai\n"
//                    + "FROM KhuyenMai\n"
//                    + "WHERE maKhuyenMai like 'KM%'\n"
//                    + "ORDER BY CONVERT(DATE, RIGHT(LEFT(maKhuyenMai, 8), 4) + SUBSTRING(maKhuyenMai, 5, 2) \n"
//                    + "+ RIGHT(maKhuyenMai, 2), 112) DESC, CAST(SUBSTRING(maKhuyenMai, 11, LEN(maKhuyenMai)) AS INT) \n"
//                    + "DESC";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                tmp = rs.getString(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return tmp;
    }
    
    public void updateTinhTrang(KhuyenMai km) {
//        ConnectDB.getInstance().connect();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement state = null;
//        int n = 0;
//        try {
//            String sql = "update KhuyenMai set trangThai = ? where maKhuyenMai = ?";
//            state = con.prepareStatement(sql);
//            
//            String tt = "";
//            if(km.getNgayKetThuc().isBefore(LocalDateTime.now())){
//                tt = "Đã ngừng";
//            }else tt = "Đang hoạt động";
//            
//            state.setString(1, tt);
//            state.setString(2, km.getMaKhuyenMai());
//            n = state.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                state.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
    }
    
    public KhuyenMai getKmTheoMa(String maKM) {
        KhuyenMai km = null;
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement ps = null;
//        try {
//            String sql = "select * from KhuyenMai where maKhuyenMai = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, maKM);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String maKm = rs.getString(1);
//                String tenKM = rs.getString(2);
//                String ghiChu = rs.getString(3);
//                String trangThai = rs.getString(4);
//                double tiLeKM = rs.getDouble(5);
//                double tienToiThieu = rs.getDouble(6);
//                double giaTriMAX = rs.getDouble(7);
//                Timestamp time = rs.getTimestamp(8);
//                LocalDateTime ngayBD = time.toLocalDateTime();
//                Timestamp time2 = rs.getTimestamp(9);
//                LocalDateTime ngayKT = time2.toLocalDateTime();
//                
//                km = new KhuyenMai(maKm, tenKM, ghiChu, trangThai, tiLeKM, 
//                    tienToiThieu, giaTriMAX, ngayBD, ngayKT);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ps.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
        return km;
    }
}
