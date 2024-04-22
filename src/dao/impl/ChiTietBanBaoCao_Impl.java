package dao.impl;

import dao.Interface.ChiTietBaoCao_Dao;
import entityJPA.ChiTietBanBaoCao;
import entityJPA.SanPham;

import jakarta.persistence.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChiTietBanBaoCao_Impl extends UnicastRemoteObject implements ChiTietBaoCao_Dao {
    private final EntityManagerFactory emf;
    public ChiTietBanBaoCao_Impl(EntityManagerFactory emf) throws RemoteException {
        super();
        this.emf = emf;
    }
    public ArrayList<ChiTietBanBaoCao> getSachDaBan (int maHD, String thoiGianBatDau, String thoiGianKetThuc) throws RemoteException{
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql   = """
                select s.maSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien
                from Sach s
                inner join ChiTietHoaDon ct on ct.sanPham = s.maSanPham
                inner join HoaDon hd on hd.maHoaDon = ct.hoaDon
                where hoaDon like ? and (ngayLap >= ? and ngayLap < ?)
                group by s.maSanPham""";

        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maHD);
        query.setParameter(2, thoiGianBatDau);
        query.setParameter(3, thoiGianKetThuc);

        List<?> result = query.getResultList();

        for (Object obj : result){
            Object[] objArr = (Object[]) obj;
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();
            SanPham sanPham = em.find(SanPham.class, (int) objArr[0]);

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) objArr[1]);
            ct.setThanhTien((double) objArr[2]);
            ct.setGhiChu("");

            list.add(ct);
        }
        em.close();
        return list;
    }

    public ArrayList<ChiTietBanBaoCao> getVPPDaBan (int maHD, String thoiGianBatDau, String thoiGianKetThuc)throws RemoteException{
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql   = """
                select v.maSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien \s
                  from VanPhongPham v
                inner join ChiTietHoaDon ct on ct.sanPham = v.maSanPham
                inner join HoaDon hd on hd.maHoaDon = ct.hoaDon
                   where hoaDon like ? and (ngayLap >= ? and ngayLap < ?)
                  group by v.maSanPham""";

        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maHD);
        query.setParameter(2, thoiGianBatDau);
        query.setParameter(3, thoiGianKetThuc);

        List<?> result = query.getResultList();

        for (Object obj : result){
            Object[] objArr = (Object[]) obj;
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();
            SanPham sanPham = em.find(SanPham.class, (int) objArr[0]);

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) objArr[1]);
            ct.setThanhTien((double) objArr[2]);
            ct.setGhiChu("");

            list.add(ct);
        }
        em.close();

        return list;
    }

//    FIX
    public ArrayList<ChiTietBanBaoCao> getTinhTrangNhapSach(String ngayTao) throws RemoteException{
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql = """
                WITH CumulativeSumCTE AS (
                SELECT
                    tenSanPham,
                    soLuongTon as soLuongNhap,
                    ngayTao,
                    SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon
                FROM
                    Sach
                )
                SELECT
                    tenSanPham,
                    MAX(soLuongNhap) AS soLuongNhap,
                    MAX(CumulativeSoLuongTon) AS tonKho
                FROM
                    CumulativeSumCTE
                WHERE
                    CONVERT(DATE, ngayTao) = ?
                GROUP BY
                    tenSanPham;""";

        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, ngayTao);

        List<?> result = query.getResultList();
        for (Object obj : result){
            Object[] objArr = (Object[]) obj;
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();
            SanPham sanPham = em.find(SanPham.class, (int) objArr[0]);

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) objArr[1]);
            ct.setThanhTien((double) objArr[2]);
            ct.setGhiChu("");

            list.add(ct);
        }
        em.close();

        return list;
    }

    public ArrayList<ChiTietBanBaoCao> getTinhTrangNhapVPP(String ngayTao)throws RemoteException{
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql = """
                WITH CumulativeSumCTE AS (
                SELECT
                    tenSanPham,
                    soLuongTon as soLuongNhap,
                    ngayTao,
                    SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon
                FROM
                    VanPhongPham
                )
                SELECT
                    tenSanPham,
                    MAX(soLuongNhap) AS soLuongNhap,
                    MAX(CumulativeSoLuongTon) AS tonKho
                FROM
                    CumulativeSumCTE
                WHERE
                    CONVERT(DATE, ngayTao) = ?
                GROUP BY
                    tenSanPham;""";
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, ngayTao);

        List<?> result = query.getResultList();
        for (Object obj : result){
            Object[] objArr = (Object[]) obj;
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();
            SanPham sanPham = em.find(SanPham.class, (int) objArr[0]);

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) objArr[1]);
            ct.setThanhTien((double) objArr[2]);
            ct.setGhiChu("");

            list.add(ct);
        }
        em.close();

        return list;
    }

    public double getDoanhThuTheoCa(int maHD, String thoiGianBatDau, String thoiGianKetThuc)throws RemoteException{
        double doanhThu = 0;
        String sql = """
                select sum(ThanhTien) as ThanhTien
                from HoaDon hd
                inner join ChiTietHoaDon cthd on hd.maHoaDon = cthd.hoaDon
                inner join NhanVien nv on nv.maNhanVien = hd.nhanVien
                where hd.maHoaDon like ? and (ngayLap >= ? and ngayLap < ?)
                group by nv.caLamViec""";

        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maHD);
        query.setParameter(2, thoiGianBatDau);
        query.setParameter(3, thoiGianKetThuc);

        List<?> result = query.getResultList();
        for (Object obj : result){
            doanhThu += (double) obj;
        }
        em.close();

        return doanhThu;
    }

    public ArrayList<ChiTietBanBaoCao> getChiTietBanBaoCao(int maBanBaoCao) throws RemoteException {
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<ChiTietBanBaoCao>();

        GenericImpl<ChiTietBanBaoCao> generic = new GenericImpl<>(ChiTietBanBaoCao.class, emf);
        list = (ArrayList<ChiTietBanBaoCao>) generic.findByProperty("maBanBaoCao", maBanBaoCao);

        return list;
    }

    public double getDoanhThuCaNgay(String maBanBaoCao)throws RemoteException{
        double doanhThu = 0;
        String sql = """
                select sum(ThanhTien) as ThanhTien
                from ChiTietBanBaoCao
                where maBanBaoCao like ?""";

        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maBanBaoCao);

        List<?> result = query.getResultList();
        for (Object obj : result){
            doanhThu += (double) obj;
        }
        em.close();
        return doanhThu;
    }

    public int getTongSanPhamBanDuoc(String maBanBaoCao)throws RemoteException{
        int soLuong = 0;
        String sql = """
                select sum(SoLuongBan) as SoLuongBan
                from ChiTietBanBaoCao
                where maBanBaoCao like ?""";
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maBanBaoCao);

        List<?> result = query.getResultList();
        for (Object obj : result){
            soLuong += (int) obj;
        }
        em.close();
        return soLuong;
    }

    public double getDoanhThuTheoTenBC(String tenBanBaoCao)throws RemoteException{
        double doanhThu = 0;
        String sql = """
                select doanhThu
                from BanBaoCao
                where tenBanBaoCao like ?""";
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, tenBanBaoCao);

        List<?> result = query.getResultList();
        for (Object obj : result){
            doanhThu += (double) obj;
        }
        em.close();
        return doanhThu;
    }

}