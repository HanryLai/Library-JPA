package dao.impl;

import dao.Interface.ChiTietHoaDonDoi_Dao;
import dao.Interface.HoaDonHoanTra_Dao;
import dao.Interface.HoaDon_Dao;
import entityJPA.*;
import entityJPA.otherID.ChiTietHoaDonDoiID;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDoi_Impl extends UnicastRemoteObject implements ChiTietHoaDonDoi_Dao {
    private final EntityManagerFactory emf;
    public ChiTietHoaDonDoi_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    @Override
    public ArrayList<ChiTietHoaDonDoi> getAllChiTietDonDoi() throws RemoteException {
        Generic_Impl<entityJPA.ChiTietHoaDonDoi> generic = new Generic_Impl<>(entityJPA.ChiTietHoaDonDoi.class, emf);
        ArrayList<ChiTietHoaDonDoi> list = new ArrayList<>();
        for (entityJPA.ChiTietHoaDonDoi cthd : generic.findAll()) {
            list.add(new ChiTietHoaDonDoi(cthd.getHoaDonDoiHang(),cthd.getSanPham(),cthd.getSoLuong(),cthd.getThanhTien()));
        }
        return list;
    }

    @Override
    public boolean createChiTietDonDoi(ChiTietHoaDonDoi cthd) throws RemoteException {
        try {
            Generic_Impl<ChiTietHoaDonDoi> generic = new Generic_Impl<>(ChiTietHoaDonDoi.class, emf);
            return generic.save(cthd);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void deleteChiTietDonDoi(String maHD) throws RemoteException {
       Generic_Impl<ChiTietHoaDonDoi> generic = new Generic_Impl<>(ChiTietHoaDonDoi.class, emf);
       List<ChiTietHoaDonDoi> temp = generic.findByProperty("id.maHoaDonDoi",maHD);
       for(ChiTietHoaDonDoi cthd : temp){
           generic.delete(cthd.getId());
       }
    }




    @Override
    public ChiTietHoaDonDoi getHoaDontheoMa(String ma1, String ma2) throws RemoteException {
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

    public static void main(String[] args) throws RemoteException {
        ChiTietHoaDonDoi_Impl dao = new ChiTietHoaDonDoi_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        // insert
//        HoaDonDoiHang_Impl hoaDonDoiHang_dao = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        HoaDonDoiHang hoaDonDoiHang = hoaDonDoiHang_dao.getHoaDonDoiHangtheoMa("1");
//        Sach_Impl sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        SanPham sanPham = sach_dao.getSachtheoMa("2");
//        ChiTietHoaDonDoi cthd = new ChiTietHoaDonDoi();
//        cthd.setId(new ChiTietHoaDonDoiID(1,1));
//        System.out.println(dao.createChiTietDonDoi(cthd));
         // get all
//        for (ChiTietHoaDonDoi cthd : dao.getAllChiTietDonDoi()) {
//            System.out.println(cthd);
//        }
//       // find by id
//       System.out.printf(dao.getHoaDontheoMa("1", "2").toString());
        // delete
//        dao.deleteChiTietDonDoi("1");
    }
}
