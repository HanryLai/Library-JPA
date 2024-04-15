package entityJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;



public class MainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-mssql");
//		Persistence.createEntityManagerFactory("jpa-mssql");
		
		EntityManager em = emf.createEntityManager();

		VanPhongPham vpp = new VanPhongPham("Bút bi", null, null, 100, 10000, "Bút bi đen", "Còn hàng", 15000, 0.1, null, 0, null, "Việt Nam");
		VanPhongPham vpp2 = new VanPhongPham("Bút bi", null, null, 100, 10000, "Bút bi đen", "Còn hàng", 15000, 0.1, null, 0, null, "Việt Nam");

		Sach sachMau = new Sach(
				"Sách mẫu", // tenSanPham
				null, // nhomSanPham
				null, // nhaCungCap
				100, // soLuongTon
				50000, // donGiaNhap
				"Sách mẫu cho dự án", // moTa
				"Còn hàng", // tinhTrang
				60000, // donGiaBan
				0.1, // VAT
				LocalDateTime.now(), // ngayTao
				0, // giamGia
				"Tác giả mẫu", // tacGia
				2022, // namXuatBan
				"Nhà xuất bản mẫu", // nhaSanXuat
				200 // soTrang
		);

		Sach sachMau2 = new Sach(
				"Sách mẫu", // tenSanPham
				null, // nhomSanPham
				null, // nhaCungCap
				100, // soLuongTon
				50000, // donGiaNhap
				"Sách mẫu cho dự án", // moTa
				"Còn hàng", // tinhTrang
				60000, // donGiaBan
				0.1, // VAT
				LocalDateTime.now(), // ngayTao
				0, // giamGia
				"Tác giả mẫu", // tacGia
				2022, // namXuatBan
				"Nhà xuất bản mẫu", // nhaSanXuat
				200 // soTrang
		);

		BanBaoCao banBaoCao = new BanBaoCao("Báo cáo tháng 1", "Nguyễn Văn A", 1000000, "01/01/2022");
		BanBaoCao banBaoCao2 = new BanBaoCao("Báo cáo tháng 2", "Nguyễn Văn B", 2000000, "01/02/2022");

		em.getTransaction().begin();
		em.persist(vpp);
		em.persist(sachMau);
		em.persist(vpp2);
		em.persist(sachMau2);


		em.persist(banBaoCao);
//		Create ChiTietBanBaoCao

		ChiTietBanBaoCao chiTietBanBaoCao = new ChiTietBanBaoCao(banBaoCao, vpp, 100, 15000, 50, 50, "Ghi chú");
		ChiTietBanBaoCao chiTietBanBaoCao2 = new ChiTietBanBaoCao(banBaoCao, vpp2, 100, 15000, 50, 50, "Ghi chú");

		ChiTietBanBaoCao chiTietBanBaoCao3 = new ChiTietBanBaoCao(banBaoCao, sachMau, 100, 60000, 50, 50, "Ghi chú");
		ChiTietBanBaoCao chiTietBanBaoCao4 = new ChiTietBanBaoCao(banBaoCao, sachMau2, 100, 60000, 50, 50, "Ghi chú");

		em.persist(chiTietBanBaoCao);
		em.persist(chiTietBanBaoCao2);
		em.persist(chiTietBanBaoCao3);
		em.persist(chiTietBanBaoCao4);


		em.getTransaction().commit();

		em.close();


//		DO NOT CLOSE
//		emf.close();
	}
}
