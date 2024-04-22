package dao.impl;

import dao.Interface.NhomSanPham_Dao;
import entityJPA.NhomSanPham;
import entityJPA.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class NhomSanPham_Impl extends UnicastRemoteObject implements NhomSanPham_Dao {
    private EntityManager em = Persistence
            .createEntityManagerFactory("jpa-mssql")
            .createEntityManager();
    private GenericImpl<NhomSanPham> generic;

    protected NhomSanPham_Impl(Class<NhomSanPham> entityClass) throws RemoteException {
        super();
        generic = new GenericImpl<NhomSanPham>(entityClass);
    }

    @Override
    public void open() throws RemoteException {

    }

    @Override
    public void close() throws RemoteException {

    }

    @Override
    public boolean save(NhomSanPham obj) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(NhomSanPham obj) throws RemoteException {
        return false;
    }

    @Override
    public boolean delete(Object id) throws RemoteException {
        return false;
    }

    @Override
    public NhomSanPham findById(Object id) throws RemoteException {
        return null;
    }

    @Override
    public List<NhomSanPham> findAll() throws RemoteException {
        return null;
    }

    @Override
    public List<NhomSanPham> findByProperty(String property, Object value) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<NhomSanPham> getAllNhomSanPham() {
//        String queryStr = "SELECT n.maNhomSanPham, n.tenNhomSanPham FROM NhomSanPham n";
//        Query query = em.createQuery(queryStr);
//
//        List<Object[]> resultList = query.getResultList();
//        List<NhomSanPham> listNhomSanPham = new ArrayList<>();
//
//        for (Object[] obj : resultList) {
//            int maNhomSanPham = (int) obj[0];
//            String tenNhomSanPham = (String) obj[1];
//
//            // Tạo đối tượng NhomSanPham từ các giá trị trong mảng obj
//            NhomSanPham nhomSanPham = new NhomSanPham();
//            nhomSanPham.setMaNhomSanPham(maNhomSanPham);
//            nhomSanPham.setTenNhomSanPham(tenNhomSanPham);
//
//            // Thêm đối tượng NhomSanPham vào danh sách
//            listNhomSanPham.add(nhomSanPham);
//        }

        List<NhomSanPham> listNhomSanPham =

        return (ArrayList<NhomSanPham>) listNhomSanPham;
    }

    @Override
    public NhomSanPham getNsptheoTen(String ten) {
        String queryStr = "SELECT n.maNhomSanPham, n.tenNhomSanPham FROM NhomSanPham n WHERE n.tenNhomSanPham = :ten";
        Query query = em.createQuery(queryStr);
        query.setParameter("ten", "%"+ten+"%");
        Object resultList = query.getSingleResult();
        Object[] obj = (Object[]) resultList;
        NhomSanPham nhomSanPham = new NhomSanPham();
        nhomSanPham.setMaNhomSanPham((int) obj[0]);
        nhomSanPham.setTenNhomSanPham((String) obj[1]);
        return nhomSanPham;
    }

    @Override
    public NhomSanPham getNspTheoMa(String ma) {
        return null;
    }
}
