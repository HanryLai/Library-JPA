package dao.impl;

import connectDB.ConnectDB;
import dao.DAO_ThongKe;
import dao.Interface.ThongKe_Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import otherEntity.MonthlyRevenueInfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        return null;
    }

    @Override
    public double tongDoanhThu(int currentYear) throws RemoteException {
        String query = "SELECT SUM(tongTien) FROM HoaDon WHERE YEAR(ngayLap) = ?";
        EntityManager em = emf.createEntityManager();
        return (double) em.createNativeQuery(query).setParameter(1, currentYear).getSingleResult();
    }

    @Override
    public double tongHoanTra(int currentYear) throws RemoteException {
        String query = "SELECT SUM(tienHoanTra) AS total_revenue FROM hoaDonHoanTra "
                + "WHERE YEAR(ngayHoan) = ? "
                + "GROUP BY MONTH(ngayHoan)";
        double totalRevenue = 0.0;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        Date endDate = calendar.getTime();
        try {
            EntityManager em = emf.createEntityManager();
            totalRevenue = (Double) em.createNativeQuery(query)
                    .setParameter(1, currentYear)
                    .getSingleResult();
            return totalRevenue;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<MonthlyRevenueInfo> tongTienTheoThang() throws RemoteException {
        List<entity.MonthlyRevenueInfo> monthlyRevenueList = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            monthlyRevenueList.add(new entity.MonthlyRevenueInfo(month, 0.0));
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        Date endDate = calendar.getTime();

        String sql = "SELECT MONTH(ngayLap) AS month, COALESCE(SUM(tongTien), 0.0) AS total_revenue "
                + "FROM hoaDon "
                + "WHERE YEAR(ngayLap) = ? "
                + "GROUP BY MONTH(ngayLap)";

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        try {
            EntityManager em = emf.createEntityManager();
            List<?> list = em.createNativeQuery(sql)
                    .setParameter(1, currentYear)
                    .getResultList();
            for (Object o : list) {
                Object[] arr = (Object[]) o;
                int month = (int) arr[0];
                double totalRevenue = (double) arr[1];
                monthlyRevenueList.add(new entity.MonthlyRevenueInfo(month, totalRevenue));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MonthlyRevenueInfo> tienHoanTheoThang() throws RemoteException {
        String query = "SELECT MONTH(ngayHoan) AS month, SUM(tienHoanTra) AS total_revenue\n" +
                "FROM hoaDonHoanTra\n" +
                "WHERE YEAR(ngayHoan) = ? " +
                "GROUP BY MONTH(ngayHoan)";
        EntityManager em = emf.createEntityManager();
        List<MonthlyRevenueInfo> result = new ArrayList<>();
        System.out.println(new Date().getYear());
        List<?> list = em.createNativeQuery(query).setParameter(1, Calendar.getInstance().get(Calendar.YEAR)).getResultList();
        System.out.println(list.size());
        for(Object o : list){
            Object[] arr = (Object[]) o;
            result.add(new MonthlyRevenueInfo((int) arr[0], (double) arr[1]));
        }
        return result;
    }

    @Override
    public double thongKeDoanhThu(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        String query = "SELECT SUM(tongTien) FROM HoaDon WHERE ngayLap BETWEEN ? AND ?";
        EntityManager em = emf.createEntityManager();
        return (double) em.createNativeQuery(query)
                .setParameter(1, ngayBatDau)
                .setParameter(2, ngayKetThuc)
                .getSingleResult();

    }

    @Override
    public int thongKeSoHoaDon(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        String query = "SELECT COUNT(*) FROM HoaDon WHERE ngayLap BETWEEN ? AND ?";
        EntityManager em = emf.createEntityManager();
        return (int) em.createNativeQuery(query)
                .setParameter(1, ngayBatDau)
                .setParameter(2, ngayKetThuc)
                .getSingleResult();


    }

    @Override
    public int thongKeSoHoaDonHoanTra(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        String query = "SELECT COUNT(*) AS SoLuongHoaDonHoanTra FROM HoaDonHoanTra WHERE ngayHoan BETWEEN ? AND ?";
        EntityManager em = emf.createEntityManager();
        return (int) em.createNativeQuery(query)
                .setParameter(1, ngayBatDau)
                .setParameter(2, ngayKetThuc)
                .getSingleResult();

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
