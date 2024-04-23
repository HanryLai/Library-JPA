package dao.impl;

import dao.DAO_ThongKe;
import dao.Interface.ThongKe_Dao;
import entity.MonthlyRevenueInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
        return 0;
    }

    @Override
    public int thongKeTongSoLuongSanPhamDaBan() throws RemoteException {
        return 0;
    }

    @Override
    public List<Integer> getDistinctYears() throws RemoteException {
        return null;
    }
}
