package dao.impl;

import dao.Interface.ChiTietHoaDonHoanTra_Dao;
import dao.Interface.HoaDonHoanTra_Dao;
import entityJPA.*;
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
        GenericImpl<ChiTietHoanTra> gen = new GenericImpl<>(ChiTietHoanTra.class, emf);
        return (ArrayList<ChiTietHoanTra>) gen.findAll();
    }

    @Override
    public boolean createChiTietHoanTra(ChiTietHoanTra ctht) throws RemoteException {
        GenericImpl<ChiTietHoanTra> gen = new GenericImpl<>(ChiTietHoanTra.class, emf);
        return gen.save(ctht);
    }

    @Override
    public void deleteChiTietHoanTra(String maHD) throws RemoteException {
        try {
            ArrayList<ChiTietHoanTra> ls = this.getAllChiTietHoanTra();
            GenericImpl<ChiTietHoanTra> gen = new GenericImpl<>(ChiTietHoanTra.class, emf);
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
        GenericImpl<ChiTietHoanTra> gen = new GenericImpl<>(ChiTietHoanTra.class, emf);
        ChiTietHoanTraID id = new ChiTietHoanTraID(Integer.parseInt(ma1), Integer.parseInt(ma2));
        return gen.findById(id);
    }

    public static void main(String[] args) throws RemoteException {
        HoaDonHoanTra_Dao daoht = new HoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDonHoanTra_Dao daoctht = new ChiTietHoaDonHoanTraImpl(EntityManagerFactory_Static.getEntityManagerFactory());
//        HoaDonDoiHang daohddh = new ChiTietHoaDonDoiImpl(EntityManagerFactory_Static.getEntityManagerFactory());

        HoaDonHoanTra hdht = daoht.getHoaDonHoanTratheoMa("1");
        System.out.println(hdht);

//        ChiTietDoiHangID id, SanPham sanPham, HoaDonHoanTra hoaDonHoanTra, int soLuong, double thanhTien
        ChiTietHoanTra ctht = new ChiTietHoanTra();
        ctht.setHoaDonHoanTra(hdht);
        ctht.setSoLuong(5);
        ctht.setThanhTien(50f);

        System.out.println(daoctht.createChiTietHoanTra(ctht));

    }
}
