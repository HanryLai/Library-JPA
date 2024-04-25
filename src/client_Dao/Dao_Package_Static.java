package client_Dao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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


public class Dao_Package_Static {

    public static BanBaoCao_Dao dao_BanBaoCao;
    public static CaLamViec_Dao dao_CaLamViec;
    public static ChiTietBaoCao_Dao dao_ChiTietBaoCao;
    public static ChiTietHoaDon_Dao dao_ChiTietHoaDon;
    public static ChiTietHoaDonDoi_Dao dao_ChiTietHoaDonDoi;
    public static ChiTietHoaDonHoanTra_Dao dao_ChiTietHoaDonHoanTra;
    public static HoaDon_Dao dao_HoaDon;
    public static HoaDonDoiHang_Dao dao_HoaDonDoiHang;
    public static HoaDonHoanTra_Dao dao_HoaDonHoanTra;
    public static KhachHang_Dao dao_KhachHang;
    public static MauSac_Dao dao_MauSac;
    public static NhaCungCap_Dao dao_NhaCungCap;
    public static NhanVien_Dao dao_NhanVien;
    public static NhomSanPham_Dao dao_NhomSanPham;
    public static Sach_Dao dao_Sach;
    public static SanPham_Dao dao_SanPham;
    public static TaiKhoan_Dao dao_TaiKhoan;
    public static ThongKe_Dao dao_ThongKe;
    public static VanPhongPham_Dao dao_VanPhongPham;
    
    public static String serverName;

    public static void init(String sever) throws MalformedURLException, NotBoundException, RemoteException {
    	serverName = sever;
    	
    	dao_BanBaoCao = (BanBaoCao_Dao) Naming.lookup(serverName +"BanBaoCao");
    	dao_CaLamViec = (CaLamViec_Dao) Naming.lookup(serverName +"CaLamViec");
    	dao_ChiTietBaoCao = (ChiTietBaoCao_Dao) Naming.lookup(serverName +"ChiTietBaoCao");
    	dao_ChiTietHoaDon = (ChiTietHoaDon_Dao) Naming.lookup(serverName +"ChiTietHoaDon");
    	dao_ChiTietHoaDonDoi = (ChiTietHoaDonDoi_Dao) Naming.lookup(serverName +"ChiTietHoaDonDoi");
    	dao_ChiTietHoaDonHoanTra = (ChiTietHoaDonHoanTra_Dao) Naming.lookup(serverName +"ChiTietHoaDonHoanTra");
    	dao_HoaDon = (HoaDon_Dao) Naming.lookup(serverName +"HoaDon");
    	dao_HoaDonDoiHang = (HoaDonDoiHang_Dao) Naming.lookup(serverName +"HoaDonDoiHang");
    	dao_HoaDonHoanTra = (HoaDonHoanTra_Dao) Naming.lookup(serverName +"HoaDonHoanTra");
    	dao_KhachHang = (KhachHang_Dao) Naming.lookup(serverName +"KhachHang");
    	dao_MauSac = (MauSac_Dao) Naming.lookup(serverName +"MauSac");
    	dao_NhaCungCap = (NhaCungCap_Dao) Naming.lookup(serverName +"NhaCungCap");
    	dao_NhanVien = (NhanVien_Dao) Naming.lookup(serverName +"NhanVien");
    	dao_NhomSanPham = (NhomSanPham_Dao) Naming.lookup(serverName +"NhomSanPham");
    	dao_Sach = (Sach_Dao) Naming.lookup(serverName +"Sach");
    	dao_SanPham = (SanPham_Dao) Naming.lookup(serverName +"SanPham");
    	dao_TaiKhoan = (TaiKhoan_Dao) Naming.lookup(serverName +"TaiKhoan");
    	dao_ThongKe = (ThongKe_Dao) Naming.lookup(serverName +"ThongKe");
    	dao_VanPhongPham = (VanPhongPham_Dao) Naming.lookup(serverName +"VanPhongPham");
    }


}