package dao.impl;

import dao.Interface.ChiTietHoaDonDoiDao;
import entityJPA.ChiTietHoaDonDoi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChiTietHoaDonDoiImpl extends UnicastRemoteObject implements ChiTietHoaDonDoiDao{

	public ChiTietHoaDonDoiImpl() throws RemoteException {

	}

	@Override
	public void open() throws RemoteException {

	}

	@Override
	public void close() throws RemoteException {

	}

	@Override
	public boolean save(ChiTietHoaDonDoi obj) throws RemoteException {
		return false;
	}

	@Override
	public boolean update(ChiTietHoaDonDoi obj) throws RemoteException {
		return false;
	}

	@Override
	public boolean delete(Object id) throws RemoteException {
		return false;
	}

	@Override
	public ChiTietHoaDonDoi findById(Object id) throws RemoteException {
		return null;
	}

	@Override
	public List<ChiTietHoaDonDoi> findAll() throws RemoteException {
		return null;
	}

	@Override
	public List<ChiTietHoaDonDoi> findByProperty(String property, Object value) throws RemoteException {
		return null;
	}


}
