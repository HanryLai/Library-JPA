package dao.impl;

import dao.Interface.ChiTietHoaDon_Dao;
import dao.Interface.HoaDon_Dao;
import dao.Interface.Sach_Dao;
import entityJPA.ChiTietHoaDon;
import entityJPA.HoaDon;
import entityJPA.Sach;
import entityJPA.SanPham;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChiTietHoaDon_Impl extends UnicastRemoteObject implements ChiTietHoaDon_Dao {

    private final EntityManagerFactory emf;
    public ChiTietHoaDon_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    @Override
    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() throws RemoteException {
        Generic_Impl<ChiTietHoaDon> gen = new Generic_Impl<>(ChiTietHoaDon.class, emf);
        return (ArrayList<ChiTietHoaDon>) gen.findAll();
    }


    @Override
    public boolean createChiTietHoaDon(ChiTietHoaDon cthd) throws RemoteException {
        Generic_Impl<ChiTietHoaDon> gen = new Generic_Impl<>(ChiTietHoaDon.class, emf);
        return gen.save(cthd);
    }

    @Override
    public void deleteChiTietHoaDonVaSanPham(String maHD, String maSP) throws RemoteException {

    }

    @Override
    public void deleteChiTietHoaDon(String maHD) throws RemoteException {

    }

    @Override
    public ChiTietHoaDon getCTHoaDontheoMa(String ma1, String ma2) throws RemoteException {
        return null;
    }

    @Override
    public boolean updateCTHoaDon(ChiTietHoaDon cthd) throws RemoteException {
        return false;
    }

    public static void main(String[] args) throws RemoteException {
        HoaDon_Dao dao_hd = new HoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDon_Dao cthd_dao = new ChiTietHoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        Sach_Dao sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDon hd = dao_hd.getHoaDontheoMa("3");
        SanPham sach = sach_dao.getSachtheoMa("2");
        System.out.println(sach);
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        cthd.setMaSanPham(sach);
        cthd.setMaHoaDon(hd);
        cthd.setSoLuong(5);

//        cthd_dao.createChiTietHoaDon(cthd);

//        public HoaDon(LocalDateTime ngayLap, String ghiChu, int tinhTrangHoaDon, float tongTien, float chietKhau, String khuyenMai)
        HoaDon newhd = new HoaDon(LocalDateTime.now(), "ghi chu", 1, 0, 0.1f, "Khong");
        System.out.println(dao_hd.createHoaDon(newhd));






    }
}
