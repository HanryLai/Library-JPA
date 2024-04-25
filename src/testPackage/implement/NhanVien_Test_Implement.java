package testPackage.implement;

import entityJPA.NhanVien;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

import dao.impl.NhanVien_Impl;

public class NhanVien_Test_Implement {
    public static void main(String[] args) throws RemoteException {
        NhanVien_Impl nhanVienDao = new NhanVien_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        // Get all NhanVien
        System.out.println("All NhanVien:");
        for (NhanVien nhanVien : nhanVienDao.getAllNhanVien()) {
            System.out.println(nhanVien);
        }
        // Get NhanVien theo ca
        System.out.println("Nhan vien theo ca:");
        for (NhanVien nhanVien : nhanVienDao.getAllNhanVienTheoCa(1)) {
            System.out.println(nhanVien);
        }
        // Get NhanVien theo ma
        System.out.println("Nhan vien theo ma:");
        System.out.println(nhanVienDao.getNVTheoMa(1));
        // Loc NhanVien
        System.out.println("Loc NhanVien:");
        for (NhanVien nhanVien : nhanVienDao.locNhanVien("01234")) {
            System.out.println(nhanVien);
        }
        // Loc NhanVien theo chuc vu
        System.out.println("Loc NhanVien theo chuc vu:");
        for (NhanVien nhanVien : nhanVienDao.locNhanVienTheoChucVu("QUANLY")) {
            System.out.println(nhanVien);
        }
        // Get CaLamViec theo NhanVien
        System.out.println("Ca lam viec theo nhan vien:");
        System.out.println("MaCa: "+nhanVienDao.getCaLamViecTheoNhanVien("nguyentanloc1108@gmail.com"));
    }
}
