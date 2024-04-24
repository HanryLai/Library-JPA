package dao.Interface;

import entityJPA.SanPham;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SanPham_Dao extends Remote {
    int getLastId() throws RemoteException;
}
