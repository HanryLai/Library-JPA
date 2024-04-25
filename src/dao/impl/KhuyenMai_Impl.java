package dao.impl;

import dao.Interface.KhuyenMai_Dao;
import entity.KhuyenMai;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class KhuyenMai_Impl extends UnicastRemoteObject implements KhuyenMai_Dao {

    private final EntityManagerFactory emf;
    public KhuyenMai_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    @Override
    public ArrayList<KhuyenMai> getAlltbKM() throws RemoteException {
        return null;
    }

    @Override
    public void createKhuyenMai(KhuyenMai s) throws RemoteException {

    }

    @Override
    public ArrayList<KhuyenMai> getAlltbKMTheoDangChay() throws RemoteException {
        return null;
    }

    @Override
    public KhuyenMai getKMtheoMa(String ma) throws RemoteException {
        return null;
    }

    @Override
    public void updateKhuyenMai(KhuyenMai s) throws RemoteException {

    }

    @Override
    public String getMaKhuyenMaiTNDB() throws RemoteException {
        return null;
    }

    @Override
    public void updateTinhTrang(KhuyenMai km) throws RemoteException {

    }

    @Override
    public KhuyenMai getKmTheoMa(String maKM) throws RemoteException {
        return null;
    }
}
