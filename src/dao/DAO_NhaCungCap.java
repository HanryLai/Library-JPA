/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhaCungCap;

/**
 *
 * @author nguyen chau tai
 */
public class DAO_NhaCungCap {

    public ArrayList<NhaCungCap> getALLNhaCungCap() {
        ArrayList<NhaCungCap> danhSach = new ArrayList<NhaCungCap>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select maNCC, tenNCC, diachiNCC, soDienThoai, email, ghiChu from NhaCungCap";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                danhSach.add(new NhaCungCap(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public NhaCungCap getNCCTheoMa(String maNCC) {
        NhaCungCap ncc = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "select maNCC, tenNCC, diaChiNCC, soDienThoai, email, ghiChu from NhaCungCap where maNCC=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maNCC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ncc = new NhaCungCap(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return ncc;
    }

    
    public NhaCungCap getNCCTheoTen(String tenNCC) {
        NhaCungCap ncc = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "select * from NhaCungCap where tenNCC = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tenNCC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ncc = new NhaCungCap(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return ncc;
    }
    public void themNhaCungCap(NhaCungCap ncc) {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "insert into NhaCungCap(maNCC, tenNCC, diaChiNCC, soDienThoai, email, ghiChu)\r\n"
                    + "values \r\n"
                    + "(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getDiaChiNCC());
            ps.setString(4, ncc.getSoDienThoai());
            ps.setString(5, ncc.getEmail());
            ps.setString(6, ncc.getGhiChu());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Đã lưu vào Database");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lưu thất bại");
            e.printStackTrace();
        } finally {
            ConnectDB.disconnect();
        }

    }

    public boolean updateNhaCungCap(String maSua, NhaCungCap nccMoi) {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "update NhaCungCap\n"
                    + "set tenNCC = ?,\n"
                    + "diaChiNCC = ?,\n"
                    + "soDienThoai = ?,\n"
                    + "email = ?,\n"
                    + "ghiChu = ?\n"
                    + "where maNCC = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nccMoi.getTenNCC());
            ps.setString(2, nccMoi.getDiaChiNCC());
            ps.setString(3, nccMoi.getSoDienThoai());
            ps.setString(4, nccMoi.getEmail());
            ps.setString(5, nccMoi.getGhiChu());
            ps.setString(6, maSua);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
            e.printStackTrace();
        }
        return false;
    }
    
//    public int getID(){
//        ConnectDB.getInstance().connect();
//        Connection con = ConnectDB.getConnection();
//        int iD = 0;
//        try {
//            String sql = "select top 1 maNCC from NhaCungCap order by maNCC desc";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                iD = rs.getInt("maNCC");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return iD+1;
//    }
    
    public ArrayList<NhaCungCap> locNhaCungCap(String duLieuTim){
        ArrayList<NhaCungCap> danhSach = new ArrayList<NhaCungCap>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select maNCC, tenNCC, diaChiNCC, soDienThoai, email, ghiChu from NhaCungCap\n" +
                            "where maNCC like ? or \n" +
                            "tenNCC like ? or\n" +
                            "diachiNCC like ? or\n" +
                            "soDienThoai like ? or\n" +
                            "email like ? or\n" +
                            "ghiChu like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"%"+ duLieuTim + "%");
            ps.setString(2,"%"+ duLieuTim + "%");
            ps.setString(3,"%"+ duLieuTim + "%");
            ps.setString(4,"%"+ duLieuTim + "%");
            ps.setString(5,"%"+ duLieuTim + "%");
            ps.setString(6,"%"+ duLieuTim + "%");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                danhSach.add(new NhaCungCap(rs.getString(1), 
                                            rs.getString(2), 
                                            rs.getString(3),                   
                                            rs.getString(4), 
                                            rs.getString(5), 
                                            rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public String getMaNhaCungCapDB(){
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        String tmp = "";
        try {
                String sql =    "SELECT top 1 maNCC \n" +
                                "FROM NhaCungCap\n" +
                                "ORDER BY \n" +
                                "CONVERT(DATE, SUBSTRING(maNCC, 4, 2) + '/' + SUBSTRING(maNCC, 6, 2) + '/' + SUBSTRING(maNCC, 8, 4), 103) DESC,\n" +
                                "CAST(SUBSTRING(maNCC, 13, LEN(maNCC)) AS INT) DESC;";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {
                    tmp = rs.getString(1);
                }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return tmp;
    }
}
