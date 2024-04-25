package testPackage.data;

import dao.Interface.*;
import dao.impl.*;
import entityJPA.ChiTietHoanTra;
import entityJPA.HoaDon;
import entityJPA.HoaDonHoanTra;
import entityJPA.SanPham;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HoaDonHoanTra_ChiTietHoanTra {
    public static void main(String[] args) throws RemoteException {
        HoaDonHoanTra_Dao daoht = new HoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        Sach_Dao sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        VanPhongPham_Dao vvp_dao = new VanPhongPham_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDonHoanTra_Dao daoctht = new ChiTietHoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDon_Dao daohd= new HoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());


        HoaDon hd = daohd.getHoaDontheoMa("1");

        HoaDonHoanTra hdht = new HoaDonHoanTra(LocalDate.now(), hd, "ghi chu", 1, 100d);
        System.out.println(daoht.createHoaDonHoanTra(hdht));

        SanPham sach = sach_dao.getSachtheoMa("2");
        SanPham vvp = vvp_dao.getVPPtheoMa("1");
        ChiTietHoanTra ctht1 = new ChiTietHoanTra(hdht, sach, 5, 50f);
        ChiTietHoanTra ctht2 = new ChiTietHoanTra(hdht, vvp, 5, 50f);

        System.out.println(daoctht.createChiTietHoanTra(ctht1));
        System.out.println(daoctht.createChiTietHoanTra(ctht2));
    }

}
