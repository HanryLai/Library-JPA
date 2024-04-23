package dao.impl;


import dao.Interface.TaiKhoan_Dao;

import entityJPA.TaiKhoan;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws RemoteException {

		NhomSanPham_Impl nhomSanPham_impl = new NhomSanPham_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
		System.out.println(nhomSanPham_impl.getNspTheoMa("123"));

	}
}
