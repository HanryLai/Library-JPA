package dao.Interface;


import entityJPA.ChiTietHoaDonDoi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChiTietHoaDonDoi_Dao extends Remote {
    public ArrayList<ChiTietHoaDonDoi> getAllChiTietDonDoi() throws RemoteException;
    public boolean createChiTietDonDoi(ChiTietHoaDonDoi cthd) throws RemoteException;
    public void deleteChiTietDonDoi(String maHD) throws RemoteException;
    public ChiTietHoaDonDoi getHoaDontheoMa(String ma1, String ma2) throws RemoteException;

}
