package dao.impl;

import dao.Interface.TaiKhoanDao;
import entityJPA.TaiKhoan;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

public class Main {
	public static void main(String[] args) throws RemoteException {
		TaiKhoanDao taiKhoanDao = new TaiKhoanImpl(EntityManagerFactory_Static.getEntityManagerFactory());
		TaiKhoan taiKhoan = new TaiKhoan("nguyentanloc1108@gmail.com","NTL@1108","example@gmail.com");


		System.out.println(taiKhoanDao.xacThucNguoiDung("example@gmail.com", "NTL@1108"));
		//taiKhoanDao.phanQuyen("example@gmail.com");


	}
}
