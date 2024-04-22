package dao.Interface;
import entityJPA.HoaDonHoanTra;

import java.util.ArrayList;

public interface HoaDonHoanTra_Dao extends GenericDao<HoaDonHoanTra>{
    public ArrayList<entity.HoaDonHoanTra> getAllHoaDonHoanTra();
    public boolean createHoaDonHoanTra(entity.HoaDonHoanTra hd);
    public boolean updateHoaDonHoanTra(entity.HoaDonHoanTra hd);
    public entity.HoaDonHoanTra getHoaDonHoanTratheoMa(String ma);
    public void deleteHoaDonHoanTra(String ma);
}
