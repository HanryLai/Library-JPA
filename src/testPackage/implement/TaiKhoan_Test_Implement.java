package testPackage.implement;

import dao.impl.TaiKhoan_Impl;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

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

        // Get ten nguoi dung

        // Doi mat khau
        taiKhoanDao.doiMatKhau("nguyentanloc1108@gmail.com", "123456");
    }
}
