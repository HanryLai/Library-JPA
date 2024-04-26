package dao.Interface;

import entityJPA.NhanVien;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface NhanVien_Dao extends Remote {
    public List<NhanVien> getAllNhanVien() throws RemoteException;
    public List<NhanVien> getAllNhanVienTheoCa(int caLv) throws RemoteException;
    public NhanVien getNVTheoMa(int maNV) throws RemoteException;
    public boolean themNhanVien(NhanVien nv) throws RemoteException;
    public boolean updateNhanVien(NhanVien nv) throws RemoteException;
    public List<NhanVien> locNhanVien(String duLieuTim) throws RemoteException;
    public List<NhanVien> locNhanVienTheoChucVu(String duLieuTim) throws RemoteException;
    public String getMaNhanVienQLDB() throws RemoteException;
    public String getMaNhanVienTNDB() throws RemoteException;
    public String getCaLamViecTheoNhanVien(String email) throws RemoteException;
    public String getChucVuTheoTen(String tenDangNhap) throws RemoteException;


}
