package testPackage.data;

import entityJPA.*;
import entityJPA.otherID.ChiTietBanBaoCaoID;
import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import dao.impl.Sach_Impl;
import dao.impl.TaiKhoan_Impl;
import dao.impl.VanPhongPham_Impl;

public class SanPham_BaoCao_ChiTiet {
	public static void main(String[] args) throws RemoteException {
		
		EntityManager em = EntityManagerFactory_Static.getEntityManagerFactory().createEntityManager();

		MauSac mauSac = new MauSac();
		mauSac.setTenMau("Màu đỏ");

		MauSac mauSac2 = new MauSac();
		mauSac2.setTenMau("Màu xanh");

		NhomSanPham nhomSanPham = new NhomSanPham();
		nhomSanPham.setTenNhomSanPham("Sách");

		NhomSanPham nhomSanPham2 = new NhomSanPham();
		nhomSanPham2.setTenNhomSanPham("Dụng cụ học sinh");

		NhomSanPham nhomSanPham3 = new NhomSanPham();
		nhomSanPham3.setTenNhomSanPham("Văn phòng phẩm");

		NhomSanPham nhomSanPham4 = new NhomSanPham();
		nhomSanPham4.setTenNhomSanPham("SGK");

		NhomSanPham nhomSanPham5 = new NhomSanPham();
		nhomSanPham5.setTenNhomSanPham("Truyện");



		NhaCungCap nhaCungCap = EntityManagerFactory_Static.entityManagerFactory.createEntityManager().find(NhaCungCap.class, 1);
		NhaCungCap nhaCungCap2 = EntityManagerFactory_Static.entityManagerFactory.createEntityManager().find(NhaCungCap.class, 2);


		VanPhongPham vpp = new VanPhongPham();



		vpp.setTenSanPham("Văn phòng phẩm mẫu1");
		vpp.setSoLuongTon(100);
		vpp.setDonGiaNhap(15000);
		vpp.setMoTa("Văn phòng phẩm mẫu cho dự án");
		vpp.setTinhTrang("Còn hàng");
		vpp.setDonGiaBan(20000);
		vpp.setVAT(0.1);
		vpp.setNgayTao(LocalDateTime.now());
		vpp.setGiamGia(0.1);
		vpp.setMauSac(mauSac);
		vpp.setNoiSanXuat("Việt Nam");
		vpp.setNhomSanPham(nhomSanPham3);
		vpp.setNhaCungCap(nhaCungCap);



		VanPhongPham vpp2 = new VanPhongPham();
		vpp2.setTenSanPham("Văn phòng phẩm mẫu2");
		vpp2.setSoLuongTon(100);
		vpp2.setDonGiaNhap(15000);
		vpp2.setMoTa("Văn phòng phẩm mẫu cho dự án 2");
		vpp2.setTinhTrang("Còn hàng");
		vpp2.setDonGiaBan(30000);
		vpp2.setVAT(0.2);
		vpp2.setNgayTao(LocalDateTime.now());
		vpp2.setGiamGia(0.1);
		vpp2.setMauSac(mauSac2);
		vpp2.setNoiSanXuat("Việt Nam");
		vpp2.setNhomSanPham(nhomSanPham3);
		vpp2.setNhaCungCap(nhaCungCap2);




		Sach sach = new Sach();
    
		sach.setTenSanPham("Sách mẫu1");
		sach.setSoLuongTon(100);
		sach.setDonGiaNhap(15000);
		sach.setMoTa("Sách mẫu cho dự án");
		sach.setTinhTrang("Còn hàng");
		sach.setDonGiaBan(20000);
		sach.setVAT(0.1);
		sach.setNgayTao(LocalDateTime.now());
		sach.setGiamGia(0.1);
		sach.setTacGia("Nguyễn Văn A");
		sach.setNamXuatBan(2022);
		sach.setNhaSanXuat("Nhà xuất bản A");
		sach.setSoTrang(100);
		sach.setNhomSanPham(nhomSanPham);
		sach.setNhaCungCap(nhaCungCap);

		Sach sach2 = new Sach();
		sach2.setTenSanPham("Sách mẫu2");
		sach2.setSoLuongTon(100);
		sach2.setDonGiaNhap(15000);
		sach2.setMoTa("Sách mẫu cho dự án 2");
		sach2.setTinhTrang("Còn hàng");
		sach2.setDonGiaBan(30000);
		sach2.setVAT(0.2);
		sach2.setNgayTao(LocalDateTime.now());
		sach2.setGiamGia(0.1);
		sach2.setTacGia("Nguyễn Văn B");
		sach2.setNamXuatBan(2023);
		sach2.setNhaSanXuat("Nhà xuất bản B");
		sach2.setSoTrang(200);
		sach2.setNhomSanPham(nhomSanPham);
		sach2.setNhaCungCap(nhaCungCap);


		BanBaoCao banBaoCao = new BanBaoCao();
		banBaoCao.setTenBanBaoCao("Báo cáo tháng 1");
		banBaoCao.setTenNhanVien("Nguyễn Văn A");
		banBaoCao.setDoanhThu(1000000);
		banBaoCao.setThoiGianBaoCao("01/01/2022");

		BanBaoCao banBaoCao2 = new BanBaoCao();
		banBaoCao2.setTenBanBaoCao("Báo cáo tháng 2");
		banBaoCao2.setTenNhanVien("Nguyễn Văn B");
		banBaoCao2.setDoanhThu(2000000);
		banBaoCao2.setThoiGianBaoCao("01/02/2022");




		ChiTietBanBaoCao chiTietBanBaoCao = new ChiTietBanBaoCao();
		chiTietBanBaoCao.setId(new ChiTietBanBaoCaoID(1, 1));
		chiTietBanBaoCao.setSoLuongBan(10);
		chiTietBanBaoCao.setThanhTien(100000);
		chiTietBanBaoCao.setSoLuongNhap(20);
		chiTietBanBaoCao.setTonKho(30);
		chiTietBanBaoCao.setGhiChu("Ghi chú 1");

		ChiTietBanBaoCao chiTietBanBaoCao2 = new ChiTietBanBaoCao();
		chiTietBanBaoCao2.setId(new ChiTietBanBaoCaoID(2, 1));
		chiTietBanBaoCao2.setSoLuongBan(10);
		chiTietBanBaoCao2.setThanhTien(100000);
		chiTietBanBaoCao2.setSoLuongNhap(20);
		chiTietBanBaoCao2.setTonKho(30);
		chiTietBanBaoCao2.setGhiChu("Ghi chú 2");

		ChiTietBanBaoCao chiTietBanBaoCao3 = new ChiTietBanBaoCao();
		chiTietBanBaoCao3.setId(new ChiTietBanBaoCaoID(1, 2));
		chiTietBanBaoCao3.setSoLuongBan(10);
		chiTietBanBaoCao3.setThanhTien(100000);
		chiTietBanBaoCao3.setSoLuongNhap(20);
		chiTietBanBaoCao3.setTonKho(30);
		chiTietBanBaoCao3.setGhiChu("Ghi chú 3");

		ChiTietBanBaoCao chiTietBanBaoCao4 = new ChiTietBanBaoCao();
		chiTietBanBaoCao4.setId(new ChiTietBanBaoCaoID(2, 2));
		chiTietBanBaoCao4.setSoLuongBan(10);
		chiTietBanBaoCao4.setThanhTien(100000);
		chiTietBanBaoCao4.setSoLuongNhap(20);
		chiTietBanBaoCao4.setTonKho(30);



		em.getTransaction().begin();

		em.persist(nhomSanPham);
		em.persist(nhomSanPham2);
		em.persist(nhomSanPham3);
		em.persist(nhomSanPham4);


		em.persist(mauSac);
		em.persist(mauSac2);

		em.persist(vpp);
		em.persist(sach);
		em.persist(vpp2);
		em.persist(sach2);

		
		em.getTransaction().commit();

		em.close();

	}
}
