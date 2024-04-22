package dao.Interface;
import entityJPA.HoaDonDoiHang;
import java.util.ArrayList;

public interface HoaDonDoiHang_Dao extends GenericDao<HoaDonDoiHang>{
    public ArrayList<HoaDonDoiHang> getAllHoaDonDoiHang();
    public boolean createHoaDonDoiHang(HoaDonDoiHang hd);
    public boolean updateHoaDonDoiHang(HoaDonDoiHang hd);
    public HoaDonDoiHang getHoaDonDoiHangtheoMa(String ma);
    public HoaDonDoiHang getHoaDonDoiHangtheoMaHT(String ma);
    public void deleteHoaDonDoi(String ma);
}
