package dao.Interface;

import entityJPA.TaiKhoan;

public interface TaiKhoanDao extends GenericDao<TaiKhoan>{
	public boolean xacThucNguoiDung(String tenDangNhap, String matKhau);
	public String phanQuyen(String email);
	public String getTenNguoiDung(String email);
	public void doiMatKhau(String email, String newPassword);




}
