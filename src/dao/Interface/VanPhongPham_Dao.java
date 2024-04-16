package dao.Interface;

import entityJPA.VanPhongPham;

import java.rmi.Remote;

public interface VanPhongPham_Dao extends GenericDao<VanPhongPham>, Remote {
    @Override
    public boolean delete(Object id);
}
