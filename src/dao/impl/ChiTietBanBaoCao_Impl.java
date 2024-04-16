package dao.impl;

import dao.Interface.ChiTietBaoCao_Dao;
import entityJPA.ChiTietBanBaoCao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChiTietBanBaoCao_Impl extends UnicastRemoteObject implements ChiTietBaoCao_Dao {

    private EntityManager em;
    private GenericImpl<ChiTietBanBaoCao> generic;
    public ChiTietBanBaoCao_Impl() throws Exception {
        super();
        em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
        generic = new GenericImpl<>(ChiTietBanBaoCao.class);
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
    public boolean save(ChiTietBanBaoCao obj) throws RemoteException {
        return generic.save(obj);
    }

    @Override
    public boolean update(ChiTietBanBaoCao obj) throws RemoteException {
        return generic.update(obj);
    }

    @Override
    public boolean delete(Object id) {
        return generic.delete(id);
    }

    @Override
    public ChiTietBanBaoCao findById(Object id) throws RemoteException {
        return generic.findById(id);
    }

    @Override
    public List<ChiTietBanBaoCao> findAll() throws RemoteException {
        return generic.findAll();
    }

    @Override
    public List<ChiTietBanBaoCao> findByProperty(String property, Object value) throws RemoteException {
        return generic.findByProperty(property, value);
    }

}