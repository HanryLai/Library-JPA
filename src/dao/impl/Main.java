package dao.impl;

import dao.Interface.TaiKhoanDao;
import entityJPA.TaiKhoan;

import java.rmi.RemoteException;

public class Main {
	public static void main(String[] args) throws RemoteException {
		TaiKhoanDao taiKhoanDao = new TaiKhoanImpl(TaiKhoan.class);
		TaiKhoan taiKhoan = new TaiKhoan("nguyentanloc1108@gmail.com","NTL@1108","example@gmail.com");

		taiKhoanDao.save(taiKhoan);

		System.out.println(taiKhoanDao.xacThucNguoiDung("example@gmail.com", "NTL@1108"));
		//taiKhoanDao.phanQuyen("example@gmail.com");


	}
}
