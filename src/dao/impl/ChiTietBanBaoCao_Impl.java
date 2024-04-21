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
    private EntityManagerFactory emf;
    private EntityManager em;
    private GenericImpl<ChiTietBanBaoCao> generic;
    public ChiTietBanBaoCao_Impl() throws Exception {
        super();
        emf = Persistence.createEntityManagerFactory("jpa-mssql");
        em = emf.createEntityManager();
        generic = new GenericImpl<>(ChiTietBanBaoCao.class);
    }

    public void openEM(){
        em = emf.createEntityManager();
    }

    public void closeEM(){
        em.close();
    }

    @Override
    public void open() throws RemoteException {
        generic.open();
    }

    @Override
    public void close() throws RemoteException {
        generic.close();
    }

    @Override
    public boolean save(ChiTietBanBaoCao obj) throws RemoteException {
        return generic.save(obj);
    }

    @Override
    public boolean update(ChiTietBanBaoCao obj) throws RemoteException {
        return generic.update(obj);
    }

    @Override
    public boolean delete(Object id) throws RemoteException {
        return generic.delete(id);
    }

    @Override
    public ChiTietBanBaoCao findById(Object id) throws RemoteException {
        return generic.findById(id);
    }

    @Override
    public List<ChiTietBanBaoCao> findAll() throws RemoteException {
        return generic.findAll();
    }

    @Override
    public List<ChiTietBanBaoCao> findByProperty(String property, Object value) throws RemoteException {
        return generic.findByProperty(property, value);
    }

    public ArrayList<ChiTietBanBaoCao> getSachDaBan (int maHD, String thoiGianBatDau, String thoiGianKetThuc){
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql   = "select s.maSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien\n" +
                    "from Sach s\n" +
                    "inner join ChiTietHoaDon ct on ct.sanPham = s.maSanPham\n" +
                    "inner join HoaDon hd on hd.maHoaDon = ct.hoaDon\n" +
                    "where hoaDon like ? and (ngayLap >= ? and ngayLap < ?)\n" +
                    "group by s.maSanPham";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maHD);
        query.setParameter(2, thoiGianBatDau);
        query.setParameter(3, thoiGianKetThuc);

        List<Object[]> result = query.getResultList();
        for (Object[] obj : result){
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();
            openEM();
            SanPham sanPham = em.find(SanPham.class, (int) obj[0]);
            closeEM();

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) obj[1]);
            ct.setThanhTien((double) obj[2]);
            ct.setGhiChu("");

            list.add(ct);
        }
        return list;
    }

    public ArrayList<ChiTietBanBaoCao> getVPPDaBan (int maHD, String thoiGianBatDau, String thoiGianKetThuc){
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql   = "select v.maSanPham, sum(ct.soLuong) as soLuong, sum(thanhTien) as thanhTien  \n" +
                "  from VanPhongPham v\n" +
                "inner join ChiTietHoaDon ct on ct.sanPham = v.maSanPham\n" +
                "inner join HoaDon hd on hd.maHoaDon = ct.hoaDon\n" +
                "   where hoaDon like ? and (ngayLap >= ? and ngayLap < ?)\n" +
                "  group by v.maSanPham";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maHD);
        query.setParameter(2, thoiGianBatDau);
        query.setParameter(3, thoiGianKetThuc);

        List<Object[]> result = query.getResultList();
        for (Object[] obj : result){
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();

            openEM();
            SanPham sanPham = em.find(SanPham.class, (int) obj[0]);
            closeEM();

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) obj[1]);
            ct.setThanhTien((double) obj[2]);
            ct.setGhiChu("");

            list.add(ct);
        }

        return list;
    }

