package testPackage.implement;

import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

import dao.impl.TaiKhoan_Impl;

public class TaiKhoan_Test_Implement {
    public static void main(String[] args) throws RemoteException {
        TaiKhoan_Impl taiKhoanDao = new TaiKhoan_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        // Xac thuc nguoi dung
        if(taiKhoanDao.xacThucNguoiDung("nguyentanloc1108", "1234")){
            System.out.println("Đăng nhập thành công");
        } else {
            System.out.println("Đăng nhập thất bại");
        }
        // Phan quyen
        if(taiKhoanDao.phanQuyen("nguyentanloc1108@gmail.com").equalsIgnoreCase("QUANLY")){
            System.out.println("Đang truy cập quyền quản lý");
        }else{
            System.out.println("Đang truy cập quyền nhân viên");
        }
        // Get ten nguoi dung
        System.out.println("Tên người dùng: "+taiKhoanDao.getTenNguoiDung("nguyentanloc1108@gmail.com"));
        // Doi mat khau
        taiKhoanDao.doiMatKhau("nguyentanloc1108@gmail.com", "123456");
        // Send OTP
        System.out.println("OTP: "+taiKhoanDao.sendEmail("nguyentanloc1108@gmail.com"));
    }
}
