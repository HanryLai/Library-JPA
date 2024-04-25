package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;

import dao.Interface.BanBaoCao_Dao;
import dao.Interface.CaLamViec_Dao;
import dao.Interface.ChiTietBaoCao_Dao;
import dao.Interface.ChiTietHoaDonDoi_Dao;
import dao.Interface.ChiTietHoaDonHoanTra_Dao;
import dao.Interface.ChiTietHoaDon_Dao;
import dao.Interface.HoaDonDoiHang_Dao;
import dao.Interface.HoaDonHoanTra_Dao;
import dao.Interface.HoaDon_Dao;
import dao.Interface.KhachHang_Dao;
import dao.Interface.MauSac_Dao;
import dao.Interface.NhaCungCap_Dao;
import dao.Interface.NhanVien_Dao;
import dao.Interface.NhomSanPham_Dao;
import dao.Interface.Sach_Dao;
import dao.Interface.SanPham_Dao;
import dao.Interface.TaiKhoan_Dao;
import dao.Interface.ThongKe_Dao;
import dao.Interface.VanPhongPham_Dao;
import dao.impl.BanBaoCao_Impl;
import dao.impl.CaLamViec_Impl;
import dao.impl.ChiTietBanBaoCao_Impl;
import dao.impl.ChiTietHoaDonDoi_Impl;
import dao.impl.ChiTietHoaDonHoanTra_Impl;
import dao.impl.ChiTietHoaDon_Impl;
import dao.impl.HoaDonDoiHang_Impl;
import dao.impl.HoaDonHoanTra_Impl;
import dao.impl.HoaDon_Impl;
import dao.impl.KhachHang_Impl;
import dao.impl.MauSac_Impl;
import dao.impl.NhaCungCap_Impl;
import dao.impl.NhanVien_Impl;
import dao.impl.NhomSanPham_Impl;
import dao.impl.Sach_Impl;
import dao.impl.SanPham_Impl;
import dao.impl.TaiKhoan_Impl;
import dao.impl.ThongKe_Impl;
import dao.impl.VanPhongPham_Impl;
import untils.entityManagerFactory.EntityManagerFactory_Static;


public class Server {
    public static String localHost = "rmi://26.139.190.148:7878/";
    public static void main(String[] args) throws
                                           NamingException,
                                           RemoteException,
                                           MalformedURLException,
                                           AlreadyBoundException {

        BanBaoCao_Dao dao_BanBaoCao = new BanBaoCao_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        CaLamViec_Dao dao_CaLamViec = new CaLamViec_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietBaoCao_Dao dao_ChiTietBaoCao = new ChiTietBanBaoCao_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDon_Dao dao_ChiTietHoaDon = new ChiTietHoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDonDoi_Dao dao_ChiTietHoaDonDoi = new ChiTietHoaDonDoi_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ChiTietHoaDonHoanTra_Dao dao_ChiTietHoaDonHoanTra = new ChiTietHoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDon_Dao dao_HoaDon = new HoaDon_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonDoiHang_Dao dao_HoaDonDoiHang = new HoaDonDoiHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        HoaDonHoanTra_Dao dao_HoaDonHoanTra = new HoaDonHoanTra_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        KhachHang_Dao dao_KhachHang = new KhachHang_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        MauSac_Dao dao_MauSac = new MauSac_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        NhaCungCap_Dao dao_NhaCungCap = new NhaCungCap_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        NhanVien_Dao dao_NhanVien = new NhanVien_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        NhomSanPham_Dao dao_NhomSanPham = new NhomSanPham_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        Sach_Dao dao_Sach = new Sach_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        SanPham_Dao dao_SanPham = new SanPham_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        TaiKhoan_Dao dao_TaiKhoan = new TaiKhoan_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        ThongKe_Dao dao_ThongKe = new ThongKe_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        VanPhongPham_Dao dao_VanPhongPham = new VanPhongPham_Impl(EntityManagerFactory_Static.getEntityManagerFactory());



        LocateRegistry.createRegistry(7878);

        Naming.bind(localHost + "BanBaoCao", dao_BanBaoCao);
        Naming.bind(localHost + "CaLamViec", dao_CaLamViec);
        Naming.bind(localHost + "ChiTietBaoCao", dao_ChiTietBaoCao);
        Naming.bind(localHost + "ChiTietHoaDon", dao_ChiTietHoaDon);
        Naming.bind(localHost + "ChiTietHoaDonDoi", dao_ChiTietHoaDonDoi);
        Naming.bind(localHost + "ChiTietHoaDonHoanTra", dao_ChiTietHoaDonHoanTra);
        Naming.bind(localHost + "HoaDon", dao_HoaDon);
        Naming.bind(localHost + "HoaDonDoiHang", dao_HoaDonDoiHang);
        Naming.bind(localHost + "HoaDonHoanTra", dao_HoaDonHoanTra);
        Naming.bind(localHost + "KhachHang", dao_KhachHang);
        Naming.bind(localHost + "MauSac", dao_MauSac);
        Naming.bind(localHost + "NhaCungCap", dao_NhaCungCap);
        Naming.bind(localHost + "NhanVien", dao_NhanVien);
        Naming.bind(localHost + "NhomSanPham", dao_NhomSanPham);
        Naming.bind(localHost + "Sach", dao_Sach);
        Naming.bind(localHost + "SanPham", dao_SanPham);
        Naming.bind(localHost + "TaiKhoan", dao_TaiKhoan);
        Naming.bind(localHost + "ThongKe", dao_ThongKe);
        Naming.bind(localHost + "VanPhongPham", dao_VanPhongPham);




        System.out.println("Server is runing");
    }
}
