package dao.Interface;

import entityJPA.HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface HoaDon_Dao extends Remote {
    public ArrayList<HoaDon> getAllHoaDon() throws RemoteException;
    public boolean createHoaDon(HoaDon hd) throws RemoteException;
    public boolean updateHoaDon(HoaDon hd) throws RemoteException;
    public HoaDon getHoaDontheoMa(String ma) throws RemoteException;
    public boolean deleteHoaDon(String maHD)  throws RemoteException;
    public List<String> getMaHoaDonTheoNgay(String ngayLapHD) throws RemoteException;
}
