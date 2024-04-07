package Dao;


import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Entity.KhachHang;
import Entity.TaiKhoan;
import Gui.FrmChinh;

import java.util.Properties;
import java.util.Random;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

public class Dao_TaiKhoan {
	public static boolean xacThucNguoiDung(String tenDangNhap, String matKhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			String query = "SELECT * FROM TaiKhoan WHERE email = ?";
			state = con.prepareStatement(query);
			state.setString(1, tenDangNhap);
			resultSet = state.executeQuery();
			if (resultSet.next()) {
				String xacThucMatKhau = resultSet.getString("matkhau");
				if (xacThucMatKhau.equals(matKhau)) {

//	                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					// mở frm chính
					FrmChinh frmChinh = new FrmChinh();
					frmChinh.setVisible(true);
					return true;
				} else {
					// Mật khẩu sai
					JOptionPane.showMessageDialog(null, "Sai mật khẩu");
					return false;
				}
			} else {
				// Tên đăng nhập không tồn tại
				JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi SQL");
			return false;
		}
	}

	public String phanQuyen(String email) {
	    String tenDN = "";
	    Connection con = null;
	    PreparedStatement state = null;
	    ResultSet resultSet = null;
	    try {
	        con = ConnectDB.getConnection();
	        String query = "SELECT tenDangNhap FROM TaiKhoan WHERE email = ?";
	        state = con.prepareStatement(query);
	        state.setString(1, email);
	        resultSet = state.executeQuery();

	        if (resultSet.next()) {
	            tenDN = resultSet.getString("tenDangNhap");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Lỗi SQL");
	    } 
	    return tenDN;
	}
        
        public String getTenNguoiDung(String email) {
	    String tenND = "";
	    Connection con = null;
	    PreparedStatement state = null;
	    ResultSet resultSet = null;
	    try {
	        con = ConnectDB.getConnection();
	        String query = "SELECT hoTenNV FROM NhanVien WHERE email = ?";
	        state = con.prepareStatement(query);
	        state.setString(1, email);
	        resultSet = state.executeQuery();

	        if (resultSet.next()) {
	            tenND = resultSet.getString("hoTenNV");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Lỗi SQL");
	    } 
	    return tenND;
	}
        
        // Hàm lấy mã OTP xong qua bên frm so sánh với ô mã để làm sự kiện
	public int sendEmail(String email){
        final String from = "ttrandanghieu42@gmail.com";
        final String password = "tcth pwux kmfg aokb";
        
        
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        
        // create authenticator
        Authenticator auth;
        auth = new Authenticator() {
            @Override
            protected  PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from,password);
            }       
        };
        
        Session session = Session.getInstance(props, auth);
        
       final String to = email;
        MimeMessage msg = new MimeMessage(session);
        
        try {
            msg.addHeader("Content-type", "text/HTML;charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
            msg.setSubject("OTP quên mật khẩu hiệu sách ONEEIGHT");
            msg.setSentDate(new java.util.Date());
            Random generator = new Random();
            int OTP = 100000 + generator.nextInt(900000);
            msg.setText(String.valueOf(OTP),"UTF-8");
            
            Transport.send(msg);
            return OTP;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        
    }
	
	
	
	public void doiMatKhau(String email, String newPassword) {
		Connection connection = ConnectDB.getInstance().getConnection();
	    PreparedStatement preparedStatement = null;

	    try {
	    // Kiểm tra xem nhân viên có tồn tại trong cơ sở dữ liệu không
	    	String checkEmployeeQuery = "SELECT * FROM TaiKhoan WHERE email = ?";
	        preparedStatement = connection.prepareStatement(checkEmployeeQuery);
	        preparedStatement.setString(1, email);
	        if (!preparedStatement.executeQuery().next()) {
	        // Nhân viên không tồn tại
	        	JOptionPane.showMessageDialog(null, "Email Nhân viên không tồn tại.");
	        return;
	        }

	            // Cập nhật mật khẩu cho nhân viên
	            String updatePasswordQuery = "UPDATE TaiKhoan SET matkhau = ? WHERE email = ?";
	            preparedStatement = connection.prepareStatement(updatePasswordQuery);
	            preparedStatement.setString(1, newPassword);
	            preparedStatement.setString(2, email);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	               JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.");
	            } else {
	                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi đổi mật khẩu.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	public ArrayList<TaiKhoan> getAllTaiKhoan() {
        ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        try {
            String sql = "SELECT [tenDangNhap], [email], [matkhau] FROM [QuanLyHieuSachONEEIGHT].[dbo].[TaiKhoan]";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                String tenDangNhap = rs.getString(1);
                String matKhau = rs.getString(2);
                String email = rs.getString(3);

                TaiKhoan taiKhoan = new TaiKhoan(tenDangNhap, matKhau, email);
                dsTaiKhoan.add(taiKhoan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsTaiKhoan;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
