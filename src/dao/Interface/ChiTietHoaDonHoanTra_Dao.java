package dao.Interface;


import entityJPA.ChiTietHoanTra;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChiTietHoaDonHoanTra_Dao extends Remote {
    public ArrayList<ChiTietHoanTra> getAllChiTietHoanTra() throws RemoteException;
    public boolean createChiTietHoanTra(ChiTietHoanTra cthd) throws RemoteException;
    public void deleteChiTietHoanTra(String maHD) throws RemoteException;
    public ChiTietHoanTra getHoaDontheoMa(String ma1, String ma2) throws RemoteException;
}
