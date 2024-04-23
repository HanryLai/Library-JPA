package dao.impl;

import dao.Interface.NhaCungCap_Dao;
import entityJPA.NhaCungCap;
import entityJPA.Sach;
import entityJPA.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCap_Impl extends UnicastRemoteObject implements NhaCungCap_Dao {
    private  final EntityManagerFactory emf;
    public NhaCungCap_Impl(EntityManagerFactory emf) throws Exception {
        super();
        this.emf = emf;
    }
    @Override
    public ArrayList<NhaCungCap> getALLNhaCungCap() throws Exception {
        Generic_Impl<NhaCungCap> ncc = new Generic_Impl<>(NhaCungCap.class, emf);
        return (ArrayList<NhaCungCap>) ncc.findAll();
    }

    @Override
    public NhaCungCap getNCCTheoMa(String maNCC) throws Exception {
        int intMNCC = Integer.parseInt(maNCC);
        Generic_Impl<NhaCungCap> nccGeneric = new Generic_Impl<>(NhaCungCap.class, emf);
        return nccGeneric.findById(intMNCC);

    }

    @Override
    public NhaCungCap getNCCTheoTen(String tenNCC) throws Exception {
        return null;
    }

    @Override
    public void themNhaCungCap(NhaCungCap ncc) throws Exception {
        Generic_Impl<NhaCungCap> nccGeneric = new Generic_Impl<>(NhaCungCap.class, emf);
        nccGeneric.save(ncc);

    }

    @Override
    public boolean updateNhaCungCap(String maSua, NhaCungCap nccMoi) throws Exception {
        Generic_Impl<NhaCungCap> nccGeneric = new Generic_Impl<>(NhaCungCap.class, emf);
        NhaCungCap nccCu = nccGeneric.findById(maSua);
        if (nccCu != null) {
            nccCu.setTenNCC(nccMoi.getTenNCC());
            nccCu.setDiaChiNCC(nccMoi.getDiaChiNCC());
            nccCu.setSoDienThoai(nccMoi.getSoDienThoai());
            nccCu.setEmail(nccMoi.getEmail());
            nccCu.setGhiChu(nccMoi.getGhiChu());
            nccCu.setSanPhams(nccMoi.getSanPhams());
            nccGeneric.update(nccCu);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<NhaCungCap> locNhaCungCap(String duLieuTim) throws Exception {
        EntityManager em = emf.createEntityManager();
        String query = "select maNCC, tenNCC, diaChiNCC, soDienThoai, email, ghiChu from NhaCungCap\n" +
                "where maNCC like ? or \n" +
                "tenNCC like ? or\n" +
                "diachiNCC like ? or\n" +
                "soDienThoai like ? or\n" +
                "email like ? or\n" +
                "ghiChu like ?";
        List<NhaCungCap> ncc = em.createNativeQuery(query, NhaCungCap.class)
                .setParameter(1, "%"+duLieuTim+"%")
                .setParameter(2,"%"+ duLieuTim+"%")
                .setParameter(3,"%"+ duLieuTim+"%")
                .setParameter(4, "%"+duLieuTim+"%")
                .setParameter(5,"%"+ duLieuTim+"%")
                .setParameter(6,"%"+ duLieuTim+"%")
                .getResultList();
        return (ArrayList<NhaCungCap>) ncc;
    }

    @Override
    public String getMaNhaCungCapDB() throws Exception {
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("NhaCungCap.getMaNhaCungCapDB", String.class).getSingleResult().toString();
    }

    public static void main(String[] args) throws Exception {
        NhaCungCap_Impl ncc = new NhaCungCap_Impl(EntityManagerFactory_Static.getEntityManagerFactory());
        // save ncc
//        List<SanPham> sachs = new ArrayList<>();
//        Generic_Impl<Sach> sachGeneric = new Generic_Impl<>(Sach.class, EntityManagerFactory_Static.getEntityManagerFactory());
//        for (Sach sach : sachGeneric.findAll()) {
//            sachs.add(sach);
//        }
//        NhaCungCap ncc1 = new NhaCungCap();
//        ncc1.setTenNCC("Nha cung cap 1");
//        ncc1.setDiaChiNCC("Dia chi nha cung cap 1");
//        ncc1.setSoDienThoai("0123456789");
//        ncc1.setEmail("àd");
//        ncc1.setGhiChu("Ghi chu nha cung cap 1");
//        ncc1.setSanPhams(sachs);
//        ncc.themNhaCungCap(ncc1);
        //get all ncc
//        for (NhaCungCap nhaCungCap : ncc.getALLNhaCungCap()) {
//            System.out.println(nhaCungCap);
//        }
//        get by id
//        System.out.println(ncc.getNCCTheoMa("1"));
        //update ncc
//        NhaCungCap ncc2 = new NhaCungCap();
//        ncc2.setTenNCC("Nha cung cap 2");
//        ncc2.setDiaChiNCC("Dia chi nha cung cap 2");
//        ncc2.setSoDienThoai("0123456789");
//        ncc2.setEmail("àd");
//        ncc2.setGhiChu("Ghi chu nha cung cap 2");
//        if(ncc.updateNhaCungCap("2", ncc2) == true){
//            System.out.println("Update thanh cong");
//        }else {
//            System.out.println("Update that bai");
//        }
        //loc ncc
//        for (NhaCungCap nhaCungCap : ncc.locNhaCungCap("2")) {
//            System.out.println(nhaCungCap);
//        }
        //get ma ncc
//        System.out.println(ncc.getMaNhaCungCapDB()); => méo biết làm :))))
    }
}


