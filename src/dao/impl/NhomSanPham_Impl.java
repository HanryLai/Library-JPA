package dao.impl;

import dao.Interface.NhomSanPham_Dao;
import entityJPA.NhomSanPham;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class NhomSanPham_Impl extends UnicastRemoteObject implements NhomSanPham_Dao {
    private final EntityManagerFactory emf;
    public NhomSanPham_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }


    @Override
    public ArrayList<NhomSanPham> getAllNhomSanPham() throws  RemoteException{
       Generic_Impl<NhomSanPham> nspGeneric = new Generic_Impl<>(NhomSanPham.class, emf);
       return (ArrayList<NhomSanPham>) nspGeneric.findAll();
    }

    @Override
    public NhomSanPham getNsptheoTen(String ten) throws RemoteException {
        Generic_Impl<NhomSanPham> nspGeneric = new Generic_Impl<>(NhomSanPham.class, emf);
        return nspGeneric.findByProperty("tenNhomSanPham", ten).get(0);

    }

    @Override
    public NhomSanPham getNspTheoMa(String ma) throws RemoteException {
        Generic_Impl<NhomSanPham> nspGeneric = new Generic_Impl<>(NhomSanPham.class, emf);
        return nspGeneric.findByProperty("maNhomSanPham", ma).get(0);
    }
}





