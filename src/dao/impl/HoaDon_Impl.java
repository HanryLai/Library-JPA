package dao.impl;

import dao.Interface.HoaDon_Dao;
import entityJPA.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HoaDon_Impl extends UnicastRemoteObject implements HoaDon_Dao {

    private final EntityManagerFactory emf;
    public HoaDon_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    @Override
    public ArrayList<HoaDon> getAllHoaDon() throws RemoteException {
        Generic_Impl<HoaDon> hdGeneric = new Generic_Impl<>(HoaDon.class, emf);
        return (ArrayList<HoaDon>) hdGeneric.findAll();
    }

    @Override
    public boolean createHoaDon(HoaDon hd) throws RemoteException {
        Generic_Impl<HoaDon> hdGeneric = new Generic_Impl<>(HoaDon.class, emf);
        return hdGeneric.save(hd);
    }

    @Override
    public boolean updateHoaDon(HoaDon hd) throws RemoteException {
        Generic_Impl<HoaDon> hdGeneric = new Generic_Impl<>(HoaDon.class, emf);
        return hdGeneric.update(hd);
    }

    @Override
    public HoaDon getHoaDontheoMa(String ma) throws RemoteException {
        Generic_Impl<HoaDon> hdGeneric = new Generic_Impl<>(HoaDon.class, emf);
        return hdGeneric.findById(ma);
    }

    @Override
    public boolean deleteHoaDon(String maHD) throws RemoteException{
        return false;
    }

    @Override
    public List<String> getMaHoaDonTheoNgay(String ngayLapHD) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        String query = "select maHoaDon  from HoaDon\n" +
                "where CONVERT(date, ngayLap) = ?";
        List<?> ls = em.createNativeQuery(query)
                .setParameter(1, ngayLapHD)
                .getResultList();
        List<String> lsID = new ArrayList<>();
        ls.stream().forEach(x -> {
                int id = (int) x;
                lsID.add(x.toString());
        });

        em.close();


        return lsID;

    }

    public static void main(String[] args) throws RemoteException {
        HoaDon_Dao dao = new HoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        System.out.println(dao.getMaHoaDonTheoNgay("2023-02-01"));

//        HoaDon hd = dao.getHoaDontheoMa("5");
//        System.out.println(hd);

//        public HoaDon(LocalDateTime ngayLap, String ghiChu, int tinhTrangHoaDon, float tongTien, float chietKhau, String khuyenMai)
//        HoaDon newhd = new HoaDon(LocalDateTime.now(), "ghi chu", 1, 0, 0.1f, "Khong");
//        System.out.println(dao.createHoaDon(newhd));

//        HoaDon hd = dao.getHoaDontheoMa("5");
//        hd.setTongTien(10000f);
//        System.out.println(dao.updateHoaDon(hd));

        System.out.println(dao.getAllHoaDon());
    }

}
