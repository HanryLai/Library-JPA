package dao.impl;

import dao.Interface.Sach_Dao;
import entityJPA.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Sach_Impl extends UnicastRemoteObject implements Sach_Dao {

    private EntityManagerFactory emf;
    public Sach_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    public Sach getSachTheoMa(String ma) throws RemoteException{
        return null;
    }

    public boolean updateSach (Sach sach) throws RemoteException{
        return true;
    }




}
