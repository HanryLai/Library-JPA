package dao.impl;

import javax.swing.JOptionPane;

import dao.Interface.TaiKhoan_Dao;
import entityJPA.NhanVien;
import entityJPA.TaiKhoan;
import gui.FrmChinh;
import jakarta.persistence.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

public class TaiKhoan_Impl extends UnicastRemoteObject implements TaiKhoan_Dao {
	private EntityManagerFactory emf;

	private Generic_Impl<TaiKhoan> generic;

	public TaiKhoan_Impl(EntityManagerFactory emf) throws RemoteException {
		this.emf = emf;
	}

	public boolean xacThucNguoiDung(String tenDangNhap, String matKhau) throws RemoteException{
		try {
			String   query    = "SELECT c FROM TaiKhoan c WHERE tenDangNhap = :tenDangNhap";
			TaiKhoan taiKhoan = null;
			EntityManager em = emf.createEntityManager();
			taiKhoan = em.createQuery(query, TaiKhoan.class)
					.setParameter("tenDangNhap", tenDangNhap)
					.getSingleResult();
			if (taiKhoan == null) {
				JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
				return false;
			}

			if (taiKhoan != null) {
				String xacThucMatKhau = taiKhoan.getMatKhau();
				if (xacThucMatKhau.equals(matKhau)) {
					FrmChinh frmChinh = new FrmChinh();
					frmChinh.setVisible(true);
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Sai mật khẩu");
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
			return false;
		}
	}

	public int sendEmail(String email) throws RemoteException{
		final String from     = "ttrandanghieu42@gmail.com";
		final String password = "tcth pwux kmfg aokb";


		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// create authenticator
		Authenticator auth;
		auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		final String to  = email;
		MimeMessage  msg = new MimeMessage(session);

		try {
			msg.addHeader("Content-type", "text/HTML;charset=UTF-8");
			msg.setFrom();
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject("OTP quên mật khẩu hiệu sách ONEEIGHT");
			msg.setSentDate(new java.util.Date());
			Random generator = new Random();
			int    OTP       = 100000 + generator.nextInt(900000);
			msg.setText(String.valueOf(OTP), "UTF-8");

			Transport.send(msg);
			return OTP;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public String phanQuyen(String email) throws RemoteException{
		String tenDN = "";
		try {
			String query = "SELECT tenDangNhap FROM TaiKhoan WHERE email = :email";
			EntityManager em = emf.createEntityManager();
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

	public String getTenNguoiDung(String email) throws RemoteException{
		String tenND = "";
		try {
			String query = "SELECT hoTenNV FROM NhanVien WHERE email = :email";
			EntityManager em = emf.createEntityManager();
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

	public void doiMatKhau(String email, String newPassword) throws RemoteException{
		try {
			String query = "SELECT c FROM TaiKhoan c WHERE email = :email";
			EntityManager em = emf.createEntityManager();
			TaiKhoan taiKhoan = em.createQuery(query, TaiKhoan.class)
					.setParameter("email", email)
					.getSingleResult();
			if (taiKhoan == null) {
				JOptionPane.showMessageDialog(null, "Email nhân viên không tồn tại.");
			}
			em.getTransaction().begin();
			String queryUpdatePwd = "UPDATE TaiKhoan SET matkhau = :matkhau WHERE email = :email ";
			Query  updatePwdQuery = em.createNativeQuery(queryUpdatePwd);
			updatePwdQuery.setParameter("matkhau", newPassword);
			updatePwdQuery.setParameter("email", email);

			int rowsAffected = updatePwdQuery.executeUpdate();

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.");
			} else {
				JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi đổi mật khẩu.");
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TaiKhoan> getALLTaiKhoan() throws RemoteException {
		List<TaiKhoan> list = null;
		try{
			Generic_Impl<TaiKhoan> generic = new Generic_Impl<>(TaiKhoan.class, emf);
			list = generic.findAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}


}
