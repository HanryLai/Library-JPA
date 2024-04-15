package dao.impl;

import dao.Interface.BanBaoCaoDao;
import entityJPA.BanBaoCao;
import utils.GenericImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class BanBaoCaoImpl extends UnicastRemoteObject implements BanBaoCaoDao{
	private GenericImpl<BanBaoCao> generic;
	public BanBaoCaoImpl() throws Exception {
		super();
		generic = new GenericImpl<>(BanBaoCao.class);
	}

	@Override
	public void open() {
		generic.open();
	}

	@Override
	public void close() {

	}

	@Override
	public boolean save(BanBaoCao obj) {
		return false;
	}

	@Override
	public boolean update(BanBaoCao obj) {
		return false;
	}

	@Override
	public boolean delete(Object id) {
		return false;
	}

	@Override
	public BanBaoCao findById(Object id) throws RemoteException {
		return null;
	}

	@Override
	public List<BanBaoCao> findAll() {
		return null;
	}

	@Override
	public List<BanBaoCao> findByProperty(String property, Object value) {
		return null;
	}


}
