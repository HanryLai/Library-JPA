package dao.impl;

import dao.DAO_ThongKe;
import dao.Interface.ThongKe_Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import otherEntity.MonthlyRevenueInfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThongKe_Impl extends UnicastRemoteObject implements ThongKe_Dao {
    private final EntityManagerFactory emf;
    public ThongKe_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }
    @Override
    public List<DAO_ThongKe.ProductInfo> getTopSellingProducts() throws RemoteException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date endDate = calendar.getTime();

        String query = "SELECT TOP 5 od.sanPham, SUM(od.soLuong) AS total_quantity "
                + "FROM ChiTietHoaDon od "
                + "JOIN HoaDon o ON od.hoaDon = o.maHoaDon "
                + "WHERE o.ngayLap BETWEEN ? AND ? "
                + "GROUP BY od.sanPham "
                + "ORDER BY total_quantity DESC ";
        EntityManager em = emf.createEntityManager();
        List<DAO_ThongKe.ProductInfo> topProducts = new ArrayList<>();
        try {

            List<Object[]> resultList = em.createNativeQuery(query)
                    .setParameter(1, startDate)
                    .setParameter(2, endDate)
                    .getResultList();
            for (Object[] o : resultList) {
                String productId = o[0].toString();
                int totalQuantity = Integer.parseInt(o[1].toString());
                topProducts.add(new DAO_ThongKe.ProductInfo(productId, totalQuantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public double tongDoanhThu(int currentYear) throws RemoteException {
        return 0;
    }

    @Override
    public double tongHoanTra(int currentYear) throws RemoteException {
        return 0;
    }

    @Override
    public List<MonthlyRevenueInfo> tongTienTheoThang() throws RemoteException {
        return null;
    }

    @Override
    public List<MonthlyRevenueInfo> tienHoanTheoThang() throws RemoteException {
        return null;
    }

    @Override
    public double thongKeDoanhThu(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        return 0;
    }

    @Override
    public int thongKeSoHoaDon(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        return 0;
    }

    @Override
    public int thongKeSoHoaDonHoanTra(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        return 0;
    }

    @Override
    public int thongKeSoLuongSanPhamDaBan(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        int soLuongSanPhamDaBan = 0;
        try{
            String query = "SELECT SUM(soLuong) AS SoLuongSanPhamDaBan FROM ChiTietHoaDon WHERE hoaDon IN "
                    + "(SELECT maHoaDon FROM HoaDon WHERE ngayLap BETWEEN ? AND ?)";
            EntityManager em = emf.createEntityManager();
            soLuongSanPhamDaBan = (int) em.createNativeQuery(query)
                    .setParameter(1, ngayBatDau)
                    .setParameter(2, ngayKetThuc)
                    .getSingleResult();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return soLuongSanPhamDaBan;
    }

    @Override
    public double ThongKeTongDoanhThu() throws RemoteException {
        double tongDoanhThu = 0;
        try {
            String query = "SELECT SUM(tongTien) FROM HoaDon";
            EntityManager em = emf.createEntityManager();
            tongDoanhThu = (double) em.createNativeQuery(query).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongDoanhThu;
    }

    @Override
    public int thongKeTongSoHoaDon() throws RemoteException {
        int tongSoHoaDon = 0;
        try{
            String query = "SELECT COUNT(*) FROM HoaDon";
            EntityManager em = emf.createEntityManager();
            tongSoHoaDon = (int) em.createNativeQuery(query).getSingleResult();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return tongSoHoaDon;
    }

    @Override
    public int thongKeTongSoHoaDonHoanTra() throws RemoteException {
        int tongSoHoaDonHoanTra = 0;
        try{
            String query = "SELECT COUNT(*) FROM HoaDonHoanTra";
            EntityManager em = emf.createEntityManager();
            tongSoHoaDonHoanTra = (int) em.createNativeQuery(query).getSingleResult();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return tongSoHoaDonHoanTra;
    }

    @Override
    public int thongKeTongSoLuongSanPhamDaBan() throws RemoteException {
        int soLuongSanPhamDaBan = 0;
        EntityManager em = emf.createEntityManager();
        try{
            String query = "SELECT SUM(soLuong) AS SoLuongSanPhamDaBan FROM ChiTietHoaDon WHERE ChiTietHoaDon.maHoaDon IN (SELECT maHoaDon FROM HoaDon WHERE ngayLap  BETWEEN ? AND ?)";
            soLuongSanPhamDaBan = (int) em.createNativeQuery(query)
                    .setParameter(1, new Date())
                    .setParameter(2, new Date())
                    .getSingleResult();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return soLuongSanPhamDaBan;
    }

    @Override
    public List<Integer> getDistinctYears() throws RemoteException {
        List<Integer> years = new ArrayList<>();
        try {
            String        query = "SELECT DISTINCT YEAR(ngayLap) AS nam FROM HoaDon";
            EntityManager em    = emf.createEntityManager();
            List<?>       list  = em.createNativeQuery(query).getResultList();
            for(Object o : list){
                years.add((int) o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return years;
    }
}
