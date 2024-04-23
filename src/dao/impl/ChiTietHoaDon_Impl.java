package dao.impl;

import dao.Interface.ChiTietHoaDon_Dao;
import dao.Interface.HoaDon_Dao;
import dao.Interface.Sach_Dao;
import dao.Interface.VanPhongPham_Dao;
import entityJPA.*;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDon_Impl extends UnicastRemoteObject implements ChiTietHoaDon_Dao {

    private final EntityManagerFactory emf;
    public ChiTietHoaDon_Impl(EntityManagerFactory emf) throws RemoteException {
        this.emf = emf;
    }

    @Override
    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() throws RemoteException {
        GenericImpl<ChiTietHoaDon> gen = new GenericImpl<>(ChiTietHoaDon.class, emf);
        return (ArrayList<ChiTietHoaDon>) gen.findAll();
    }

    @Override
    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDonByMaHD(String maHD) throws RemoteException {
        GenericImpl<ChiTietHoaDon> gen = new GenericImpl<>(ChiTietHoaDon.class, emf);
        GenericImpl<HoaDon> genhd = new GenericImpl<>(HoaDon.class, emf);

        HoaDon hd = genhd.findById(Integer.parseInt(maHD));

        return (ArrayList<ChiTietHoaDon>) gen.findByProperty("maHoaDon", hd);
    }


    @Override
    public boolean createChiTietHoaDon(ChiTietHoaDon cthd) throws RemoteException {
        GenericImpl<ChiTietHoaDon> gen = new GenericImpl<>(ChiTietHoaDon.class, emf);
        return gen.save(cthd);
    }

    @Override
    public boolean deleteChiTietHoaDonVaSanPham(String maHD, String maSP) throws RemoteException {
        GenericImpl<ChiTietHoaDon> gen = new GenericImpl<>(ChiTietHoaDon.class, emf);
        ChiTietHoaDonID id = new ChiTietHoaDonID(Integer.parseInt(maHD), Integer.parseInt(maSP));
        return gen.delete(id);
    }

    @Override
    public boolean deleteChiTietHoaDon(String maHD) throws RemoteException {
        try {
            List<ChiTietHoaDon> ls = this.getAllChiTietHoaDonByMaHD(maHD);
            GenericImpl<ChiTietHoaDon> gen = new GenericImpl<>(ChiTietHoaDon.class, emf);
            for (ChiTietHoaDon cthd : ls) {
                gen.delete(cthd.getId());
            }
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ChiTietHoaDon getCTHoaDontheoMa(String ma1, String ma2) throws RemoteException {

        GenericImpl<ChiTietHoaDon> gen = new GenericImpl<>(ChiTietHoaDon.class, emf);
        ChiTietHoaDonID id = new ChiTietHoaDonID(Integer.parseInt(ma1), Integer.parseInt(ma2));
        return gen.findById(id);
    }

//    @Override
//    public boolean updateCTHoaDon(ChiTietHoaDon cthd) throws RemoteException {
//        return false;
//    }

    public static void main(String[] args) throws RemoteException {
        HoaDon_Dao dao_hd = new HoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDon_Dao cthd_dao = new ChiTietHoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        Sach_Dao sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        VanPhongPham_Dao vpp_dao = new VanPhongPham_Impl(EntityManagerFactory_Static.getEntityManagerFactory());

        HoaDon hd = dao_hd.getHoaDontheoMa("4");
        SanPham sach = sach_dao.getSachtheoMa("2");
        System.out.println(sach);
//        ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sach, 5, 100);

        SanPham vvp = new VanPhongPham();
        vvp = vpp_dao.getVPPtheoMa("1");

        ChiTietHoaDon cthd1 = new ChiTietHoaDon(hd, vvp, 5, 100);
        ChiTietHoaDon cthd2 = new ChiTietHoaDon(hd, sach, 10, 500);

        cthd_dao.createChiTietHoaDon(cthd1);
//        cthd_dao.createChiTietHoaDon(cthd2);

//        System.out.println(cthd_dao.deleteChiTietHoaDonVaSanPham("3", "1"));
//        System.out.println(cthd_dao.deleteChiTietHoaDon("3"));
//        System.out.println(cthd_dao.getAllChiTietHoaDonByMaHD("3"));
//        System.out.println(cthd_dao.deleteChiTietHoaDon("3"));
        System.out.println(cthd_dao.getCTHoaDontheoMa("4", "1"));

//        public HoaDon(LocalDateTime ngayLap, String ghiChu, int tinhTrangHoaDon, float tongTien, float chietKhau, String khuyenMai)
//        HoaDon newhd = new HoaDon(LocalDateTime.now(), "ghi chu", 1, 0, 0.1f, "Khong");
//        System.out.println(dao_hd.createHoaDon(newhd));






    }
}
