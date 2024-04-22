package dao.impl;

import dao.DAO_ThongKe;
import dao.Interface.ThongKe_Dao;
import entity.MonthlyRevenueInfo;
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
        return 0;
    }

    @Override
    public double ThongKeTongDoanhThu() throws RemoteException {
        return 0;
    }

    @Override
    public int thongKeTongSoHoaDon() throws RemoteException {
        return 0;
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
