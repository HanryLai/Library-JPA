/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhomKhachHang;
import entity.NhomSanPham;

/**
 *
 * @author nguyen chau tai
 */
public class DAO_KhachHang {

    public DAO_KhachHang() {

    }

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT [maKhachHang], [tenKhachHang], [soDienThoai], [nhomKhachHang],\n" +
                            "[tongTienMua], [soLuongHoaDon]\n" +
                        "FROM [QuanLyHieuSachONEEIGHT].[dbo].[KhachHang]\n" +
                        "WHERE nhomKhachHang != 'KHACHLE'\n" +
                        "ORDER BY [maKhachHang] DESC;";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String maKhachHang = rs.getString(1);
                String tenKhachHang = rs.getString(2);
                String soDienThoai = rs.getString(3);
                NhomKhachHang nhomKhachHnang = NhomKhachHang.valueOf(rs.getString(4));
                double tongtienmua = rs.getDouble(5);
                int soLuongHoaDon = rs.getInt(6);
                KhachHang kHang = new KhachHang(maKhachHang, tenKhachHang, soDienThoai, nhomKhachHnang, tongtienmua, soLuongHoaDon);
                dsKhachHang.add(kHang);

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsKhachHang;
    }

    //Tìm Khách Hàng theo mã Khách Hàng
    public KhachHang getKHTheoMa(String ma) {
        KhachHang kh = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from KhachHang where maKhachHang = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                double tongTienMua = rs.getDouble(4);
                int soLuongHD = rs.getInt(5);
                NhomKhachHang nhomKhachHang = NhomKhachHang.valueOf(rs.getString(6));
                kh = new KhachHang(maKH, tenKH, sdt, nhomKhachHang, tongTienMua, soLuongHD);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
        return kh;
    }
    
    public KhachHang getKHTheoSDT(String soDienThoai) {
        KhachHang kh = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from KhachHang where soDienThoai = ?";
            state = con.prepareStatement(sql);
            state.setString(1, soDienThoai);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                double tongTienMua = rs.getDouble(4);
                int soLuongHD = rs.getInt(5);
                NhomKhachHang nhomKhachHang = NhomKhachHang.valueOf(rs.getString(6));
                kh = new KhachHang(maKH, tenKH, sdt, nhomKhachHang, tongTienMua, soLuongHD);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
        return kh;
    }
    
    // Hàm Thêm Khách Hàng
    public void themKhachHang(KhachHang cus) {
    	ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "insert into KhachHang (maKhachHang,tenKhachHang,soDienThoai,nhomKhachHang,tongTienMua,soLuongHoaDon)\r\n"
                    + "  values (?,?,?,?,?,?)";
            PreparedStatement pState = con.prepareStatement(sql);
            pState.setString(1, cus.getMaKhachHang());
            pState.setString(2, cus.getTenKhachHang());
            pState.setString(3, cus.getSoDienThoai());
            pState.setString(4, cus.getNhomKhachHang().toString());
            pState.setDouble(5, cus.getTongTienMua());
            pState.setInt(6, cus.getSoLuongHoaDon());
            if (pState.executeUpdate() == 1) {
//                JOptionPane.showMessageDialog(null, "Đã Thêm khách hàng thành công và lưu vào DATABASE");
            }

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Thêm Khách Hàng không thành công");
            e.printStackTrace();
        }
    }
    
    // Hàm Cập nhật thông tin khách Hàng 
    public boolean updateKhachHang(KhachHang cus) {
        Connection con = null;
        PreparedStatement pState = null;
        
        try {
            con = ConnectDB.getConnection();
            String sql = "UPDATE KhachHang SET tenKhachHang = ?, soDienThoai = ?, tongTienMua = ?, soLuongHoaDon=?  WHERE maKhachHang = ?";
            pState = con.prepareStatement(sql);
            pState.setString(1, cus.getTenKhachHang());
            pState.setString(2, cus.getSoDienThoai());
            pState.setDouble(3, cus.getTongTienMua());
            pState.setInt(4, cus.getSoLuongHoaDon());
            pState.setString(5, cus.getMaKhachHang());

            int n = pState.executeUpdate();
            if (n > 0) {
//                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                return true;
            } else {
//                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                return false;
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
            e.printStackTrace();
            return false;
        } 
    }

    //lọc toàn bộ dữ liệu có thể tồn tại trong đối tượng <Khách Hàng>
    public ArrayList<KhachHang> locDuLieuKhachHang(String data) {
        ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT [maKhachHang],[tenKhachHang],[soDienThoai],[nhomKhachHang],[tongTienMua],[soLuongHoaDon]\r\n"
                    + "FROM [QuanLyHieuSachONEEIGHT].[dbo].[KhachHang] WHERE nhomKhachHang != 'KHACHLE' AND \r\n"
                    + "		 (maKhachHang LIKE ? OR \r\n"
                    + "      tenKhachHang LIKE ? OR \r\n"
                    + "      soDienThoai LIKE ? OR \r\n"
                    + "      nhomKhachHang LIKE ? OR \r\n"
                    + "      tongTienMua LIKE ? OR \r\n"
                    + "      soLuongHoaDon LIKE ?)\r\n";

            PreparedStatement pState = con.prepareStatement(sql);
            pState.setString(1, "%" + data + "%");
            pState.setString(2, "%" + data + "%");
            pState.setString(3, "%" + data + "%");
            pState.setString(4, "%" + data + "%");
            pState.setString(5, "%" + data + "%");
            pState.setString(6, "%" + data + "%");
            ResultSet rs = pState.executeQuery();
            while (rs.next()) {
                dsKhachHang.add(new KhachHang(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        NhomKhachHang.valueOf(rs.getString(4)),
                        rs.getDouble(5),
                        rs.getInt(6)));

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsKhachHang;
    }
    
    //Tự động cập nhật nhóm khách hàng dựa vào tổng tiền mua
    public static void capNhatNhomKhachHang() {
     Connection con = null;
        PreparedStatement preparedStatement = null;   

        try {
	            con = ConnectDB.getConnection();
	            String query = "UPDATE KhachHang SET nhomKhachHang = 'KHACHVIP' WHERE tongTienMua >= 1000000;";
	            preparedStatement = con.prepareStatement(query);
	            preparedStatement.executeUpdate();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	} 
        }
    
    //lấy khách hàng đã mua hàng trong tháng hiện tại
    public ArrayList<KhachHang> getKhachHangTrong1Thang() {
        ArrayList<KhachHang> dsKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        try (Connection con = ConnectDB.getConnection()) {
            String sql = "SELECT [maKhachHang], [tenKhachHang], [soDienThoai], [nhomKhachHang], " +
                         "[tongTienMua], [soLuongHoaDon] " +
                         "FROM [QuanLyHieuSachONEEIGHT].[dbo].[KhachHang] " +
                         "WHERE [maKhachHang] IN (" +
                             "SELECT [khachHang] " +
                             "FROM [QuanLyHieuSachONEEIGHT].[dbo].[HoaDon] " +
                             "WHERE MONTH([ngayLap]) = MONTH(GETDATE())" +")";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql);
                 ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    String maKhachHang = rs.getString(1);
                    String tenKhachHang = rs.getString(2);
                    String soDienThoai = rs.getString(3);
                    NhomKhachHang nhomKhachHang = NhomKhachHang.valueOf(rs.getString(4));
                    double tongTienMua = rs.getDouble(5);
                    int soLuongHoaDon = rs.getInt(6);
                    KhachHang khachHang = new KhachHang(maKhachHang, tenKhachHang, soDienThoai, nhomKhachHang, tongTienMua, soLuongHoaDon);
                    dsKhachHang.add(khachHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKhachHang;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }











