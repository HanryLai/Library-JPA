package entityJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.LockMode;

import java.time.LocalDateTime;

public class MainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-mssql");
//		Persistence.createEntityManagerFactory("jpa-mssql");
		
		EntityManager em = emf.createEntityManager();

		VanPhongPham vpp = new VanPhongPham();
		vpp.setTenSanPham("Văn phòng phẩm mẫu");
		vpp.setSoLuongTon(100);
		vpp.setDonGiaNhap(15000);
		vpp.setMoTa("Văn phòng phẩm mẫu cho dự án");
		vpp.setTinhTrang("Còn hàng");


		VanPhongPham vpp2 = new VanPhongPham();
		vpp2.setTenSanPham("Văn phòng phẩm mẫu 2");
		vpp2.setSoLuongTon(100);
		vpp2.setDonGiaNhap(15000);
		vpp2.setMoTa("Văn phòng phẩm mẫu cho dự án 2");
		vpp2.setTinhTrang("Còn hàng");



		Sach sach = new Sach();
		sach.setTenSanPham("Sách mẫu");
		sach.setSoLuongTon(100);
		sach.setDonGiaNhap(60000);
		sach.setMoTa("Sách mẫu cho dự án");
		sach.setTinhTrang("Còn hàng");

		Sach sach2 = new Sach();
		sach2.setTenSanPham("Sách mẫu 2");
		sach2.setSoLuongTon(100);
		sach2.setDonGiaNhap(60000);
		sach2.setMoTa("Sách mẫu cho dự án 2");
		sach2.setTinhTrang("Còn hàng");


		BanBaoCao banBaoCao = new BanBaoCao("Báo cáo tháng 1", "Nguyễn Văn A", 1000000, "01/01/2022");
		BanBaoCao banBaoCao2 = new BanBaoCao("Báo cáo tháng 2", "Nguyễn Văn B", 2000000, "01/02/2022");

		em.getTransaction().begin();
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

		ChiTietBanBaoCaoID id = new ChiTietBanBaoCaoID(1, 1);

		ChiTietBanBaoCao t = em.find(ChiTietBanBaoCao.class, id);
		System.out.println(t.toString());


		em.getTransaction().commit();

		em.close();


//		DO NOT CLOSE
//		emf.close();
	}
}
