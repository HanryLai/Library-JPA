package testPackage.data;

import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

public class Main_Create_Data {
    public static void main(String[] args) throws RemoteException {
//        CREATE DATA (Change persistence to create-drop)

//        PLEASE CHANGE PERSISTENCE UNIT TO create-drop

        EntityManagerFactory_Static.resetEntityManagerFactory();

        System.out.println("--------------------CREATE DATA--------------------");

        SanPham_BaoCao_ChiTiet.main(args);
        System.out.println("--------------------CREATE DATA--------------------");

        TaiKhoan_NhanVien_KhachHang.main(args);
        System.out.println("--------------------CREATE DATA--------------------");

        HoaDon_ChiTietHoaDon.main(args);
        System.out.println("--------------------CREATE DATA--------------------");

//        DO NOT CLOSE EntityManagerFactory


//
    }
}
