package dao.Interface;

import entityJPA.KhachHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface KhachHang_Dao extends Remote {
    public List<KhachHang> getAllKhachHang() throws RemoteException;
    public KhachHang getKHTheoMa(int ma) throws RemoteException;
    public KhachHang getKHTheoSDT(String soDienThoai) throws RemoteException;
    public boolean themKhachHang(KhachHang cus) throws RemoteException;
    public boolean updateKhachHang(KhachHang cus) throws RemoteException;
    public List<KhachHang> locDuLieuKhachHang(String data) throws RemoteException;

    public static void capNhatNhomKhachHang() throws RemoteException {

    }
    public List<KhachHang> getKhachHangTrong1Thang() throws RemoteException;

}
