package dao.impl;

import dao.Interface.ChiTietHoaDonHoanTra_Dao;
import dao.Interface.HoaDonHoanTra_Dao;
import entityJPA.otherID.ChiTietDoiHangID;
import entityJPA.ChiTietHoanTra;
import entityJPA.HoaDonDoiHang;
import entityJPA.HoaDonHoanTra;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChiTietHoaDonHoanTraImpl extends UnicastRemoteObject implements ChiTietHoaDonHoanTra_Dao {

    private final EntityManagerFactory emf;
    public ChiTietHoaDonHoanTraImpl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    @Override
    public ArrayList<ChiTietHoanTra> getAllChiTietHoanTra() throws RemoteException {
        return null;
    }

    @Override
    public boolean createChiTietHoanTra(ChiTietHoanTra cthd) throws RemoteException {
        return false;
    }

    @Override
    public void deleteChiTietHoanTra(String maHD) throws RemoteException {

    }

    @Override
    public ChiTietHoanTra getHoaDontheoMa(String ma1, String ma2) throws RemoteException {
        return null;
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
