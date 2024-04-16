package dao.Interface;

import entityJPA.BanBaoCao;

import java.rmi.Remote;

public interface BanBaoCao_Dao extends GenericDao<BanBaoCao>, Remote {
    @Override
    public boolean delete(Object id);
}
