package testPackage.implement;

import dao.impl.KhachHang_Impl;
import entityJPA.KhachHang;
import untils.entityManagerFactory.EntityManagerFactory_Static;

public class KhachHang_Test_Implement {
    public static void main(String[] args) throws Exception {
        KhachHang_Impl khachHangDao = new KhachHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        // Get all customers
        System.out.println("Get all customers: ");
        for (KhachHang khachHang : khachHangDao.getAllKhachHang()) {
            System.out.println(khachHang);
        }
        // Get customer by ID
        System.out.println("Get customer by ID: ");
        System.out.println(khachHangDao.getKHTheoMa(1));
        // Get customer by phone number
        System.out.println("Get customer by phone number: ");
        //System.out.println(khachHangDao.getKHTheoSDT("0123456789"));
        // Loc du lieu khach hang
        System.out.println("Loc du lieu khach hang: ");
        for (KhachHang khachHang : khachHangDao.locDuLieuKhachHang("Nguyễn Van A")) {
            System.out.println(khachHang);
        }
    }
}
