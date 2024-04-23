package dao.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TaiKhoan_Dao extends Remote {
	public boolean xacThucNguoiDung(String tenDangNhap, String matKhau) throws RemoteException;
	public String phanQuyen(String email) throws RemoteException;
	public String getTenNguoiDung(String email) throws RemoteException;
	public void doiMatKhau(String email, String newPassword) throws RemoteException;




}
