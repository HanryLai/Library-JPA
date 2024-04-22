package dao.impl;

import dao.Interface.HoaDonDoiHang_Dao;
import entityJPA.HoaDonDoiHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class HoaDonDoiHang_Impl extends UnicastRemoteObject implements HoaDonDoiHang_Dao {
    private final EntityManagerFactory emf;
    public HoaDonDoiHang_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }
    @Override
    public ArrayList<HoaDonDoiHang> getAllHoaDonDoiHang() throws RemoteException {
        GenericImpl<HoaDonDoiHang> hdGeneric = new GenericImpl<>(HoaDonDoiHang.class, emf);
        return (ArrayList<HoaDonDoiHang>) hdGeneric.findAll();
    }

    @Override
    public boolean createHoaDonDoiHang(HoaDonDoiHang hd) throws RemoteException {
        GenericImpl<HoaDonDoiHang> hdGeneric = new GenericImpl<>(HoaDonDoiHang.class, emf);
        return hdGeneric.save(hd);
    }

    @Override
    public boolean updateHoaDonDoiHang(HoaDonDoiHang hd) throws RemoteException {
        GenericImpl<HoaDonDoiHang> hdGeneric = new GenericImpl<>(HoaDonDoiHang.class, emf);
        return hdGeneric.update(hd);
    }

    @Override
    public HoaDonDoiHang getHoaDonDoiHangtheoMa(String ma) throws RemoteException {
        GenericImpl<HoaDonDoiHang> hdGeneric = new GenericImpl<>(HoaDonDoiHang.class, emf);
        return hdGeneric.findById(ma);
    }

    @Override
    public HoaDonDoiHang getHoaDonDoiHangtheoMaHT(String ma) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        String query = "select maHoaDon  from HoaDon\n" +
                "where CONVERT(date, ngayLap) = ?";
//        List<?> ls = em.createNativeQuery(query)
//                .setParameter(1, ngayLapHD)
//                .getResultList();

        return  null;
    }

    @Override
    public boolean deleteHoaDonDoi(String ma) throws RemoteException {
        return false;
    }

    public static void main(String[] args) {
//       HoaDonDoiHang hd =
    }
}
