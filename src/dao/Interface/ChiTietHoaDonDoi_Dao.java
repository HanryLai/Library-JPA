package dao.Interface;


import entityJPA.ChiTietHoaDonDoi;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ChiTietHoaDonDoi_Dao extends Remote {
    public ArrayList<ChiTietHoaDonDoi> getAllChiTietDonDoi() throws Exception;
    public boolean createChiTietDonDoi(ChiTietHoaDonDoi cthd) throws Exception;
    public void deleteChiTietDonDoi(String maHD) throws Exception;
    public ChiTietHoaDonDoi getHoaDontheoMa(String ma1, String ma2) throws Exception;

}
