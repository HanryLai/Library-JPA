package testPackage.data;

import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

public class Main_Create_Data {
    public static void main(String[] args) throws Exception {
//        CREATE DATA (Change persistence to create-drop)

//        PLEASE CHANGE PERSISTENCE UNIT TO create-drop

        EntityManagerFactory_Static.resetEntityManagerFactory();

        System.out.println("--------------------CREATE DATA--------------------");

        NhaCungCap_Dao.main(args);
        System.out.println("--------------------CREATE DATA--------------------");

        SanPham_BaoCao_ChiTiet.main(args);
        System.out.println("--------------------CREATE DATA--------------------");

        TaiKhoan_NhanVien_KhachHang.main(args);
        System.out.println("--------------------CREATE DATA--------------------");

//        HoaDon_ChiTietHoaDon.main(args);
//        System.out.println("--------------------CREATE DATA--------------------");
//
//
//        ChiTietHoaDonDoi_Data.main(args);
//        System.out.println("--------------------CREATE DATA--------------------");
//
//
//        HoaDonHoanTra_ChiTietHoanTra.main(args);
//        System.out.println("--------------------CREATE DATA--------------------");

//        EntityManagerFactory_Static.closeEntityManagerFactory();

//        DO NOT CLOSE EntityManagerFactory


//
    }
}
