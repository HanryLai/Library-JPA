package dao.impl;

import dao.Interface.VanPhongPham_Dao;
import entityJPA.VanPhongPham;
import jakarta.persistence.EntityManagerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class VanPhongPham_Impl extends UnicastRemoteObject implements VanPhongPham_Dao {

	private final EntityManagerFactory emf;
	public VanPhongPham_Impl(EntityManagerFactory emf) throws RemoteException {
		super();
		this.emf = emf;
	}

	public ArrayList<VanPhongPham> getAllVanPhongPhan() throws RemoteException{
		Generic_Impl<VanPhongPham> generic = new Generic_Impl<>(VanPhongPham.class, emf);
		return new ArrayList<>(generic.findAll());
	}

	public void insertVpp(VanPhongPham vpp) throws RemoteException{
		Generic_Impl<VanPhongPham> generic = new Generic_Impl<>(VanPhongPham.class, emf);
		generic.save(vpp);
	}

	public boolean update (VanPhongPham vpp) throws RemoteException{
		Generic_Impl<VanPhongPham> generic = new Generic_Impl<>(VanPhongPham.class, emf);
		return generic.update(vpp);
	}

	public VanPhongPham getVPPtheoMa(String id) throws RemoteException{
		Generic_Impl<VanPhongPham> generic = new Generic_Impl<>(VanPhongPham.class, emf);
		return generic.findById(id);
	}





}
