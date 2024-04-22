package dao.Interface;

import entityJPA.VanPhongPham;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VanPhongPham_Dao extends Remote {
    ArrayList<VanPhongPham> getAllVanPhongPhan() throws RemoteException;
    void insertVpp(VanPhongPham vpp) throws RemoteException;
    boolean update (VanPhongPham vpp) throws RemoteException;
    VanPhongPham getVPPtheoMa(String id) throws RemoteException;
}
