package dao.impl;

import dao.Interface.ChiTietHoaDonDoi_Dao;
import dao.Interface.HoaDonHoanTra_Dao;
import dao.Interface.HoaDon_Dao;
import entityJPA.ChiTietHoaDonDoi;
import entityJPA.HoaDonDoiHang;
import entityJPA.Sach;
import entityJPA.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChiTietHoaDonDoi_Impl extends UnicastRemoteObject implements ChiTietHoaDonDoi_Dao {
    private final EntityManagerFactory emf;
    public ChiTietHoaDonDoi_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    @Override
    public ArrayList<ChiTietHoaDonDoi> getAllChiTietDonDoi() throws Exception {
        Generic_Impl<entityJPA.ChiTietHoaDonDoi> generic = new Generic_Impl<>(entityJPA.ChiTietHoaDonDoi.class, emf);
        ArrayList<ChiTietHoaDonDoi> list = new ArrayList<>();
        for (entityJPA.ChiTietHoaDonDoi cthd : generic.findAll()) {
            list.add(new ChiTietHoaDonDoi(cthd.getHoaDonDoiHang(),cthd.getSanPham(),cthd.getSoLuong(),cthd.getThanhTien()));
        }
        return list;
    }

    @Override
    public boolean createChiTietDonDoi(ChiTietHoaDonDoi cthd) throws Exception {
        try {
//            Generic_Impl<entityJPA.ChiTietHoaDonDoi> generic = new Generic_Impl<>(entityJPA.ChiTietHoaDonDoi.class, emf);
//            entityJPA.ChiTietHoaDonDoi cthd1 = new entityJPA.ChiTietHoaDonDoi();
//            cthd1.setHoaDonDoiHang(cthd.getHoaDonDoiHang());
//            cthd1.setSanPham(cthd.getSanPham());
//            cthd1.setSoLuong(cthd.getSoLuong());
//            cthd1.setThanhTien(cthd.getThanhTien());
//            generic.save(cthd1);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mssql");
            EntityManager em = emf.createEntityManager();

            String query = "INSERT INTO ChiTietHoaDonDoi VALUES(?,?,?,?)";
            em.getTransaction().begin();
            em.createNativeQuery(query)
                    .setParameter(1, cthd.getHoaDonDoiHang().getMaHoaDonDoi())
                    .setParameter(2, cthd.getSanPham().getMaSanPham())
                    .setParameter(3, cthd.getSoLuong())
                    .setParameter(4, cthd.getThanhTien())
                    .executeUpdate();
            em.getTransaction().commit();
            em.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void deleteChiTietDonDoi(String maHD) throws Exception {
       try {
           EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mssql");
           EntityManager em = emf.createEntityManager();
           String query = "DELETE FROM ChiTietHoaDonDoi WHERE maHoaDonDoi = ?1";
           em.getTransaction().begin();
           em.createNativeQuery(query)
                   .setParameter(1, maHD)
                   .executeUpdate();
           em.getTransaction().commit();
           em.close();
       } catch (Exception e) {
           e.printStackTrace();
       }

    }

    @Override
    public ChiTietHoaDonDoi getHoaDontheoMa(String ma1, String ma2) throws Exception {
        String query= "select c.maHoaDonDoi , c.maSanPham,c.soLuong,c.thanhTien  \n" +
                "              from ChiTietHoaDonDoi c \n" +
                "              where c.maHoaDonDoi like ?1 and c.maSanPham like ?2";
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ChiTietHoaDonDoi cthd = null;
        try {

            Object[] obj = (Object[]) em.createNativeQuery(query)
                    .setParameter(1,ma1)
                    .setParameter(2,ma2)
                    .getSingleResult();

            HoaDonDoiHang_Impl hoaDonDoiHang_dao = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
            HoaDonDoiHang hoaDonDoiHang = hoaDonDoiHang_dao.getHoaDonDoiHangtheoMa(obj[0].toString());
            System.out.println(hoaDonDoiHang.getMaHoaDonDoi());


            Sach_Impl sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
            SanPham sanPham = sach_dao.getSachtheoMa(obj[1].toString());
            System.out.println(sanPham.getMaSanPham());

            cthd = new ChiTietHoaDonDoi(hoaDonDoiHang, sanPham, Integer.parseInt(obj[2].toString()), Double.parseDouble(obj[3].toString()));
            return cthd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        ChiTietHoaDonDoi_Impl dao = new ChiTietHoaDonDoi_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        // insert
//        HoaDonDoiHang_Impl hoaDonDoiHang_dao = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        HoaDonDoiHang hoaDonDoiHang = hoaDonDoiHang_dao.getHoaDonDoiHangtheoMa("1");
//        Sach_Impl sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        SanPham sanPham = sach_dao.getSachtheoMa("2");
//        ChiTietHoaDonDoi cthd = new ChiTietHoaDonDoi(hoaDonDoiHang, sanPham, 1, 1);
//        System.out.println(dao.createChiTietDonDoi(cthd));
         // get all
//        for (ChiTietHoaDonDoi cthd : dao.getAllChiTietDonDoi()) {
//            System.out.println(cthd);
//        }
//       // find by id
//       System.out.printf(dao.getHoaDontheoMa("1", "2").toString());
        // delete
        dao.deleteChiTietDonDoi("1");
    }
}
