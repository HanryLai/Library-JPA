package dao;

import connectDB.ConnectDB;
import entity.KhuyenMai;
import entity.NhomKhuyenMai;
import entity.NhomSanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAO_NhomKhuyenMai {
    public DAO_NhomKhuyenMai(){
        
    }
    //
    public ArrayList<NhomKhuyenMai> getAllNhomKM() {
        ArrayList<NhomKhuyenMai> dsKM = new ArrayList<NhomKhuyenMai>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from NhomKhuyenMai";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString("khuyenMai"));
                NhomSanPham nhomSanPham = new NhomSanPham(rs.getString("nhomSanPham"));
                
                NhomKhuyenMai km = new NhomKhuyenMai(khuyenMai, nhomSanPham);
                dsKM.add(km);

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsKM;
    }
    
    public void createNhomKM(KhuyenMai s, NhomSanPham nsp) {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            String sql = "insert into NhomKhuyenMai values (?, ?)";
            state = con.prepareStatement(sql);
            state.setString(1, s.getMaKhuyenMai());
            state.setString(2, nsp.getMaNhomSanPham());
            
            n = state.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lưu thất bại");
            e.printStackTrace();
        } finally {
            try {
                state.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
    
    public void deleteNhomKM(KhuyenMai s) {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            String sql = "delete from NhomKhuyenMai where khuyenMai = ?";
            state = con.prepareStatement(sql);
            state.setString(1, s.getMaKhuyenMai());
            
            n = state.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lưu thất bại");
            e.printStackTrace();
        } finally {
            try {
                state.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
}
