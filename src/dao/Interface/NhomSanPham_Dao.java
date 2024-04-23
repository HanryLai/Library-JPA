package dao.Interface;
import entityJPA.NhomSanPham;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface NhomSanPham_Dao extends Remote {
    public ArrayList<NhomSanPham> getAllNhomSanPham() throws RemoteException;
    public NhomSanPham getNsptheoTen(String ten) throws RemoteException ;
    public NhomSanPham getNspTheoMa(String ma) throws RemoteException;
}
