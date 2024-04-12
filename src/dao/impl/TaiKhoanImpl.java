package dao.impl;

import javax.swing.JOptionPane;

import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;
import gui.FrmChinh;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import utils.GenericImpl;

public class TaiKhoanImpl extends GenericImpl<TaiKhoan> implements TaiKhoanDao{
	private EntityManager em = Persistence
			.createEntityManagerFactory("NguyenTanLoc_21059391")
			.createEntityManager();

	public TaiKhoanImpl(Class<TaiKhoan> entityClass) {
		super(entityClass);
		
	}
	public boolean xacThucNguoiDung(String tenDangNhap, String matKhau) {
		try {
			String query = "SELECT * FROM TaiKhoan WHERE email = :email";
			TaiKhoan taiKhoan = em.createQuery(query, TaiKhoan.class)
					.setParameter("email", tenDangNhap)
					.getSingleResult();
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
	
	public String phanQuyen(String email) {
	    String tenDN = "";
	    try {
	        String query = "SELECT tenDangNhap FROM TaiKhoan WHERE email = :email";
	        String tenDangNhap = em.createQuery(query, String.class)
				        		.setParameter("email", email)
				        		.getSingleResult();
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
