package dao.impl;

import dao.Interface.VanPhongPham_Dao;
import entityJPA.VanPhongPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VanPhongPham_Impl extends UnicastRemoteObject implements VanPhongPham_Dao {

	private EntityManager em;
	private GenericImpl<VanPhongPham> generic;
	public VanPhongPham_Impl() throws Exception {
		super();
		em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
		generic = new GenericImpl<>(VanPhongPham.class);
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
	public boolean save(VanPhongPham obj) throws RemoteException {
		return generic.save(obj);
	}

	@Override
	public boolean update(VanPhongPham obj) throws RemoteException {
		return generic.update(obj);
	}

	@Override
	public boolean delete(Object id) {
		return generic.delete(id);
	}

	@Override
	public VanPhongPham findById(Object id) throws RemoteException {
		return generic.findById(id);
	}

	@Override
	public List<VanPhongPham> findAll() throws RemoteException {
		return generic.findAll();
	}

	@Override
	public List<VanPhongPham> findByProperty(String property, Object value) throws RemoteException {
		return generic.findByProperty(property, value);
	}

}
