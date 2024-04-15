package dao.Interface;

import entityJPA.BanBaoCao;
import utils.GenericDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BanBaoCaoDao extends Remote {
    public void open() throws RemoteException;
    public void close() throws RemoteException;
    public boolean save(BanBaoCao obj) throws RemoteException;
    public boolean update(BanBaoCao obj) throws RemoteException;
    public boolean delete(Object id) throws RemoteException;
    public BanBaoCao findById(Object id) throws RemoteException;
    public List<BanBaoCao> findAll() throws RemoteException;
    public List<BanBaoCao> findByProperty(String property, Object value) throws RemoteException;




}
