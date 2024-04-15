package dao.impl;

import dao.Interface.TaiKhoanDao;
import entityJPA.TaiKhoan;

public class Main {
	public static void main(String[] args) {
		TaiKhoanDao taiKhoanDao = new TaiKhoanImpl(TaiKhoan.class);
		TaiKhoan taiKhoan = new TaiKhoan("nguyentanloc1108", "NTL@1108", "example@gmail.com");
		taiKhoanDao.save(taiKhoan);
		System.out.println(taiKhoanDao.xacThucNguoiDung("example@gmail.com", "NTL@1108"));
		//taiKhoanDao.phanQuyen("example@gmail.com");
	}
}
