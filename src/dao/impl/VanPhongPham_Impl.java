package dao.impl;

import dao.Interface.VanPhongPham_Dao;
import entityJPA.VanPhongPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VanPhongPham_Impl extends UnicastRemoteObject implements VanPhongPham_Dao {

	private final EntityManagerFactory emf;
	public VanPhongPham_Impl(EntityManagerFactory emf) throws RemoteException {
		super();
		this.emf = emf;
	}

	public ArrayList<VanPhongPham> getAllVanPhongPhan() throws RemoteException{
		GenericImpl<VanPhongPham> generic = new GenericImpl<>(VanPhongPham.class, emf);
		return new ArrayList<>(generic.findAll());
	}

	public void insertVpp(VanPhongPham vpp) throws RemoteException{
		GenericImpl<VanPhongPham> generic = new GenericImpl<>(VanPhongPham.class, emf);
		generic.save(vpp);
	}

	public boolean update (VanPhongPham vpp) throws RemoteException{
		GenericImpl<VanPhongPham> generic = new GenericImpl<>(VanPhongPham.class, emf);
		return generic.update(vpp);
	}

	public VanPhongPham getVPPtheoMa(String id) throws RemoteException{
		GenericImpl<VanPhongPham> generic = new GenericImpl<>(VanPhongPham.class, emf);
		return generic.findById(id);
	}





}
