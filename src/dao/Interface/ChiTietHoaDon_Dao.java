package dao.Interface;


import entityJPA.ChiTietHoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChiTietHoaDon_Dao extends Remote {
    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() throws RemoteException;
    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDonByMaHD(String maHD) throws RemoteException;
//    public boolean createChiTietHoaDonVPP(ChiTietHoaDon cthd) throws RemoteException;
    public boolean createChiTietHoaDon(ChiTietHoaDon cthd) throws RemoteException;
    public boolean deleteChiTietHoaDonVaSanPham(String maHD, String maSP) throws RemoteException;
    public boolean deleteChiTietHoaDon(String maHD) throws RemoteException;

    public ChiTietHoaDon getCTHoaDontheoMa(String ma1, String ma2) throws RemoteException;
//    public boolean updateCTHoaDon(ChiTietHoaDon cthd) throws RemoteException;
}

