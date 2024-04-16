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
        generic = new GenericImpl<>(Sach.class);
    }

    @Override
    public void open() throws RemoteException {
        generic.open();
    }

    @Override
    public void close() throws RemoteException {
        generic.close();
    }

    @Override
    public boolean save(Sach obj) throws RemoteException {
        return generic.save(obj);
    }

    @Override
    public boolean update(Sach obj) throws RemoteException {
        return generic.update(obj);
    }

    @Override
    public boolean delete(Object id) {
        return generic.delete(id);
    }

    @Override
    public Sach findById(Object id) throws RemoteException {
        return generic.findById(id);
    }

    @Override
    public List<Sach> findAll() throws RemoteException {
        return generic.findAll();
    }

    @Override
    public List<Sach> findByProperty(String property, Object value) throws RemoteException {
        return generic.findByProperty(property, value);
    }


}
