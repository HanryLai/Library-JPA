package testPackage.implement;

import entityJPA.BanBaoCao;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

import dao.impl.BanBaoCao_Impl;

public class BanBaoCao_Test_Implement {
    public static void main(String[] args) throws RemoteException {
        BanBaoCao_Impl dao = new BanBaoCao_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//getALLBanBaoCao
        dao.getALLBanBaoCao().forEach(x -> {
            System.out.println(x.toString());
        });
//getMaBBCTheoTen
        System.out.println(dao.getMaBBCTheoTen("Báo cáo tháng 12"));
//taoBanBaoCao
        BanBaoCao entity = new BanBaoCao();
        entity.setTenBanBaoCao("Báo cáo tháng 3");
        entity.setDoanhThu(1000000);
        entity.setThoiGianBaoCao("2021-03-01");

        System.out.println(dao.taoBanBaoCao(entity));
//PASS
    }
}
