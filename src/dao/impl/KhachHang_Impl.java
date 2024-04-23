package dao.impl;

import dao.Interface.KhachHang_Dao;
import entityJPA.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class KhachHang_Impl extends UnicastRemoteObject implements KhachHang_Dao {
    private EntityManagerFactory emf;
    public KhachHang_Impl(EntityManagerFactory emf) throws Exception {
        super();
        this.emf = emf;
    }

    @Override
    public List<KhachHang> getAllKhachHang() throws RemoteException {
        List<KhachHang> list = null;
        try {
            Generic_Impl<KhachHang> generic = new Generic_Impl<>(KhachHang.class, emf);
            list = generic.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public KhachHang getKHTheoMa(int ma) throws RemoteException {
        KhachHang khachHang = null;
        try {
            Generic_Impl<KhachHang> generic = new Generic_Impl<>(KhachHang.class, emf);
            khachHang = generic.findById(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    @Override
    public KhachHang getKHTheoSDT(String soDienThoai) throws RemoteException {
        KhachHang khachHang = null;
        try {
            String query = "SELECT e FROM KhachHang e WHERE e.soDienThoai = :soDienThoai";
            EntityManager em = emf.createEntityManager();
            khachHang = (KhachHang) em.createQuery(query)
                    .setParameter("soDienThoai", soDienThoai)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    @Override
    public boolean themKhachHang(KhachHang cus) throws RemoteException {
        try {
            Generic_Impl<KhachHang> generic = new Generic_Impl<>(KhachHang.class, emf);
            generic.save(cus);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateKhachHang(KhachHang cus) throws RemoteException {
        try {
            Generic_Impl<KhachHang> generic = new Generic_Impl<>(KhachHang.class, emf);
            generic.update(cus);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<KhachHang> locDuLieuKhachHang(String data) throws RemoteException {
        List<KhachHang> list = null;
        try {
            String query = "SELECT * FROM KhachHang\n" +
                    "where tenKhachHang like :data \n" +
                    "or nhomKhachHang like :data\n" +
                    "or soDienThoai like :data\n";
            EntityManager em = emf.createEntityManager();
            list = em.createNativeQuery(query, KhachHang.class)
                    .setParameter("data", "%" + data + "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<KhachHang> getKhachHangTrong1Thang() throws RemoteException {
        List<KhachHang> list = null;
        try {
            String query = "SELECT *FROM KhachHang\n" +
                    "WHERE [maKhachHang] IN \n" +
                    "(SELECT maKhachHang FROM HoaDon\n" +
                    "\tWHERE MONTH([ngayLap]) = MONTH(GETDATE()))";
            EntityManager em = emf.createEntityManager();
            list = em.createNativeQuery(query, KhachHang.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
