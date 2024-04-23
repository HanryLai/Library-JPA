package testPackage.implement;

import dao.impl.Sach_Impl;
import entityJPA.Sach;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

public class SachAndVPP_Test_Implement {
    public static void main(String[] args) throws RemoteException {
        Sach_Impl sach_impl = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
////        getAlltbSach
//        System.out.println(sach_impl.getAlltbSach());
//
////        createSach
//        Sach sach = new Sach();
//        sach.setTenSanPham("Sach 1");
//        sach.setTacGia("Tac gia 1");
//        sach.setDonGiaBan(10000);
//
//        sach_impl.createSach(sach);

//        getSachtheoMa
//        System.out.println(sach_impl.getSachtheoMa("99"));

//        updateSach
//        1. Id sach != null (!= 0)-> cập nhập theo sach
//        2. Id sach == null (0)-> Tạo mới sach
        Sach sach = new Sach();
        sach.setMaSanPham(2);
        sach.setTenSanPham("Sách gì mà đắt ắ ộ vãi");
        System.out.println(sach.getTenSanPham());

//
        sach_impl.updateSach(sach);


// PASS
    }
}
