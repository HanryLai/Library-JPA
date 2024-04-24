package testPackage.implement;

import dao.impl.ChiTietBanBaoCao_Impl;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class ChiTietBanBaoCao_Test_Implement {
    public static void main(String[] args) throws RemoteException {
        ChiTietBanBaoCao_Impl chiTietBanBaoCao_impl = new ChiTietBanBaoCao_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        System.out.println(chiTietBanBaoCao_impl.getSachDaBan(1,
//                LocalDateTime.of(2024, 04, 24, 0, 0, 0).toString(),
//                LocalDateTime.of(2024, 05, 24, 0, 0, 0).toString()));

//        System.out.println(chiTietBanBaoCao_impl.getVPPDaBan(1,
//                LocalDateTime.of(2024, 04, 24, 0, 0, 0).toString(),
//                LocalDateTime.of(2024, 05, 24, 0, 0, 0).toString()));

//        System.out.println(chiTietBanBaoCao_impl.getTinhTrangNhapSach(LocalDateTime.of(2024, 04, 24, 0, 0, 0).toString()));
//        System.out.println(chiTietBanBaoCao_impl.getTinhTrangNhapVPP(LocalDateTime.of(2024, 04, 24, 0, 0, 0).toString()));

//        System.out.println(chiTietBanBaoCao_impl.getDoanhThuTheoCa(1, LocalDateTime.of(2024, 05, 24, 0, 0, 0).toString(),
//                LocalDateTime.of(2024, 05, 24, 0, 0, 0).toString()));

//        System.out.println(chiTietBanBaoCao_impl.getChiTietBanBaoCao(1));
//        System.out.println(chiTietBanBaoCao_impl.getDoanhThuCaNgay(1));
//        System.out.println(chiTietBanBaoCao_impl.getTongSanPhamBanDuoc(1));
//        System.out.println(chiTietBanBaoCao_impl.getDoanhThuTheoTenBC("Báo cáo tháng 1"));
    }
}
