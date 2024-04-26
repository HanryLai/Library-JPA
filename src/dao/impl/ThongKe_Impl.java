package dao.impl;



import dao.Interface.ThongKe_Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import otherEntity.MonthlyRevenueInfo;
import otherEntity.ProductInfo;
import untils.entityManagerFactory.EntityManagerFactory_Static;

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
    public List<ProductInfo> getTopSellingProducts() throws RemoteException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date endDate = calendar.getTime();

        String query = "SELECT TOP 5 od.maSanPham , SUM(od.soLuong) AS total_quantity \n" +
                "                FROM ChiTietHoaDon od \n" +
                "                JOIN HoaDon o ON od.maHoaDon = o.maHoaDon \n" +
                "                WHERE o.ngayLap BETWEEN ? AND ? \n" +
                "                GROUP BY od.maSanPham \n" +
                "                ORDER BY total_quantity DESC";
        EntityManager em = emf.createEntityManager();
        List<ProductInfo> topProducts = new ArrayList<>();
        try {

            List<Object[]> resultList = em.createNativeQuery(query)
                    .setParameter(1, startDate)
                    .setParameter(2, endDate)
                    .getResultList();
            for (Object[] o : resultList) {
                String productId = o[0].toString();
                int totalQuantity = Integer.parseInt(o[1].toString());
                topProducts.add(new ProductInfo(productId, totalQuantity));
            }
            return  topProducts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        em.close();
        return topProducts;
    }

    @Override
    public double tongDoanhThu(int currentYear) throws RemoteException {
        String query = "SELECT SUM(tongTien) FROM HoaDon WHERE YEAR(ngayLap) = ?";
        EntityManager em = emf.createEntityManager();
        try {
            return (double) em.createNativeQuery(query).setParameter(1, currentYear).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

       return 0;
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
            em.close();
            return totalRevenue;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<MonthlyRevenueInfo> tongTienTheoThang() throws RemoteException {
        List<MonthlyRevenueInfo> monthlyRevenueList = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            monthlyRevenueList.add(new MonthlyRevenueInfo(month, 0.0));
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
                monthlyRevenueList.add(new MonthlyRevenueInfo(month, totalRevenue));
            }
            em.close();
            return  monthlyRevenueList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  monthlyRevenueList;
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
//        System.out.println(list.size());
        for(Object o : list){
            Object[] arr = (Object[]) o;
            result.add(new MonthlyRevenueInfo((int) arr[0], (double) arr[1]));
        }
        em.close();
        return result;
    }

    @Override
    public double thongKeDoanhThu(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        String query = "SELECT SUM(tongTien) FROM HoaDon WHERE ngayLap BETWEEN ? AND ?";
        EntityManager em = emf.createEntityManager();

        try {
            return (double) em.createNativeQuery(query)
                    .setParameter(1, ngayBatDau)
                    .setParameter(2, ngayKetThuc)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        em.close();
        return 0;

    }

    @Override
    public int thongKeSoHoaDon(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        String query = "SELECT COUNT(*) FROM HoaDon WHERE ngayLap BETWEEN ? AND ?";
        EntityManager em = emf.createEntityManager();
        try {
            return (int) em.createNativeQuery(query)
                    .setParameter(1, ngayBatDau)
                    .setParameter(2, ngayKetThuc)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        em.close();
        return 0;

    }

    @Override
    public int thongKeSoHoaDonHoanTra(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        String query = "SELECT COUNT(*) AS SoLuongHoaDonHoanTra FROM HoaDonHoanTra WHERE ngayHoan BETWEEN ? AND ?";
        EntityManager em = emf.createEntityManager();

        try {
            return (int) em.createNativeQuery(query)
                    .setParameter(1, ngayBatDau)
                    .setParameter(2, ngayKetThuc)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        em.close();
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
        EntityManager em = emf.createEntityManager();
        try {
            String query = "SELECT SUM(tongTien) FROM HoaDon";
            List<?> list = em.createNativeQuery(query).getResultList();
            for (Object o : list) {
                if (o != null) {
                    tongDoanhThu = (double) o;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
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
            List<?> list = em.createNativeQuery(query).setParameter(1, new Date()).setParameter(2, new Date()).getResultList();
            for(Object o : list){
                if (o != null) {
                    soLuongSanPhamDaBan = (int) o;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
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

    public static void main(String[] args) throws RemoteException {
        ThongKe_Dao thongKe_dao = new ThongKe_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        System.out.println(thongKe_dao.getTopSellingProducts());
    }
}
