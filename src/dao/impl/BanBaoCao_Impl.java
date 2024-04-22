package dao.impl;

import dao.Interface.BanBaoCao_Dao;
import entityJPA.BanBaoCao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BanBaoCao_Impl extends UnicastRemoteObject implements BanBaoCao_Dao {
	private final EntityManagerFactory emf;
	public BanBaoCao_Impl(EntityManagerFactory emf) throws RemoteException {
		super();
		this.emf = emf;
	}

	public ArrayList<BanBaoCao> getALLBanBaoCao() throws RemoteException {
		GenericImpl<BanBaoCao> generic = new GenericImpl<>(BanBaoCao.class, emf);
		return (ArrayList<BanBaoCao>) generic.findAll();
	}

	public boolean taoBanBaoCao(BanBaoCao bbc) throws RemoteException {
		GenericImpl<BanBaoCao> generic = new GenericImpl<>(BanBaoCao.class, emf);
		return generic.save(bbc);
	}

	public int getMaBBCTheoTen(String tenBBC) throws RemoteException {
		GenericImpl<BanBaoCao> generic = new GenericImpl<>(BanBaoCao.class, emf);
		List<BanBaoCao> list = generic.findByProperty("tenBanBaoCao", tenBBC);

		if (!list.isEmpty()) {
			return list.get(0).getMaBanBaoCao();
		}

		return -1;
	}
}
