package dao.Interface;

import entityJPA.NhaCungCap;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface NhaCungCap_Dao extends Remote {
    public ArrayList<NhaCungCap> getALLNhaCungCap() throws RemoteException;
    public NhaCungCap getNCCTheoMa(String maNCC)throws RemoteException;
    public NhaCungCap getNCCTheoTen(String tenNCC) throws RemoteException;
    public void themNhaCungCap(NhaCungCap ncc) throws RemoteException;
    public boolean updateNhaCungCap(String maSua, NhaCungCap nccMoi) throws RemoteException;
    public ArrayList<NhaCungCap> locNhaCungCap(String duLieuTim) throws RemoteException;
    public String getMaNhaCungCapDB() throws RemoteException;
}
