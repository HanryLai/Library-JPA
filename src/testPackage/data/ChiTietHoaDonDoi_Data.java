package testPackage.data;

import dao.impl.ChiTietHoaDonDoi_Impl;
import dao.impl.HoaDonDoiHang_Impl;
import dao.impl.Sach_Impl;
import entityJPA.ChiTietHoaDonDoi;
import entityJPA.HoaDonDoiHang;
import entityJPA.SanPham;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

public class ChiTietHoaDonDoi_Data {
    public static void main(String[] args) throws Exception {

        // thay mấy thằng hoaDonDoiHang và sanPham tùy theo mã database
        ChiTietHoaDonDoi_Impl dao = new ChiTietHoaDonDoi_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonDoiHang_Impl hoaDonDoiHang_dao = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonDoiHang hoaDonDoiHang = hoaDonDoiHang_dao.getHoaDonDoiHangtheoMa("1");
        Sach_Impl sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        SanPham sanPham = sach_dao.getSachtheoMa("2");
        ChiTietHoaDonDoi cthd = new ChiTietHoaDonDoi(hoaDonDoiHang, sanPham, 1, 100);
        System.out.println(dao.createChiTietDonDoi(cthd));

    }
}
