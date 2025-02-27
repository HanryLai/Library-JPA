package dao.impl;

import dao.Interface.BanBaoCao_Dao;
import entityJPA.BanBaoCao;

import jakarta.persistence.EntityManagerFactory;

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
		Generic_Impl<BanBaoCao> generic = new Generic_Impl<>(BanBaoCao.class, emf);
		return (ArrayList<BanBaoCao>) generic.findAll();
	}

	public boolean taoBanBaoCao(BanBaoCao bbc) throws RemoteException {
		Generic_Impl<BanBaoCao> generic = new Generic_Impl<>(BanBaoCao.class, emf);
		return generic.save(bbc);
	}

	public int getMaBBCTheoTen(String tenBBC) throws RemoteException {
		Generic_Impl<BanBaoCao> generic = new Generic_Impl<>(BanBaoCao.class, emf);
		List<BanBaoCao> list = generic.findByProperty("tenBanBaoCao", tenBBC);

		if (!list.isEmpty()) {
			return list.get(0).getMaBanBaoCao();
		}

		return -1;
	}
	@Override
	public BanBaoCao getBanBaoCaoTheoMa(int maBBC) throws RemoteException {
		Generic_Impl<BanBaoCao> generic = new Generic_Impl<>(BanBaoCao.class, emf);
		return generic.findById(maBBC);
	}
}
