package dao.Interface;

import entityJPA.NhaCungCap;

import java.rmi.Remote;
import java.util.ArrayList;

public interface NhaCungCap_Dao extends Remote {
    public ArrayList<NhaCungCap> getALLNhaCungCap() throws Exception;
    public NhaCungCap getNCCTheoMa(String maNCC)throws Exception;
    public NhaCungCap getNCCTheoTen(String tenNCC) throws Exception;
    public void themNhaCungCap(NhaCungCap ncc) throws Exception;
    public boolean updateNhaCungCap(String maSua, NhaCungCap nccMoi) throws Exception;
    public ArrayList<NhaCungCap> locNhaCungCap(String duLieuTim) throws Exception;
    public String getMaNhaCungCapDB() throws Exception;
}
