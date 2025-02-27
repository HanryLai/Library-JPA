package dao.impl;

import dao.Interface.HoaDonHoanTra_Dao;
import dao.Interface.HoaDon_Dao;
import entityJPA.HoaDonHoanTra;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HoaDonHoanTra_Impl extends UnicastRemoteObject implements HoaDonHoanTra_Dao {
    private final EntityManagerFactory emf;
    public HoaDonHoanTra_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    @Override
    public ArrayList<HoaDonHoanTra> getAllHoaDonHoanTra() throws RemoteException {
        Generic_Impl<HoaDonHoanTra> hdGeneric = new Generic_Impl<>(HoaDonHoanTra.class, emf);
        return (ArrayList<HoaDonHoanTra>) hdGeneric.findAll();
    }

    @Override
    public boolean createHoaDonHoanTra(HoaDonHoanTra hd) throws RemoteException {
        Generic_Impl<HoaDonHoanTra> hdGeneric = new Generic_Impl<>(HoaDonHoanTra.class, emf);
        return hdGeneric.save(hd);
    }

    @Override
    public boolean updateHoaDonHoanTra(HoaDonHoanTra hd) throws RemoteException {
        Generic_Impl<HoaDonHoanTra> hdGeneric = new Generic_Impl<>(HoaDonHoanTra.class, emf);
        return hdGeneric.update(hd);
    }

    @Override
    public HoaDonHoanTra getHoaDonHoanTratheoMa(String ma) throws RemoteException {
        Generic_Impl<HoaDonHoanTra> hdGeneric = new Generic_Impl<>(HoaDonHoanTra.class, emf);
        return hdGeneric.findById(ma);
    }

    @Override
    public void deleteHoaDonHoanTra(String ma) throws RemoteException {

    }

    @Override
    public int getLastId() throws RemoteException {
        Generic_Impl<HoaDonHoanTra> hdGeneric = new Generic_Impl<>(HoaDonHoanTra.class, emf);
        int                         id        = 0;
        try {
            List<HoaDonHoanTra> temp = hdGeneric.findAll();
            if (temp.size() == 0)
                return 1;
            id = temp.get(temp.size()-1).getMaHoaDonHoanTra();
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
        return id;
    }

    public static void main(String[] args) throws RemoteException {

//

        HoaDon_Dao dao = new HoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonHoanTra_Dao daoht = new HoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        System.out.println(dao.getMaHoaDonTheoNgay("2023-02-01"));

//        HoaDon hd = dao.getHoaDontheoMa("5");

//         public HoaDonHoanTra(LocalDate ngayHoan, HoaDon hoaDon, String ghiChu, int tinhTrangHoaDon, float tienHoanTra)
//        HoaDonHoanTra hdht = new HoaDonHoanTra(LocalDate.now(), hd, "ghi chu", 1, 100f);
//        System.out.println(daoht.createHoaDonHoanTra(hdht));



    }
}
