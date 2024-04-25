package dao.Interface;

import entityJPA.TaiKhoan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaiKhoan_Dao extends Remote {
	public boolean xacThucNguoiDung(String tenDangNhap, String matKhau) throws RemoteException;
	public String phanQuyen(String email) throws RemoteException;
	public String getTenNguoiDung(String email) throws RemoteException;
	public void doiMatKhau(String email, String newPassword) throws RemoteException;
	public List<TaiKhoan> getALLTaiKhoan() throws RemoteException;
	public int sendEmail(String email) throws RemoteException;
	public boolean createTaiKhoan(TaiKhoan tk) throws RemoteException;



}
