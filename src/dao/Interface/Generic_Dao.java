package dao.Interface;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public interface Generic_Dao<T> {
	public void open() throws RemoteException;
	public void close() throws RemoteException;
	public boolean save(T obj)throws RemoteException;
	public boolean update(T obj)throws RemoteException;
	public boolean delete(Object id) throws RemoteException;
	public T findById(Object id) throws RemoteException;
	public List<T> findAll()throws RemoteException;
	public List<T> findByProperty(String property, Object value)throws RemoteException;
}
