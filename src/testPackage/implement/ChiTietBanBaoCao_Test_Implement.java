package testPackage.implement;

import dao.impl.ChiTietBanBaoCao_Impl;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class ChiTietBanBaoCao_Test_Implement {
    public static void main(String[] args) throws RemoteException {
        ChiTietBanBaoCao_Impl chiTietBanBaoCao_impl = new ChiTietBanBaoCao_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        System.out.println(chiTietBanBaoCao_impl.getTinhTrangNhapSach(LocalDateTime.of(2022, 1, 1, 0, 0, 0), LocalDateTime.of(2022, 1, 2, 0, 0, 0)));

    }
}
