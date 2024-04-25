package dao.impl;

import dao.Interface.ChiTietHoaDonHoanTra_Dao;
import dao.Interface.HoaDonHoanTra_Dao;

import dao.Interface.Sach_Dao;
import entityJPA.*;

import entityJPA.otherID.ChiTietHoanTraID;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChiTietHoaDonHoanTraImpl extends UnicastRemoteObject implements ChiTietHoaDonHoanTra_Dao {

    private final EntityManagerFactory emf;
    public ChiTietHoaDonHoanTraImpl(EntityManagerFactory emf) throws RemoteException {
        this.emf = emf;
    }

    @Override
    public ArrayList<ChiTietHoanTra> getAllChiTietHoanTra() throws RemoteException {
        Generic_Impl<ChiTietHoanTra> gen = new Generic_Impl<>(ChiTietHoanTra.class, emf);
        return (ArrayList<ChiTietHoanTra>) gen.findAll();
    }

    @Override
    public boolean createChiTietHoanTra(ChiTietHoanTra ctht) throws RemoteException {
        Generic_Impl<ChiTietHoanTra> gen = new Generic_Impl<>(ChiTietHoanTra.class, emf);
        return gen.save(ctht);
    }

    @Override
    public void deleteChiTietHoanTra(String maHD) throws RemoteException {
        try {
            ArrayList<ChiTietHoanTra> ls = this.getAllChiTietHoanTra();
            Generic_Impl<ChiTietHoanTra> gen = new Generic_Impl<>(ChiTietHoanTra.class, emf);
            for (ChiTietHoanTra ctht : ls) {
                String id = ctht.getHoaDonHoanTra().getHoaDon().getMaHoaDon() + "";
                if (id.equals(maHD)) {
                    gen.delete(ctht.getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ChiTietHoanTra getHoaDontheoMa(String ma1, String ma2) throws RemoteException {
        Generic_Impl<ChiTietHoanTra> gen = new Generic_Impl<>(ChiTietHoanTra.class, emf);
        ChiTietHoanTraID             id  = new ChiTietHoanTraID(Integer.parseInt(ma1), Integer.parseInt(ma2));
        return gen.findById(id);
    }

    public static void main(String[] args) throws RemoteException {
        HoaDonHoanTra_Dao daoht = new HoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        Sach_Dao sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDonHoanTra_Dao daoctht = new ChiTietHoaDonHoanTraImpl(EntityManagerFactory_Static.getEntityManagerFactory());
//        HoaDonDoiHang daohddh = new ChiTietHoaDonDoiImpl(EntityManagerFactory_Static.getEntityManagerFactory());

        HoaDonHoanTra hdht = daoht.getHoaDonHoanTratheoMa("1");
        System.out.println(hdht);

        SanPham sach = sach_dao.getSachtheoMa("2");
        ChiTietHoanTra ctht = new ChiTietHoanTra(hdht, sach, 5, 50f);

        System.out.println(ctht);
        System.out.println(daoctht.createChiTietHoanTra(ctht));

    }
}
