package testPackage.data;

import dao.Interface.HoaDonDoiHang_Dao;
import dao.Interface.HoaDonHoanTra_Dao;
import dao.impl.ChiTietHoaDonDoi_Impl;
import dao.impl.HoaDonDoiHang_Impl;
import dao.impl.HoaDonHoanTra_Impl;
import dao.impl.Sach_Impl;

import entityJPA.ChiTietHoaDonDoi;
import entityJPA.HoaDonDoiHang;
import entityJPA.HoaDonHoanTra;
import entityJPA.SanPham;

import entityJPA.otherID.ChiTietHoaDonDoiID;
import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

public class ChiTietHoaDonDoi_Data {
    public static void main(String[] args) throws Exception {

        // thay mấy thằng hoaDonDoiHang và sanPham tùy theo mã database
        ChiTietHoaDonDoi_Impl dao = new ChiTietHoaDonDoi_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonDoiHang_Impl hoaDonDoiHang_dao = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());

        HoaDonDoiHang newHDDH = new HoaDonDoiHang();


        HoaDonHoanTra_Dao daoht = new HoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonDoiHang_Dao daodh = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonHoanTra     hdht  = daoht.getHoaDonHoanTratheoMa("1");

        HoaDonDoiHang hddh = new HoaDonDoiHang(hdht, "ghi chu", 50f, 0.1f, "khum");

        System.out.println(daodh.createHoaDonDoiHang(hddh));

        HoaDonDoiHang hoaDonDoiHang = hoaDonDoiHang_dao.getHoaDonDoiHangtheoMa("1");

        Sach_Impl sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());

        SanPham sanPham = sach_dao.getSachtheoMa("2");

        ChiTietHoaDonDoi cthd = new ChiTietHoaDonDoi();
        cthd.setId(new ChiTietHoaDonDoiID(1,1));
        cthd.setSoLuong(1);
        cthd.setThanhTien(1);

        System.out.println(dao.createChiTietDonDoi(cthd));

    }
}
