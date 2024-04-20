package dao.impl;

import dao.Interface.BanBaoCao_Dao;
import entityJPA.BanBaoCao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class BanBaoCao_Impl extends UnicastRemoteObject implements BanBaoCao_Dao {
	private EntityManager em;
	private GenericImpl<BanBaoCao> generic;
	public BanBaoCao_Impl() throws Exception {
		super();
		em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
		generic = new GenericImpl<>(BanBaoCao.class);
	}

	@Override
	public void open() throws RemoteException {
		generic.open();
	}

	@Override
	public void close() throws RemoteException {
		generic.close();
	}

	@Override
	public boolean save(BanBaoCao obj) throws RemoteException {
		return generic.save(obj);
	}

	@Override
	public boolean update(BanBaoCao obj) throws RemoteException {
		return generic.update(obj);
	}

	@Override
	public boolean delete(Object id) throws RemoteException{
		return generic.delete(id);
	}

	@Override
	public BanBaoCao findById(Object id) throws RemoteException {
		return generic.findById(id);
	}

	@Override
	public List<BanBaoCao> findAll() throws RemoteException {
		return generic.findAll();
	}

	@Override
	public List<BanBaoCao> findByProperty(String property, Object value) throws RemoteException {
		return generic.findByProperty(property, value);
	}


}
