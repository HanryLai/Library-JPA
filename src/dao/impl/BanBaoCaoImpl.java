package dao.impl;

import dao.BanBaoCaoDao;
import entity.BanBaoCao;
import utils.GenericImpl;

public class BanBaoCaoImpl extends GenericImpl<BanBaoCao> implements BanBaoCaoDao{
	public BanBaoCaoImpl(Class<BanBaoCao> entityClass) {
		super(entityClass);
	}

}
