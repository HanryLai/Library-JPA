package dao.impl;

import dao.Interface.NhanVien_Dao;
import entity.CaLamViec;
import entity.ChucVu;
import entity.TaiKhoan;
import entityJPA.NhanVien;
import entityJPA.VanPhongPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NhanVien_Impl extends UnicastRemoteObject implements NhanVien_Dao {
    private EntityManagerFactory emf;


    public NhanVien_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<NhanVien> getAllNhanVien() throws RemoteException {
        List<NhanVien> list = null;
        try{
            Generic_Impl<NhanVien> generic = new Generic_Impl<>(NhanVien.class, emf);
            list = generic.findAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<NhanVien> getAllNhanVienTheoCa(int caLv) throws RemoteException {
        List<NhanVien> list = null;
        try{
            String query = "select * from NhanVien where maCa = :caLv";
            EntityManager em = emf.createEntityManager();
            list = em.createNativeQuery(query, NhanVien.class)
                    .setParameter("caLv", caLv)
                    .getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public NhanVien getNVTheoMa(int maNV) throws RemoteException {
        NhanVien nhanVien = null;
        try{
           Generic_Impl<NhanVien> generic = new Generic_Impl<>(NhanVien.class, emf);
              nhanVien = generic.findById(maNV);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    @Override
    public boolean themNhanVien(NhanVien nv) throws RemoteException {
        try{
            Generic_Impl<NhanVien> generic = new Generic_Impl<>(NhanVien.class, emf);
            generic.save(nv);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateNhanVien(NhanVien nv) throws RemoteException {
        try{
            Generic_Impl<NhanVien> generic = new Generic_Impl<>(NhanVien.class, emf);
            //NhanVien nvMoi = generic.findById(maNVSua);
            generic.update(nv);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
             return false;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<NhanVien> locNhanVien(String duLieuTim) throws RemoteException {
        List<NhanVien> list = null;
        try{
            String query = "SELECT *FROM NhanVien\n" +
                    "WHERE maNhanVien like :duLieuTim or hoTenNV like :duLieuTim or soDienThoai like :duLieuTim \n" +
                    "or gioiTinh like :duLieuTim or email like :duLieuTim or tenDangNhap like :duLieuTim \n" +
                    "or maCa like :duLieuTim or chucVu like :duLieuTim";
            EntityManager em = emf.createEntityManager();
            list = em.createNativeQuery(query, NhanVien.class)
                    .setParameter("duLieuTim", "%"+duLieuTim+"%")
                    .getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<NhanVien> locNhanVienTheoChucVu(String duLieuTim) throws RemoteException {
        List<NhanVien> list = null;
        try {
            String query = "SELECT *FROM NhanVien where chucVu like :duLieuTim";
            EntityManager em = emf.createEntityManager();
            list = em.createNativeQuery(query, NhanVien.class)
                    .setParameter("duLieuTim", duLieuTim)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getMaNhanVienQLDB() throws RemoteException {
        return null;
    }

    @Override
    public String getMaNhanVienTNDB() throws RemoteException {
        return null;
    }

    @Override
    public String getCaLamViecTheoNhanVien(String email) throws RemoteException {
        String maCa = "";
        try {
            String query = "SELECT maCa FROM NhanVien WHERE email like :email";
            EntityManager em = emf.createEntityManager();
            maCa = (String) em.createNativeQuery(query, String.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maCa;
    }
}
