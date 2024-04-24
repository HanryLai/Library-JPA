package dao.impl;

import dao.Interface.BanBaoCao_Dao;
import dao.Interface.MauSac_Dao;
import entityJPA.MauSac;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MauSac_Impl extends UnicastRemoteObject implements MauSac_Dao {
    private final EntityManagerFactory emf;

    public MauSac_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    public ArrayList<MauSac> getAlltbMauSac() throws RemoteException {
        Generic_Impl<MauSac> generic = new Generic_Impl<MauSac>(MauSac.class, emf);
        return (ArrayList<MauSac>) generic.findAll();
    }

    public MauSac getMauSactheoMa(String ma) throws RemoteException {
        Generic_Impl<MauSac> generic = new Generic_Impl<MauSac>(MauSac.class, emf);
        return generic.findById(ma);
    }

    public MauSac getMauSactheoTen(String ten) throws RemoteException {
        Generic_Impl<MauSac> generic = new Generic_Impl<MauSac>(MauSac.class, emf);
        return generic.findByProperty("tenMau", ten).get(0);
    }
}
