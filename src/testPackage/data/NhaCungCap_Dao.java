package testPackage.data;

import entityJPA.NhaCungCap;
import entityJPA.Sach;
import entityJPA.SanPham;
import entityJPA.VanPhongPham;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.impl.Generic_Impl;
import dao.impl.NhaCungCap_Impl;

public class NhaCungCap_Dao {
    public static void main(String[] args) throws Exception {
        NhaCungCap_Impl ncc = new NhaCungCap_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        // save ncc
        List<SanPham> sachs = new ArrayList<>();
        Generic_Impl<Sach> sachGeneric = new Generic_Impl<>(Sach.class, EntityManagerFactory_Static.getEntityManagerFactory());
        for (Sach sach : sachGeneric.findAll()) {
            sachs.add(sach);
        }
        NhaCungCap ncc1 = new NhaCungCap();
        ncc1.setTenNCC("Nha cung cap 1");
        ncc1.setDiaChiNCC("Dia chi nha cung cap 1");
        ncc1.setSoDienThoai("0123456789");
        ncc1.setEmail("àd");
        ncc1.setGhiChu("Ghi chu nha cung cap 1");
        ncc1.setSanPhams(sachs);
        ncc.themNhaCungCap(ncc1);

        // data 2
        List<SanPham> vpps = new ArrayList<>();
        Generic_Impl<VanPhongPham> vppGeneric = new Generic_Impl<>(VanPhongPham.class, EntityManagerFactory_Static.getEntityManagerFactory());
        for (VanPhongPham vpp : vppGeneric.findAll()) {
            vpps.add(vpp);
        }
        NhaCungCap ncc2 = new NhaCungCap();
        ncc2.setTenNCC("Nha cung cap 2");
        ncc2.setDiaChiNCC("Dia chi nha cung cap 2");
        ncc2.setSoDienThoai("012345632");
        ncc2.setEmail("àd");
        ncc2.setGhiChu("Ghi chu nha cung cap 2");
        ncc2.setSanPhams(vpps);
        ncc.themNhaCungCap(ncc2);
    }
}
