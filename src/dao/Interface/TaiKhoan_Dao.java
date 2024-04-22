package dao.Interface;

import java.rmi.Remote;

public interface TaiKhoan_Dao extends Remote {
	public boolean xacThucNguoiDung(String tenDangNhap, String matKhau);
	public String phanQuyen(String email);
	public String getTenNguoiDung(String email);
	public void doiMatKhau(String email, String newPassword);




}
