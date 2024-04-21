package dao.impl;

import dao.Interface.Sach_Dao;
import entityJPA.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Sach_Impl extends UnicastRemoteObject implements Sach_Dao {

    private EntityManager em;
    private GenericImpl<Sach> generic;
    public Sach_Impl() throws Exception {
        super();
        em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }

    public Sach getSachTheoMa(String ma) throws RemoteException{
        return generic.findById(ma);
    }

    public boolean updateSach (Sach sach) throws RemoteException{
        return generic.update(sach);
    }




}
