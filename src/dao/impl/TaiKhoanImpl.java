package dao.impl;

import javax.swing.JOptionPane;

import dao.TaiKhoanDao;
import entityJPA.NhanVien;
import entityJPA.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import utils.GenericImpl;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

public class TaiKhoanImpl extends GenericImpl<TaiKhoan> implements TaiKhoanDao{
	private EntityManager em = Persistence
			.createEntityManagerFactory("jpa-mssql")
			.createEntityManager();

	public TaiKhoanImpl(Class<TaiKhoan> entityClass) {
		super(entityClass);
		
	}
	public boolean xacThucNguoiDung(String tenDangNhap, String matKhau) {
		try {
			String query = "SELECT t FROM TaiKhoan t WHERE email = :email";
			TaiKhoan taiKhoan = null;
			taiKhoan = em.createQuery(query, TaiKhoan.class)
					.setParameter("email", tenDangNhap)
					.getSingleResult();
			if (taiKhoan == null) {
				JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
				return false;
			}
			return true;
//			if (taiKhoan != null) {
//				String xacThucMatKhau = taiKhoan.getMatKhau();
//				if (xacThucMatKhau.equals(matKhau)) {
//					FrmChinh frmChinh = new FrmChinh();
//					frmChinh.setVisible(true);
//					return true;
//				} else {
//					JOptionPane.showMessageDialog(null, "Sai mật khẩu");
//					return false;
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
//				return false;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
			return false;
		}
	}
	
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
	
	public String phanQuyen(String email) {
	    String tenDN = "";
	    try {
	        String query = "SELECT tenDangNhap FROM TaiKhoan WHERE email = :email";
	        String tenDangNhap = em.createQuery(query, String.class)
				        		.setParameter("email", email)
				        		.getSingleResult();
	        System.out.println(tenDangNhap);
	        if (tenDangNhap != null) {
	        	tenDN = tenDangNhap;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error");
	    } 
	    return tenDN;
	}
	
	public String getTenNguoiDung(String email) {
	    String tenND = "";
	    try {
	        String query = "SELECT hoTenNV FROM NhanVien WHERE email = :email";
			String tenNguoiDung = em.createQuery(query, String.class)
									.setParameter("email", email)
									.getSingleResult();

	        if (tenNguoiDung != null) {
	            tenND = tenNguoiDung;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error");
	    } 
	    return tenND;
	}
	
	public void doiMatKhau(String email, String newPassword) {
	    try {
	    	String query = "SELECT * FROM TaiKhoan WHERE email = :email";
			NhanVien nhanVien = em.createQuery(query, NhanVien.class)
					.setParameter("email", email)
					.getSingleResult();
			if (nhanVien == null) {
				JOptionPane.showMessageDialog(null, "Email Nhân viên không tồn tại.");
			}
            String queryUpdatePwd = "UPDATE TaiKhoan SET matkhau = :matkhau WHERE email = :email";
            Query updatePwdQuery = em.createQuery(queryUpdatePwd);
            updatePwdQuery.setParameter("matkhau", newPassword);
            updatePwdQuery.setParameter("email", email);

            int rowsAffected = updatePwdQuery.executeUpdate();

            if (rowsAffected > 0) {
               JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.");
            } else {
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi đổi mật khẩu.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
