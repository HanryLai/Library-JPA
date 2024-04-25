package testPackage.data;

import dao.Interface.BanBaoCao_Dao;
import dao.impl.BanBaoCao_Impl;
import entityJPA.BanBaoCao;
import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;

public class BanBaoCao_Data {
    public static void main(String[] args) {
        BanBaoCao banbaocao = new BanBaoCao();
        banbaocao.setTenBanBaoCao("Ban bao cao 1");
        banbaocao.setTenNhanVien("Nguyen Tan Loc");
        banbaocao.setThoiGianBaoCao("2021-10-10");
        banbaocao.setDoanhThu(1000000);
//        banbaocao.set

    }
}
