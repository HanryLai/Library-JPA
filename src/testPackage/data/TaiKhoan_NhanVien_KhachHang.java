package testPackage.data;

import entityJPA.CaLamViec;
import entityJPA.ChucVu;
import entityJPA.NhanVien;
import entityJPA.TaiKhoan;
import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.sql.Time;
import java.time.LocalDate;

public class TaiKhoan_NhanVien_KhachHang {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactory_Static.getEntityManagerFactory().createEntityManager();
        // TaiKhoan
        TaiKhoan taiKhoan1 = new TaiKhoan("nguyentanloc1108", "1234", "nguyentanloc1108@gmail.com");
        TaiKhoan taiKhoan2 = new TaiKhoan("phunganhminh", "5678", "phunganhminh@gmail.com");
        TaiKhoan taiKhoan3 = new TaiKhoan("tranthithuyvy", "1111", "tranthithuyvy@gmail.com");
        TaiKhoan taiKhoan4 = new TaiKhoan("laiduongminhhieu", "2222", "laiduongminhhieu@gmail.com");
        // CaLamViec
        CaLamViec ca1 = new CaLamViec("Sáng", new Time(6,0,0), new Time(11,59,59));
        CaLamViec ca2 = new CaLamViec("Chiều", new Time(12,0,0), new Time(17,59,59));
        CaLamViec ca3 = new CaLamViec("Tối", new Time(18,0,0), new Time(22,0,0));
        // NhanVien
        NhanVien nhanVien1 = new NhanVien("Nguyễn Tấn Lộc", LocalDate.of(2003, 12, 4),
                "0123456789", "Nam", "nguyentanloc1108@gmail.com", taiKhoan1, 1, ca1, ChucVu.QUANLY);
        NhanVien nhanVien2 = new NhanVien("Phùng Anh Minh", LocalDate.of(2003, 1, 1),
                "0987654321", "Nam", "phunganhminh@gmail.com", taiKhoan1, 1, ca1, ChucVu.QUANLY);
        NhanVien nhanVien3 = new NhanVien("Trần Thị Thúy Vy", LocalDate.of(2003, 1, 1),
                "0123456789", "Nam", "tranthithuyvy@gmail.com", taiKhoan1, 1, ca2, ChucVu.QUANLY);
        NhanVien nhanVien4 = new NhanVien("Lại Dương Minh Hiếu", LocalDate.of(2003, 1, 1),
                "0123456789", "Nam", "laiduongminhhieu@gmail.com", taiKhoan1, 1, ca3, ChucVu.QUANLY);
        // KhachHang


        em.getTransaction().begin();
        // TaiKhoan
        em.persist(taiKhoan1);
        em.persist(taiKhoan2);
        em.persist(taiKhoan3);
        em.persist(taiKhoan4);
        // CaLamViec
        em.persist(ca1);
        em.persist(ca2);
        em.persist(ca3);
        // NhanVien
        em.persist(nhanVien1);
        em.persist(nhanVien2);
        em.persist(nhanVien3);
        em.persist(nhanVien4);
        // KhachHang

        em.getTransaction().commit();
        em.close();
    }
}
