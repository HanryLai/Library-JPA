package dao.impl;

import dao.Interface.SanPham_Dao;
import entityJPA.Sach;
import entityJPA.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class SanPham_Impl extends UnicastRemoteObject implements SanPham_Dao {

    private final EntityManagerFactory emf;
    public SanPham_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    public int getLastId() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<SanPham> list = em.createQuery("SELECT s FROM SanPham s", SanPham.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list.get(list.size() - 1).getMaSanPham();
    }




}
