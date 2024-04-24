package dao.impl;

import dao.Interface.CaLamViec_Dao;
import entityJPA.CaLamViec;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CaLamViec_Impl extends UnicastRemoteObject implements CaLamViec_Dao {
    private EntityManagerFactory emf;
    public CaLamViec_Impl(EntityManagerFactory emf) throws RemoteException{
        super();
        this.emf = emf;
    }

    @Override
    public CaLamViec getCaLamViecTheoTenCa(String tenCa) throws RemoteException {
        CaLamViec res = new CaLamViec();
        try{
            String query = "SELECT c FROM CaLamViec c WHERE tenCa = :tenCa";
            EntityManager em = emf.createEntityManager();
            res = em.createQuery(query, CaLamViec.class)
                    .setParameter("tenCa", tenCa)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
