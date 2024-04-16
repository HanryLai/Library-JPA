package dao.Interface;

import entityJPA.Sach;

import java.rmi.Remote;

public interface Sach_Dao extends GenericDao<Sach>, Remote {
    @Override
    public boolean delete(Object id);
}
