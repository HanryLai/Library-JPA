package dao.impl;

import dao.Interface.Sach_Dao;
import entityJPA.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Sach_Impl extends UnicastRemoteObject implements Sach_Dao {

    private final EntityManagerFactory emf;
    public Sach_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }

    public ArrayList<Sach> getAlltbSach() throws RemoteException {
        Generic_Impl<Sach> sachGeneric = new Generic_Impl<>(Sach.class, emf);
        return (ArrayList<Sach>) sachGeneric.findAll();
    }

    public void createSach(Sach s) throws RemoteException {
        Generic_Impl<Sach> sachGeneric = new Generic_Impl<>(Sach.class, emf);
        sachGeneric.save(s);
    }

    public Sach getSachtheoMa(String ma) throws RemoteException {
        Generic_Impl<Sach> sachGeneric = new Generic_Impl<>(Sach.class, emf);
        return sachGeneric.findById(ma);
    }

    public void updateSach(Sach s) throws RemoteException {
        Generic_Impl<Sach> sachGeneric = new Generic_Impl<>(Sach.class, emf);
        sachGeneric.update(s);
    }

    public Sach getSachTheoTen(String tenSach) throws RemoteException{
        Sach sach = null;
        try{
            String query = """
            select * from Sach s
            inner join SanPham sp on s.maSanPham = sp.maSanPham
            where s.tenSanPham = :tenSach
            """;
            EntityManager em = emf.createEntityManager();
            sach = (Sach) em.createNativeQuery(query, Sach.class)
                    .setParameter("tenSach", tenSach)
                    .getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sach;
    }




}
