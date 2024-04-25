package dao.impl;

import dao.Interface.HoaDonDoiHang_Dao;
import dao.Interface.HoaDonHoanTra_Dao;
import entityJPA.HoaDonDoiHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDoiHang_Impl extends UnicastRemoteObject implements HoaDonDoiHang_Dao {
    private final EntityManagerFactory emf;
    public HoaDonDoiHang_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }
    @Override
    public ArrayList<HoaDonDoiHang> getAllHoaDonDoiHang() throws RemoteException {
        Generic_Impl<HoaDonDoiHang> hdGeneric = new Generic_Impl<>(HoaDonDoiHang.class, emf);
        return (ArrayList<HoaDonDoiHang>) hdGeneric.findAll();
    }

    @Override
    public boolean createHoaDonDoiHang(HoaDonDoiHang hd) throws RemoteException {
        Generic_Impl<HoaDonDoiHang> hdGeneric = new Generic_Impl<>(HoaDonDoiHang.class, emf);
        return hdGeneric.save(hd);
    }

    @Override
    public boolean updateHoaDonDoiHang(HoaDonDoiHang hd) throws RemoteException {
        Generic_Impl<HoaDonDoiHang> hdGeneric = new Generic_Impl<>(HoaDonDoiHang.class, emf);
        return hdGeneric.update(hd);
    }

    @Override
    public HoaDonDoiHang getHoaDonDoiHangtheoMa(String ma) throws RemoteException {
        Generic_Impl<HoaDonDoiHang> hdGeneric = new Generic_Impl<>(HoaDonDoiHang.class, emf);
        return hdGeneric.findById(ma);
    }

    @Override
    public HoaDonDoiHang getHoaDonDoiHangtheoMaHT(String ma) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        String query = "select maHoaDonDoi from HoaDonDoiHang\n" +
                "where maHoaDonHoanTra = ?";
        List<?> ls = em.createNativeQuery(query)
                .setParameter(1, ma)
                .getResultList();

        if(ls.size() == 0)
            return  null;
        int id = (int) ls.get(0);
        HoaDonDoiHang hdht = em.find(HoaDonDoiHang.class, id);

        return  hdht;
    }

    @Override
    public boolean deleteHoaDonDoi(String ma) throws RemoteException {
        return false;
    }
    @Override
    public int getLastId() throws RemoteException {
        Generic_Impl<HoaDonDoiHang> hdGeneric = new Generic_Impl<>(HoaDonDoiHang.class, emf);
        int                         id        = 0;
        try {
            List<HoaDonDoiHang> temp = hdGeneric.findAll();
            if (temp.size() == 0)
                return 1;
            id = temp.get(temp.size()-1).getMaHoaDonDoi();
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
        return id;
    }

    public static void main(String[] args) throws RemoteException {
        HoaDonHoanTra_Dao daoht = new HoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonDoiHang_Dao daodh = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());

//        HoaDonHoanTra hdht = daoht.getHoaDonHoanTratheoMa("1");
//        public HoaDonDoiHang(HoaDonHoanTra hoaDonHoanTra, String ghiChu, float tienHoanTra, float chietKhau, String khuyenMai)
//        HoaDonDoiHang hddh = new HoaDonDoiHang(hdht, "ghi chu", 50f, 0.1f, "khum");
//
//        System.out.println(daodh.createHoaDonDoiHang(hddh));


        System.out.println(daodh.getHoaDonDoiHangtheoMaHT("1"));

    }
}
