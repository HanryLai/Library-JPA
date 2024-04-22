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




}
