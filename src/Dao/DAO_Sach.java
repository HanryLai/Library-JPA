/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connectDB.ConnectDB;
import Entity.MauSac;
import Entity.NhaCungCap;
import Entity.NhomSanPham;
import Entity.Sach;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nguyen chau tai
 */
public class DAO_Sach {

    public DAO_Sach() {

    }

    public ArrayList<Sach> getAlltbSach() {
        ArrayList<Sach> dsSach = new ArrayList<Sach>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from Sach";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String maSanPham = rs.getString(1);
                String tenSanPham = rs.getString(2);
                NhomSanPham nhomSanPham = new NhomSanPham(rs.getString("nhomSanPham"));
                NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("nhaCungCap"));
                int soluongton = rs.getInt(5);
                double donGiaNhap = rs.getDouble(6);
                String moTa = rs.getString(7);
                String tinhTrang = rs.getString(8);
                double donGiaBan = rs.getDouble(9);
                double VAT = rs.getDouble(10);
                String tacGia = rs.getString(11);
                int namXuatBan = rs.getInt(12);
                String nhaXuatBan = rs.getString(13);
                int soTrang = rs.getInt(14);
                Timestamp time = rs.getTimestamp(15);
                LocalDateTime ngayTao = time.toLocalDateTime();
                double giamGia = rs.getDouble(16);

                Sach s = new Sach(maSanPham, tenSanPham, nhomSanPham, nhaCungCap, soluongton, donGiaNhap, moTa,
                        tinhTrang, donGiaBan, VAT, ngayTao, giamGia, tacGia, namXuatBan, nhaXuatBan, soTrang);

