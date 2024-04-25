package testPackage.implement;

import dao.Interface.ThongKe_Dao;
import dao.impl.ThongKe_Impl;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThongKe {
    public static void main(String[] args) throws RemoteException, ParseException {
        System.out.println("Test ThongKe");
        ThongKe_Dao thongKe_dao = new ThongKe_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
//        System.out.println(thongKe_dao.tongDoanhThu(2024));

//        String ngayBatDau = "01/01/2024";
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateBatDau = sdf.parse(ngayBatDau.trim());
//        System.out.println(dateBatDau);

        String ngaBatDau = "01/01/2004";
        String ngayKetThuc = "01/02/2025";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateBatDau = sdf.parse(ngaBatDau.trim());
        Date dateKetThuc = sdf.parse(ngayKetThuc.trim());

//        System.out.println(thongKe_dao.thongKeDoanhThu(dateBatDau, dateKetThuc));
//        System.out.println(thongKe_dao.thongKeSoHoaDon(dateBatDau, dateKetThuc));
//        System.out.println(thongKe_dao.thongKeSoHoaDonHoanTra(dateBatDau, dateKetThuc));
        System.out.println(thongKe_dao.tienHoanTheoThang());


    }
}
