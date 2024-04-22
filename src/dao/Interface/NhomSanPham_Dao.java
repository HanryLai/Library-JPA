package dao.Interface;
import entityJPA.NhomSanPham;

import java.util.ArrayList;
public interface NhomSanPham_Dao extends Generic_Dao<NhomSanPham>{
    public ArrayList<NhomSanPham> getAllNhomSanPham();
    public NhomSanPham getNsptheoTen(String ten) ;
    public NhomSanPham getNspTheoMa(String ma);
}