                dsSach.add(s);

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsSach;
    }

    public void createSach(Sach s) {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            String sql = "insert into Sach values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            state = con.prepareStatement(sql);
            state.setString(1, s.getMaSanPham());
            state.setString(2, s.getTenSanPham());
            state.setString(3, s.getNhomSanPham().getMaNhomSanPham());
            state.setString(4, s.getNhaCungCap().getMaNCC());
            state.setInt(5, s.getSoLuongTon());
            state.setDouble(6, s.getDonGiaNhap());
            state.setString(7, s.getMoTa());
            state.setString(8, s.getTinhTrang());
            state.setDouble(9, s.getDonGiaBan());
            state.setDouble(10, s.getVAT());
            state.setString(11, s.getTacGia());
            state.setInt(12, s.getNamXuatBan());
            state.setString(13, s.getNhaXuatBan());
            state.setInt(14, s.getSoTrang());
            state.setTimestamp(15, Timestamp.valueOf(s.getNgayTao()));
            state.setDouble(16, s.getGiamGia());
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

//    public void readExceIntoSQL(String maSanPham, String tenSanPham, String nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon,
//			double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double vAT, LocalDateTime ngayTao,
//			double giamGia, String tacGia, int namXuatBan, String nhaXuatBan, int soTrang) {
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement state = null;
//        try {
//            con.setAutoCommit(false);
//            String sql = "INSERT INTO Sach(maSanPham,tenSanPham,nhomSanPham,nhaCungCap,soLuongTon,donGiaNhap,moTa,"
//                    + "tinhTrang,donGiaBan,VAT,tacGia,namXuatBan,nhaSanXuat,soTrang,ngayTao,giamGia)";
//            state = con.prepareStatement(sql);
//
//            state.setString(1, maSanPham);
//            state.setString(2, tenSanPham);
//            state.setString(2, nhomSanPham);
//            
//
//        } catch (Exception e) {
//        }
//    }
//    public void importExcel(String fileName) throws Exception {
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement state = null;
//        String sql = "INSERT INTO Sach(maSanPham,tenSanPham,nhomSanPham,nhaCungCap,soLuongTon,donGiaNhap,moTa,"
//                + "tinhTrang,donGiaBan,VAT,tacGia,namXuatBan,nhaSanXuat,soTrang,ngayTao,giamGia)";
//
//        state = con.prepareStatement(sql);
//
//        FileInputStream input_document = new FileInputStream(new File(fileName));
//        HSSFWorkbook workbook = new HSSFWorkbook(input_document);
//        /* Load worksheet */
//        HSSFSheet worksheet = workbook.getSheetAt(0);
//        // we loop through and insert data
//        Iterator<Row> rowIterator = worksheet.iterator();
//
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                switch(cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING: //handle string columns
//                        state.setString(1, cell.getStringCellValue());
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC: //handle double data
//                        state.setDouble(2, cell.getNumericCellValue());
//                        break;
//                }
//
//            }
//            //we can execute the statement before reading the next row
//            state.executeUpdate();
//        }
//        input_document.close();
//        /* Close prepared statement */
//        state.close();
//        /* COMMIT transaction */
//        con.commit();
//        /* Close connection */
//        con.close();
//    }
    public void importExcel(String fileName, String sheetName) throws Exception {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        Statement state = con.createStatement();
//        String sql = "INSERT INTO Sach(maSanPham,tenSanPham,nhomSanPham,nhaCungCap,soLuongTon,donGiaNhap,moTa,"
//                + "tinhTrang,donGiaBan,VAT,tacGia,namXuatBan,nhaSanXuat,soTrang,ngayTao,giamGia)";

        FileInputStream input = new FileInputStream(new File(fileName));

        XSSFWorkbook workBook = new XSSFWorkbook(input);
        XSSFSheet sheet = workBook.getSheet(sheetName);
        int rows = sheet.getLastRowNum();

        for (int r = 1; r <= rows; r++) {
//            XSSFRow row = sheet.getRow(r);
//            String maSanPham = row.getCell(0).getStringCellValue();
//            String tenSanPham = row.getCell(1).getStringCellValue();
//            String postalCode = row.getCell(2).getStringCellValue();
//            String city = row.getCell(3).getStringCellValue();
//            String stateProv = row.getCell(4).getStringCellValue();
//            String countryId = row.getCell(5).getStringCellValue();

            String sql = "INSERT INTO Sach(maSanPham,tenSanPham,nhomSanPham,nhaCungCap,soLuongTon,donGiaNhap,moTa,"
                    + "tinhTrang,donGiaBan,VAT,tacGia,namXuatBan,nhaSanXuat,soTrang,ngayTao,giamGia)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            state.execute(sql);
            state.execute("commit");
        }

        workBook.close();
        input.close();
        con.close();

        System.out.println("Done!!");
    }

    public Sach getSachtheoMa(String ma) {
        Sach s = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from Sach where maSanPham = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString(1);
                String tenSanPham = rs.getString(2);
                NhomSanPham nhomSanPham = new NhomSanPham(rs.getString("nhomSanPham"));
                NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("nhaCungCap"));
                int soluongton = rs.getInt(5);
                double donGiaNhap = rs.getDouble(6);
                String moTa = rs.getString(7);
                String tinhTrang = rs.getString(8);
                double donGiaBan = rs.getDouble(9);
                double VAT = rs.getDouble(10);
                String tacGia = rs.getString(11);
                int namXuatBan = rs.getInt(12);
                String nhaXuatBan = rs.getString(13);
                int soTrang = rs.getInt(14);
                Timestamp time = rs.getTimestamp(15);
                LocalDateTime ngayTao = time.toLocalDateTime();
                double giamGia = rs.getDouble(16);

                s = new Sach(maSanPham, tenSanPham, nhomSanPham, nhaCungCap, soluongton, donGiaNhap, moTa, tinhTrang,
                        donGiaBan, VAT, ngayTao, giamGia, tacGia, namXuatBan, nhaXuatBan, soTrang);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
        finally {
            try {
                state.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return s;
    }

    public boolean updateSach(Sach s) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        int n = 0;
        try {
            state = con.prepareStatement("update Sach set tenSanPham = ?, nhomSanPham = ?,"
                    + "tacGia = ?, soLuongTon = ?, " + "donGiaNhap = ?, moTa = ?, namXuatBan = ?"
                    + ", soTrang = ?, nhaSanXuat = ? , giamGia = ? where maSanPham = ?");

            state.setString(1, s.getTenSanPham());
            state.setString(2, s.getNhomSanPham().getMaNhomSanPham());
            state.setString(3, s.getTacGia());
            state.setInt(4, s.getSoLuongTon());
            state.setDouble(5, s.getDonGiaNhap());
            state.setString(6, s.getMoTa());
            state.setDouble(7, s.getNamXuatBan());
            state.setInt(8, s.getSoTrang());
            state.setString(9, s.getNhaXuatBan());
            state.setDouble(10, s.getGiamGia());
            state.setString(11, s.getMaSanPham());
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
}
