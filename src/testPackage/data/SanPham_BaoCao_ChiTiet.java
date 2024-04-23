package testPackage.data;

import dao.impl.Sach_Impl;
import dao.impl.TaiKhoan_Impl;
import dao.impl.VanPhongPham_Impl;
import entityJPA.*;
import entityJPA.otherID.ChiTietBanBaoCaoID;
import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class SanPham_BaoCao_ChiTiet {
	public static void main(String[] args) throws RemoteException {
		
		EntityManager em = EntityManagerFactory_Static.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		MauSac mauSac = new MauSac();
		mauSac.setTenMau("Màu đỏ");


		MauSac mauSac2 = new MauSac();
		mauSac2.setTenMau("Màu xanh");



		VanPhongPham vanPhongPham = new VanPhongPham();
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


		em.getTransaction().begin();

		em.persist(mauSac);
		em.persist(mauSac2);

		em.persist(vpp);
		em.persist(sach);
		em.persist(vpp2);
		em.persist(sach2);


		em.persist(banBaoCao);
		em.persist(banBaoCao2);


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


		em.persist(chiTietBanBaoCao);
		em.persist(chiTietBanBaoCao2);
		em.persist(chiTietBanBaoCao3);
		em.persist(chiTietBanBaoCao4);
		
		em.getTransaction().commit();

		ChiTietBanBaoCaoID id = new ChiTietBanBaoCaoID(1, 1);

		ChiTietBanBaoCao t = em.find(ChiTietBanBaoCao.class, id);


		em.close();

//		DO NOT CLOSE
//		emf.close();
	}
}
