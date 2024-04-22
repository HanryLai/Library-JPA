package dao.Interface;

import entityJPA.ChiTietBanBaoCao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChiTietBaoCao_Dao extends Remote {

    ArrayList<ChiTietBanBaoCao> getSachDaBan(int maHD, String thoiGianBatDau, String thoiGianKetThuc) throws RemoteException;

    ArrayList<ChiTietBanBaoCao> getVPPDaBan(int maHD, String thoiGianBatDau, String thoiGianKetThuc) throws RemoteException;

    ArrayList<ChiTietBanBaoCao> getTinhTrangNhapSach(String ngayTao) throws RemoteException;

    ArrayList<ChiTietBanBaoCao> getTinhTrangNhapVPP(String ngayTao)throws RemoteException;

    double getDoanhThuTheoCa(int maHD, String thoiGianBatDau, String thoiGianKetThuc)throws RemoteException;

    ArrayList<ChiTietBanBaoCao> getChiTietBanBaoCao(int maBanBaoCao) throws RemoteException;

    double getDoanhThuCaNgay(String maBanBaoCao)throws RemoteException;

    int getTongSanPhamBanDuoc(String maBanBaoCao)throws RemoteException;

    double getDoanhThuTheoTenBC(String tenBanBaoCao)throws RemoteException;
}
