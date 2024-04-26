package testPackage.data;

import dao.Interface.*;
import dao.impl.*;
import entityJPA.*;
import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class HoaDon_ChiTietHoaDon {
    public static void main(String[] args) throws RemoteException {
        EntityManager em = EntityManagerFactory_Static.getEntityManagerFactory().createEntityManager();

        HoaDon_Dao hd_dao = new HoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDon_Dao cthd_dao = new ChiTietHoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        Sach_Dao sach_dao = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        VanPhongPham_Dao vpp_dao = new VanPhongPham_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        NhanVien_Dao nv_dao = new NhanVien_Impl(EntityManagerFactory_Static.getEntityManagerFactory());


        KhachHang kh1 = em.find(KhachHang.class, 1);
        KhachHang kh2 = em.find(KhachHang.class, 2);
        KhachHang kh3 = em.find(KhachHang.class, 3);

        NhanVien nv1 = nv_dao.getNVTheoMa(1);
        NhanVien nv2 = nv_dao.getNVTheoMa(2);
        NhanVien nv3 = nv_dao.getNVTheoMa(3);

        SanPham sach1 = sach_dao.getSachtheoMa("2");
        SanPham sach2 = sach_dao.getSachtheoMa("4");
        SanPham vvp1 = vpp_dao.getVPPtheoMa("1");
        SanPham vvp2 = vpp_dao.getVPPtheoMa("3");

//        public HoaDon(LocalDateTime ngayLap, String ghiChu, int tinhTrangHoaDon, float tongTien, float chietKhau, String khuyenMai)
        HoaDon hd1 = new HoaDon();
        hd1.setNgayLap(LocalDateTime.now());
        hd1.setGhiChu("Ghi chú 1");
        hd1.setTinhTrangHoaDon(1);
        hd1.setTongTien(5500);
        hd1.setChietKhau(0);
        hd1.setKhuyenMai("Không");
        hd1.setKhachHang(kh1);
        hd1.setNhanVien(nv1);

        HoaDon hd2 = new HoaDon();
        hd2.setNgayLap(LocalDateTime.now());
        hd2.setGhiChu("Ghi chú 2");
        hd2.setTinhTrangHoaDon(1);
        hd2.setChietKhau(0);
        hd2.setKhuyenMai("Không");
        hd2.setKhachHang(kh2);
        hd2.setNhanVien(nv2);

        HoaDon hd3 = new HoaDon();
        hd3.setNgayLap(LocalDateTime.now());
        hd3.setGhiChu("Ghi chú 3");
        hd3.setTinhTrangHoaDon(1);
        hd3.setChietKhau(0);
        hd3.setKhuyenMai("Không");
        hd3.setKhachHang(kh3);
        hd3.setNhanVien(nv3);

//        hd_dao.createHoaDon(hd1);
//        hd_dao.createHoaDon(hd2);
//        hd_dao.createHoaDon(hd3);
//
//        ChiTietHoaDon cthd1_1 = new ChiTietHoaDon(hd1, sach1, 5, 100);
//        ChiTietHoaDon cthd1_2 = new ChiTietHoaDon(hd1, sach2, 10, 500);
//
//        ChiTietHoaDon cthd2_1 = new ChiTietHoaDon(hd2, vvp1, 5, 100);
//        ChiTietHoaDon cthd2_2 = new ChiTietHoaDon(hd2, vvp2, 10, 500);
//
//        ChiTietHoaDon cthd3_1 = new ChiTietHoaDon(hd3, sach1, 5, 100);
//        ChiTietHoaDon cthd3_2 = new ChiTietHoaDon(hd3, vvp2, 10, 500);
//
//        cthd_dao.createChiTietHoaDon(cthd1_1);
//        cthd_dao.createChiTietHoaDon(cthd1_2);
//
//        cthd_dao.createChiTietHoaDon(cthd2_1);
//        cthd_dao.createChiTietHoaDon(cthd2_2);
//
//        cthd_dao.createChiTietHoaDon(cthd3_1);
//        cthd_dao.createChiTietHoaDon(cthd3_2);









    }
}
