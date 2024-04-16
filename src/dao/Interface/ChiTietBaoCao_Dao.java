package dao.Interface;

import entityJPA.ChiTietBanBaoCao;

import java.rmi.Remote;

public interface ChiTietBaoCao_Dao extends GenericDao<ChiTietBanBaoCao>, Remote {
    @Override
    public boolean delete(Object id);
}
