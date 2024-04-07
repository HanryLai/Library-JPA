/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.awt.Taskbar.State;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import Entity.CaLamViec;
import Entity.ChucVu;
import Entity.NhaCungCap;
import Entity.NhanVien;
import Entity.TaiKhoan;

/**
 *
 * @author nguyen chau tai
 */
public class DAO_NhanVien {

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> danhSach = new ArrayList<NhanVien>();
        ConnectDB.getInstance().connect();

        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select maNhanVien, hoTenNV, ngaySinh, soDienThoaiNV, gioiTinh, email,"
                    + "taiKhoan, tinhTrangLamViec, caLamViec, chucVu from NhanVien";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(7));
                CaLamViec caLamViec = new CaLamViec(rs.getString(9));
                danhSach.add(new NhanVien(rs.getString(1),
                        rs.getString(2),
                        LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-M-d")),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        taiKhoan.getTenDangNhap(),
                        Integer.parseInt(rs.getString(8)),
                        caLamViec.getMaCa(),
                        ChucVu.valueOf(rs.getString(10))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public ArrayList<NhanVien> getAllNhanVienTheoCa(String caLv) {
        ArrayList<NhanVien> danhSach = new ArrayList<NhanVien>();
        ConnectDB.getInstance().connect();

        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select maNhanVien, hoTenNV, ngaySinh, soDienThoaiNV, gioiTinh, email,"
                    + "taiKhoan, tinhTrangLamViec, caLamViec, chucVu from NhanVien where caLamViec = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, caLv);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(7));
                CaLamViec caLamViec = new CaLamViec(rs.getString(9));
                danhSach.add(new NhanVien(rs.getString(1),
                        rs.getString(2),
                        LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-M-d")),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        taiKhoan.getTenDangNhap(),
                        Integer.parseInt(rs.getString(8)),
                        caLamViec.getMaCa(),
                        ChucVu.valueOf(rs.getString(10))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public NhanVien getNVTheoMa(String maNV) {
        NhanVien nv = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "select maNhanVien, hoTenNV, ngaySinh, soDienThoaiNV, gioiTinh, email, taiKhoan, tinhTrangLamViec, caLamViec, chucVu from NhanVien where maNhanVien = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(7));
                CaLamViec caLamViec = new CaLamViec(rs.getString(9));
                nv = new NhanVien(rs.getString(1),
                        rs.getString(2),
                        LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-M-d")),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        taiKhoan.getTenDangNhap(),
                        rs.getInt(8),
                        caLamViec.getMaCa(),
                        ChucVu.valueOf(rs.getString(10)));
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
        return nv;
    }

    public void themNhanVien(NhanVien nv) {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql1 = "insert into TaiKhoan(tenDangNhap, matKhau, email) values (?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, nv.getMaNhanVien());
            ps1.setString(2, "");
            ps1.setString(3, nv.getEmail());
            ps1.executeUpdate();

            String sql = "insert into NhanVien(maNhanVien, hoTenNV, ngaySinh, soDienthoaiNV, gioiTinh, email, taiKhoan, tinhTrangLamViec, caLamViec, chucVu)\r\n"
                    + "values \r\n"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getHoTenNV());
            String ngaySinh = nv.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-M-d")).toString();
            ps.setString(3, ngaySinh);
            ps.setString(4, nv.getSoDienThoai());
            ps.setString(5, nv.getGioiTinh());
            ps.setString(6, nv.getEmail());
            String taiKhoan = nv.getTenDangNhap();
            ps.setString(7, taiKhoan);
            ps.setInt(8, nv.getTinhTrangLamViec());

            String caLamViec = nv.getCaLamViec().getMaCa();
            System.out.println("aaaa-" + caLamViec.length());

            ps.setString(9, caLamViec);
            String chucVu = nv.getChucVu().toString();
            ps.setString(10, chucVu);

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

    public boolean updateNhanVien(String maNVSua, NhanVien nvMoi){
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql =    "update NhanVien\n" +
                            "set hoTenNV=?,\n" +
                            "soDienThoaiNV=?,\n" +
                            "gioiTinh=?, \n" +
                            "email=?,\n" +
                            "tinhTrangLamViec=?,\n" +
                            "caLamViec=?,\n" +
                            "chucVu=?\n" +
                            "where maNhanVien=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nvMoi.getHoTenNV());
            ps.setString(2, nvMoi.getSoDienThoai());
            ps.setString(3, nvMoi.getGioiTinh());
            ps.setString(4, nvMoi.getEmail());
            ps.setInt(5, nvMoi.getTinhTrangLamViec());
            ps.setString(6, nvMoi.getCaLamViec().getMaCa());
            ps.setString(7, nvMoi.getChucVu().toString());
            ps.setString(8, maNVSua);
            
            if(ps.executeUpdate()==1){
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<NhanVien> locNhanVien(String duLieuTim) {
        ArrayList<NhanVien> danhSach = new ArrayList<NhanVien>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select maNhanVien, hoTenNV, ngaySinh, soDienThoaiNV, gioiTinh,\n"
                    + "email, TaiKhoan, tinhTrangLamViec, CaLamViec, chucVu\n"
                    + "from NhanVien\n"
                    + "where maNhanVien like ? or \n"
                    + "hoTenNV like ? or \n"
                    + "ngaySinh like ? or \n"
                    + "soDienThoaiNV like ? or \n"
                    + "gioiTinh like ? or\n"
                    + "email like ? or \n"
                    + "TaiKhoan like ? or \n"
                    + "tinhTrangLamViec like ? or \n"
                    + "CaLamViec like ? or \n"
                    + "chucVu like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + duLieuTim + "%");
            ps.setString(2, "%" + duLieuTim + "%");
            ps.setString(3, "%" + duLieuTim + "%");
            ps.setString(4, "%" + duLieuTim + "%");
            ps.setString(5, "%" + duLieuTim + "%");
            ps.setString(6, "%" + duLieuTim + "%");
            ps.setString(7, "%" + duLieuTim + "%");
            ps.setString(8, "%" + duLieuTim + "%");
            ps.setString(9, "%" + duLieuTim + "%");
            ps.setString(10, "%" + duLieuTim + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(7));
                CaLamViec caLamViec = new CaLamViec(rs.getString(9));
                danhSach.add(new NhanVien(rs.getString(1),
                        rs.getString(2),
                        LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-M-d")),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        taiKhoan.getTenDangNhap(),
                        rs.getInt(8),
                        caLamViec.getMaCa(),
                        ChucVu.valueOf(rs.getString(10))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public ArrayList<NhanVien> locNhanVienTheoChucVu(String duLieuTim) {
        ArrayList<NhanVien> danhSach = new ArrayList<NhanVien>();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select maNhanVien, hoTenNV, ngaySinh, soDienThoaiNV, gioiTinh,\n"
                    + "email, TaiKhoan, tinhTrangLamViec, CaLamViec, chucVu\n"
                    + "from NhanVien\n"
                    + "where chucVu like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, duLieuTim);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(7));
                CaLamViec caLamViec = new CaLamViec(rs.getString(9));
                danhSach.add(new NhanVien(rs.getString(1),
                        rs.getString(2),
                        LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-M-d")),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        taiKhoan.getTenDangNhap(),
                        rs.getInt(8),
                        caLamViec.getMaCa(),
                        ChucVu.valueOf(rs.getString(10))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public String getMaNhanVienQLDB() {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        String tmp = "";
        try {
            String sql = "SELECT top 1 maNhanVien\n"
                    + "FROM NhanVien\n"
                    + "WHERE maNhanVien like 'QL%'\n"
                    + "ORDER BY CONVERT(DATE, RIGHT(LEFT(maNhanVien, 8), 4) + SUBSTRING(maNhanVien, 5, 2) \n"
                    + "+ RIGHT(maNhanVien, 2), 112) DESC, CAST(SUBSTRING(maNhanVien, 11, LEN(maNhanVien)) AS INT) \n"
                    + "DESC";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tmp = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }
    
    public String getMaNhanVienTNDB() {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        String tmp = "";
        try {
            String sql = "SELECT top 1 maNhanVien\n"
                    + "FROM NhanVien\n"
                    + "WHERE maNhanVien like 'TN%'\n"
                    + "ORDER BY CONVERT(DATE, RIGHT(LEFT(maNhanVien, 8), 4) + SUBSTRING(maNhanVien, 5, 2) \n"
                    + "+ RIGHT(maNhanVien, 2), 112) DESC, CAST(SUBSTRING(maNhanVien, 11, LEN(maNhanVien)) AS INT) \n"
                    + "DESC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tmp = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }
    
    public String getNhanVienTheoCa(String email){
        String caLv = "";
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        String tmp = "";
        try {
            String sql =    "select caLamViec from NhanVien\n" +
                            "where email like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                caLv = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caLv;
    }
}
