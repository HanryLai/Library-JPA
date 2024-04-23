package dao.Interface;




import entityJPA.HoaDonHoanTra;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HoaDonHoanTra_Dao extends Remote {
    public ArrayList<HoaDonHoanTra> getAllHoaDonHoanTra() throws RemoteException;
    public boolean createHoaDonHoanTra(HoaDonHoanTra hd) throws RemoteException;
    public boolean updateHoaDonHoanTra(HoaDonHoanTra hd) throws RemoteException;

    public HoaDonHoanTra getHoaDonHoanTratheoMa(String ma)  throws RemoteException;
    public void deleteHoaDonHoanTra(String ma) throws RemoteException;


}
