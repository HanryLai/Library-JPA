package dao.impl;

import dao.Interface.Sach_Dao;
import entityJPA.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Sach_Impl extends UnicastRemoteObject implements Sach_Dao {

    private final EntityManagerFactory emf;
    public Sach_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    public ArrayList<Sach> getAlltbSach() throws RemoteException {
        GenericImpl<Sach> sachGeneric = new GenericImpl<>(Sach.class, emf);
        return (ArrayList<Sach>) sachGeneric.findAll();
    }

    public void createSach(Sach s) throws RemoteException {
        GenericImpl<Sach> sachGeneric = new GenericImpl<>(Sach.class, emf);
        sachGeneric.save(s);
    }

    public Sach getSachtheoMa(String ma) throws RemoteException {
        GenericImpl<Sach> sachGeneric = new GenericImpl<>(Sach.class, emf);
        return sachGeneric.findById(ma);
    }

    public void updateSach(Sach s) throws RemoteException {
        GenericImpl<Sach> sachGeneric = new GenericImpl<>(Sach.class, emf);
        sachGeneric.update(s);
    }




}
