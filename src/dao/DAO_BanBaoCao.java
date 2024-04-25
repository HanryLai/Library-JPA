/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BanBaoCao;
import entity.ChiTietBanBaoCao;
import entity.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TANLOC
 */
public class DAO_BanBaoCao {
    
    public ArrayList<BanBaoCao> getALLBanBaoCao(){
        ArrayList<BanBaoCao> danhSach = new ArrayList<BanBaoCao>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select maBanBaoCao, tenBanBaoCao, tenNhanVien, thoiGianBaoCao \n" +
                            "  from BanBaoCao";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                danhSach.add(new BanBaoCao(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public void taoBanBaoCao(BanBaoCao bbc){
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "insert into BanBaoCao(maBanBaoCao, tenBanBaoCao, tenNhanVien, doanhThu, thoiGianBaoCao)\r\n"
                    + "values \r\n"
                    + "(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bbc.getMaBanBaoCao());
            ps.setString(2, bbc.getTenBanBaoCao());
            ps.setString(3, bbc.getTenNhanVien());
            ps.setDouble(4, bbc.getDoanhThu());
            ps.setString(5, bbc.getThoiGianBaoCao());
            //ps.setString(6, bbc.getGhiChu());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Tạo thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lưu thất bại");
            e.printStackTrace();
        }
    }
    
    public String getMaBBCTheoTen(String tenBBC){
        String maBBC = "";
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select maBanBaoCao \n" +
                            "  from BanBaoCao where tenBanBaoCao = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenBBC);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                maBBC = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maBBC;
    }
}
