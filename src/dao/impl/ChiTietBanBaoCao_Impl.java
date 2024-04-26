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
    public void taoChiTietBanBaoCao(ChiTietBanBaoCao data) throws RemoteException{
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(data);
            et.commit();
        } catch (Exception e){
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void taoChiTietBaoCao(ChiTietBanBaoCao entity) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(entity);
            et.commit();
        } catch (Exception e){
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public ArrayList<ChiTietBanBaoCao> getSachDaBan (String thoiGianBatDau, String thoiGianKetThuc) throws RemoteException{
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();

        thoiGianBatDau = thoiGianBatDau.replace("T", " ");
        thoiGianKetThuc = thoiGianKetThuc.replace("T", " ");

        String sql   = """
                select s.maSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien
                                from Sach s
                                inner join ChiTietHoaDon ct on ct.maSanPham = s.maSanPham
                                inner join HoaDon hd on hd.maHoaDon = ct.maHoaDon
                                where (ngayLap >= ? and ngayLap < ?)
                                group by s.maSanPham""";

        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql, Object.class);
        query.setParameter(1, thoiGianBatDau);
        query.setParameter(2, thoiGianKetThuc);

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

    public ArrayList<ChiTietBanBaoCao> getVPPDaBan (String thoiGianBatDau, String thoiGianKetThuc)throws RemoteException{
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();

        thoiGianBatDau = thoiGianBatDau.replace("T", " ");
        thoiGianKetThuc = thoiGianKetThuc.replace("T", " ");

        String sql   = """
                select vpp.maSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien
                                from VanPhongPham vpp
                                inner join ChiTietHoaDon ct on ct.maSanPham = vpp.maSanPham
                                inner join HoaDon hd on hd.maHoaDon = ct.maHoaDon
                                where (ngayLap >= ? and ngayLap < ?)
                                group by vpp.maSanPham""";

        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery(sql, Object.class);
        query.setParameter(1, thoiGianBatDau);
        query.setParameter(2, thoiGianKetThuc);

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
        ngayTao = ngayTao.substring(0, 10);
        System.out.println(ngayTao);
        String sql = """
                WITH CumulativeSumCTE AS (
                SELECT
                    Sach.maSanPham as maSanPham,
                    soLuongTon as soLuongNhap,
                    ngayTao,
                    SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon
                FROM
                    Sach inner join SanPham on Sach.maSanPham = SanPham.maSanPham
                )
                SELECT
                    maSanPham,
                    MAX(soLuongNhap) AS soLuongNhap,
                    MAX(CumulativeSoLuongTon) AS tonKho
                FROM
                    CumulativeSumCTE
                WHERE
                    CONVERT(DATE, ngayTao) = ?
                GROUP BY
                    maSanPham
""";

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
            ct.setThanhTien((int) objArr[2] + 0.0);
            ct.setGhiChu("");

            list.add(ct);
        }
        em.close();

        return list;
    }

    public ArrayList<ChiTietBanBaoCao> getTinhTrangNhapVPP(String ngayTao)throws RemoteException{
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        ngayTao = ngayTao.substring(0, 10);
        String sql = """
                    WITH CumulativeSumCTE AS (
                    SELECT
                        VanPhongPham.maSanPham as maSanPham,
                        soLuongTon as soLuongNhap,
                        ngayTao,
                        SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon
                    FROM
                        VanPhongPham inner join SanPham on VanPhongPham.maSanPham = SanPham.maSanPham
                    )
                    SELECT
                        maSanPham,
                        MAX(soLuongNhap) AS soLuongNhap,
                        MAX(CumulativeSoLuongTon) AS tonKho
                    FROM
                        CumulativeSumCTE
                    WHERE
                        CONVERT(DATE, ngayTao) = ?
                    GROUP BY
                        maSanPham
                        """;
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
            ct.setThanhTien((int) objArr[2] + 0.0);
            ct.setGhiChu("");

            list.add(ct);
        }
        em.close();

        return list;
    }

    public double getDoanhThuTheoCa(int maHD, String thoiGianBatDau, String thoiGianKetThuc)throws RemoteException{
        double doanhThu = 0;
        thoiGianBatDau = thoiGianBatDau.replace("T", " ");
        thoiGianKetThuc = thoiGianKetThuc.replace("T", " ");
        String sql = """
            select sum(ThanhTien) as ThanhTien
                from HoaDon hd
                inner join ChiTietHoaDon cthd on hd.maHoaDon = cthd.maHoaDon
                inner join NhanVien nv on nv.maNhanVien = hd.maNhanVien
                where hd.maHoaDon like ? and (ngayLap >= ? and ngayLap < ?)
                group by nv.maCa
                """;

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

        Generic_Impl<ChiTietBanBaoCao> generic = new Generic_Impl<>(ChiTietBanBaoCao.class, emf);
        list = (ArrayList<ChiTietBanBaoCao>) generic.findByProperty("id.maBanBaoCao", maBanBaoCao);

        return list;
    }

    public double getDoanhThuCaNgay(int maBanBaoCao)throws RemoteException{
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

    public int getTongSanPhamBanDuoc(int maBanBaoCao)throws RemoteException{
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