//    FIX
    public ArrayList<ChiTietBanBaoCao> getTinhTrangNhapSach(String ngayTao){
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql =    "WITH CumulativeSumCTE AS (\n" +
                "SELECT\n" +
                "    tenSanPham,\n" +
                "    soLuongTon as soLuongNhap,\n" +
                "    ngayTao,\n" +
                "    SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon\n" +
                "FROM\n" +
                "    Sach\n" +
                ")\n" +
                "SELECT\n" +
                "    tenSanPham,\n" +
                "    MAX(soLuongNhap) AS soLuongNhap,\n" +
                "    MAX(CumulativeSoLuongTon) AS tonKho\n" +
                "FROM\n" +
                "    CumulativeSumCTE\n" +
                "WHERE\n" +
                "    CONVERT(DATE, ngayTao) = ?\n" +
                "GROUP BY\n" +
                "    tenSanPham;";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, ngayTao);

        List<Object[]> result = query.getResultList();
        for (Object[] obj : result){
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();

            openEM();
            SanPham sanPham = em.find(SanPham.class, (int) obj[0]);
            closeEM();

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) obj[1]);
            ct.setThanhTien((double) obj[2]);
            ct.setGhiChu("");

            list.add(ct);
        }

        return list;
    }

    public ArrayList<ChiTietBanBaoCao> getTinhTrangNhapVPP(String ngayTao){
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql =    "WITH CumulativeSumCTE AS (\n" +
                "SELECT\n" +
                "    tenSanPham,\n" +
                "    soLuongTon as soLuongNhap,\n" +
                "    ngayTao,\n" +
                "    SUM(soLuongTon) OVER (PARTITION BY tenSanPham ORDER BY ngayTao) AS CumulativeSoLuongTon\n" +
                "FROM\n" +
                "    VanPhongPham\n" +
                ")\n" +
                "SELECT\n" +
                "    tenSanPham,\n" +
                "    MAX(soLuongNhap) AS soLuongNhap,\n" +
                "    MAX(CumulativeSoLuongTon) AS tonKho\n" +
                "FROM\n" +
                "    CumulativeSumCTE\n" +
                "WHERE\n" +
                "    CONVERT(DATE, ngayTao) = ?\n" +
                "GROUP BY\n" +
                "    tenSanPham;";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, ngayTao);

        List<Object[]> result = query.getResultList();
        for (Object[] obj : result){
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();

            openEM();
            SanPham sanPham = em.find(SanPham.class, (int) obj[0]);
            closeEM();

            ct.setSanPham(sanPham);
            ct.setSoLuongBan((int) obj[1]);
            ct.setThanhTien((double) obj[2]);
            ct.setGhiChu("");

            list.add(ct);
        }

        return list;
    }

    public double getDoanhThuTheoCa(int maHD, String thoiGianBatDau, String thoiGianKetThuc){
        double doanhThu = 0;
        String sql =    "select sum(ThanhTien) as ThanhTien\n" +
                "from HoaDon hd\n" +
                "inner join ChiTietHoaDon cthd on hd.maHoaDon = cthd.hoaDon\n" +
                "inner join NhanVien nv on nv.maNhanVien = hd.nhanVien\n" +
                "where hd.maHoaDon like ? and (ngayLap >= ? and ngayLap < ?)\n" +
                "group by nv.caLamViec";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maHD);
        query.setParameter(2, thoiGianBatDau);
        query.setParameter(3, thoiGianKetThuc);

        List<Object> result = query.getResultList();
        for (Object obj : result){
            doanhThu += (double) obj;
        }

        return doanhThu;
    }

    public ArrayList<ChiTietBanBaoCao> getChiTietBanBaoCao(int maBanBaoCao){
        ArrayList<ChiTietBanBaoCao> list = new ArrayList<>();
        String sql =    "select * from ChiTietBanBaoCao where maBanBaoCao = ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maBanBaoCao);

        List<Object[]> result = query.getResultList();
        for (Object[] obj : result){
            ChiTietBanBaoCao ct = new ChiTietBanBaoCao();
            ct = (ChiTietBanBaoCao) obj[0];
            list.add(ct);
        }

        return list;
    }

    public double getDoanhThuCaNgay(String maBanBaoCao){
        double doanhThu = 0;
        String sql =    "select sum(ThanhTien) as ThanhTien\n" +
                "from ChiTietBanBaoCao\n" +
                "where maBanBaoCao like ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maBanBaoCao);

        List<Object> result = query.getResultList();
        for (Object obj : result){
            doanhThu += (double) obj;
        }
        return doanhThu;
    }

    public int getTongSanPhamBanDuoc(String maBanBaoCao){
        int soLuong = 0;
        String sql =    "select sum(SoLuongBan) as SoLuongBan\n" +
                "from ChiTietBanBaoCao\n" +
                "where maBanBaoCao like ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, maBanBaoCao);

        List<Object> result = query.getResultList();
        for (Object obj : result){
            soLuong += (int) obj;
        }
        return soLuong;
    }

    public double getDoanhThuTheoTenBC(String tenBanBaoCao){
        double doanhThu = 0;
        String sql =    "select doanhThu\n" +
                "from BanBaoCao\n" +
                "where tenBanBaoCao like ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, tenBanBaoCao);

        List<Object> result = query.getResultList();
        for (Object obj : result){
            doanhThu += (double) obj;
        }
        return doanhThu;
    }

}