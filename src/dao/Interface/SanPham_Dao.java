package dao.Interface;

import entityJPA.SanPham;

import java.rmi.Remote;

public interface SanPham_Dao extends GenericDao<SanPham>, Remote {
    @Override
    public boolean delete(Object id);
}
