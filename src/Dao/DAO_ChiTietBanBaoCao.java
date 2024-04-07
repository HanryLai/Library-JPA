/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.ChiTietBanBaoCao;
import connectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author TANLOC
 */
public class DAO_ChiTietBanBaoCao {
    public void taoChiTietBanBaoCao(ChiTietBanBaoCao ctbbc){
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            if (ctbbc.getBanBaoCao() == null || ctbbc.getBanBaoCao().getMaBanBaoCao() == null) {
                JOptionPane.showMessageDialog(null, "Đối tượng BanBaoCao không hợp lệ");
                return; // hoặc xử lý trường hợp giá trị null một cách phù hợp
            }
            String sql = "INSERT INTO ChiTietBanBaoCao(banBaoCao, sanPham, soLuongBan, "
                        + "thanhTien, soLuongNhap, tonKho, ghiChu)\n" +
                        "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ctbbc.getBanBaoCao().getMaBanBaoCao());
            ps.setString(2, ctbbc.getTenSanPham());
            ps.setInt(3, ctbbc.getSoLuongBan());
            ps.setDouble(4, ctbbc.getThanhTien());
            ps.setInt(5, ctbbc.getSoLuongNhap());
            ps.setInt(6, ctbbc.getTonKho());
            ps.setString(7, ctbbc.getGhiChu());
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lưu thất bại");
            e.printStackTrace();
        }
    }
    public ArrayList<ChiTietBanBaoCao> getSachDaBan(String maHD, String TGBD, String TGKT){
        ArrayList<ChiTietBanBaoCao> danhSach = new ArrayList<ChiTietBanBaoCao>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select s.tenSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien\n" +
                            "from Sach s\n" +
                            "inner join ChiTietHoaDon ct on ct.sanPham = s.maSanPham\n" +
                            "inner join HoaDon hd on hd.maHoaDon = ct.hoaDon\n" +
                            "where hoaDon like ? and (ngayLap >= ? and ngayLap < ?)\n" +
                            "group by s.tenSanPham";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ps.setString(2, TGBD);
            ps.setString(3, TGKT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(new ChiTietBanBaoCao(rs.getString("tenSanPham"), 
                        rs.getInt("soLuong"), 
                        rs.getDouble("thanhTien"), 
                        ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public ArrayList<ChiTietBanBaoCao> getVPPDaBan(String maHD, String TGBD, String TGKT){
        ArrayList<ChiTietBanBaoCao> danhSach = new ArrayList<ChiTietBanBaoCao>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select v.tenSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien  \n" +
                            "  from VanPhongPham v\n" +
                            "inner join ChiTietHoaDon ct on ct.sanPham = v.maSanPham\n" +
                            "inner join HoaDon hd on hd.maHoaDon = ct.hoaDon\n" +
                            "   where hoaDon like ? and (ngayLap >= ? and ngayLap < ?)\n" +
                            "  group by v.tenSanPham";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ps.setString(2, TGBD);
            ps.setString(3, TGKT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(new ChiTietBanBaoCao(rs.getString("tenSanPham"), 
                        rs.getInt("soLuong"), 
                        rs.getDouble("thanhTien"), 
                        ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
   
    
    public ArrayList<ChiTietBanBaoCao> getTinhTrangNhapSach(String ngayTao){
        ArrayList<ChiTietBanBaoCao> danhSach = new ArrayList<ChiTietBanBaoCao>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "WITH CumulativeSumCTE AS (\n" +
                            "SELECT\n" +
                            "    tenSanPham,\n" +
                            "    soLuongTon as soLuongNhap,\n" +
                            "    ngayTao,\n" +
                            "    SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon\n" +
                            "FROM\n" +
                            "    Sach\n" +
                            ")\n" +
                            "SELECT\n" +
                            "    tenSanPham,\n" +
                            "    MAX(soLuongNhap) AS soLuongNhap,\n" +
                            "    MAX(CumulativeSoLuongTon) AS tonKho\n" +
                            "FROM\n" +
                            "    CumulativeSumCTE\n" +
                            "WHERE\n" +
                            "    CONVERT(DATE, ngayTao) = ?\n" +
                            "GROUP BY\n" +
                            "    tenSanPham;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ngayTao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(new ChiTietBanBaoCao(  rs.getString(1), 
                                                    rs.getInt(2), 
                                                    rs.getInt(3),
                                                    ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public ArrayList<ChiTietBanBaoCao> getTinhTrangNhapVPP(String ngayTao){
        ArrayList<ChiTietBanBaoCao> danhSach = new ArrayList<ChiTietBanBaoCao>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "WITH CumulativeSumCTE AS (\n" +
                            "SELECT\n" +
                            "    tenSanPham,\n" +
                            "    soLuongTon as soLuongNhap,\n" +
                            "    ngayTao,\n" +
                            "    SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon\n" +
                            "FROM\n" +
                            "    VanPhongPham\n" +
                            ")\n" +
                            "SELECT\n" +
                            "    tenSanPham,\n" +
                            "    MAX(soLuongNhap) AS soLuongNhap,\n" +
                            "    MAX(CumulativeSoLuongTon) AS tonKho\n" +
                            "FROM\n" +
                            "    CumulativeSumCTE\n" +
                            "WHERE\n" +
                            "    CONVERT(DATE, ngayTao) = ?\n" +
                            "GROUP BY\n" +
                            "    tenSanPham;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ngayTao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(new ChiTietBanBaoCao(  rs.getString(1), 
                                                    rs.getInt(2), 
                                                    rs.getInt(3),
                                                    ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    

    
    public double getDoanhThuTheoCa(String maHD, String thoiGianBD, String thoiGianKT){
        double doanhThu = 0;
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select sum(ThanhTien) as ThanhTien\n" +
                            "from HoaDon hd\n" +
                            "inner join ChiTietHoaDon cthd on hd.maHoaDon = cthd.hoaDon\n" +
                            "inner join NhanVien nv on nv.maNhanVien = hd.nhanVien\n" +
                            "where hd.maHoaDon like ? and (ngayLap >= ? and ngayLap < ?)\n" +
                            "group by nv.caLamViec";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD+"%");
            ps.setString(2, thoiGianBD);
            ps.setString(3, thoiGianKT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThu;
    }
    
    public ArrayList<ChiTietBanBaoCao> getChiTietBanBaoCao(String maBanBaoCao){
        ArrayList<ChiTietBanBaoCao> danhSach = new ArrayList<ChiTietBanBaoCao>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "  select sanPham, soLuongBan, thanhTien, ghiChu\n" +
                            "  from ChiTietBanBaoCao\n" +
                            "  where banBaoCao like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maBanBaoCao);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(new ChiTietBanBaoCao(rs.getString("sanPham"), 
                        rs.getInt("soLuongBan"), 
                        rs.getDouble("thanhTien"), 
                        ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public double getDoanhThuCaNgay(String maBBC){
        double doanhThu = 0;
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select sum(thanhTien)\n" +
                            "from ChiTietBanBaoCao\n" +
                            "where banBaoCao like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maBBC+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThu;
    }
    
    public int getTongSPBanDuoc(String maBBC){
        int soLuong = 0;
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select sum(soLuongBan)\n" +
                            "from ChiTietBanBaoCao\n" +
                            "where banBaoCao like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maBBC+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
    }
    public double getDoanhThuTheoTenBC(String tenBBC){
        double doanhThu=0;
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "select doanhThu\n" +
                            "from BanBaoCao\n" +
                            "where tenBanBaoCao like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenBBC);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                doanhThu = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThu;
    }
}
