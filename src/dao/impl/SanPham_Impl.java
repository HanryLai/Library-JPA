package dao.impl;

import dao.Interface.SanPham_Dao;
import entityJPA.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SanPham_Impl extends UnicastRemoteObject implements SanPham_Dao {

    private EntityManager em;
    private GenericImpl<SanPham> generic;
    public SanPham_Impl() throws Exception {
        super();
        em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
        generic = new GenericImpl<>(SanPham.class);
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
    public boolean save(SanPham obj) throws RemoteException {
        return generic.save(obj);
    }

    @Override
    public boolean update(SanPham obj) throws RemoteException {
        return generic.update(obj);
    }

    @Override
    public boolean delete(Object id) {
        return generic.delete(id);
    }

    @Override
    public SanPham findById(Object id) throws RemoteException {
        return generic.findById(id);
    }

    @Override
    public List<SanPham> findAll() throws RemoteException {
        return generic.findAll();
    }

    @Override
    public List<SanPham> findByProperty(String property, Object value) throws RemoteException {
        return generic.findByProperty(property, value);
    }


}
