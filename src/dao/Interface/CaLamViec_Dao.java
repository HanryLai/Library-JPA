package dao.Interface;

import entityJPA.CaLamViec;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CaLamViec_Dao extends Remote {
    public CaLamViec getCaLamViecTheoTenCa(String tenCa) throws RemoteException;

}
