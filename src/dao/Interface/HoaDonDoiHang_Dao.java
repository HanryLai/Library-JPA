package dao.Interface;


import entityJPA.HoaDonDoiHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HoaDonDoiHang_Dao extends Remote {
    public ArrayList<HoaDonDoiHang> getAllHoaDonDoiHang() throws RemoteException;
    public boolean createHoaDonDoiHang(HoaDonDoiHang hd) throws RemoteException;
    public boolean updateHoaDonDoiHang(HoaDonDoiHang hd) throws RemoteException;
    public HoaDonDoiHang getHoaDonDoiHangtheoMa(String ma) throws RemoteException;

    public HoaDonDoiHang getHoaDonDoiHangtheoMaHT(String ma) throws RemoteException;

    public boolean deleteHoaDonDoi(String ma) throws RemoteException;
}
