package dao.impl;

import dao.Interface.VanPhongPham_Dao;
import entityJPA.VanPhongPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VanPhongPham_Impl extends UnicastRemoteObject implements VanPhongPham_Dao {

	private EntityManager em;
	private GenericImpl<VanPhongPham> generic;
	public VanPhongPham_Impl() throws Exception {
		super();
		em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
	}

	public ArrayList<VanPhongPham> getAllVanPhongPhan() throws RemoteException{
		return new ArrayList<>(generic.findAll());
	}

	public VanPhongPham getVPPtheoMa(String id) throws RemoteException{
		return generic.findById(id);
	}





}
