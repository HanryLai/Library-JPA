package testPackage.implement;

import dao.impl.ChiTietBanBaoCao_Impl;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class ChiTietBanBaoCao_Test_Implement {
    public static void main(String[] args) throws RemoteException {
        ChiTietBanBaoCao_Impl chiTietBanBaoCao_impl = new ChiTietBanBaoCao_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        System.out.println(chiTietBanBaoCao_impl.getSachDaBan(1, LocalDateTime.now().toString(), LocalDateTime.now().toString()));
    }
}
