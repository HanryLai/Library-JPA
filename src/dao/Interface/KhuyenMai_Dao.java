package dao.Interface;

import entity.KhuyenMai;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface KhuyenMai_Dao extends Remote {
    public ArrayList<KhuyenMai> getAlltbKM() throws RemoteException;
    public void createKhuyenMai(KhuyenMai s) throws RemoteException;
    public ArrayList<KhuyenMai> getAlltbKMTheoDangChay() throws RemoteException;
    public KhuyenMai getKMtheoMa(String ma) throws RemoteException;
    public void updateKhuyenMai(KhuyenMai s) throws RemoteException;
    public String getMaKhuyenMaiTNDB() throws RemoteException;
    public void updateTinhTrang(KhuyenMai km) throws RemoteException;
    public KhuyenMai getKmTheoMa(String maKM) throws RemoteException;

}
