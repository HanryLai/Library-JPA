package dao.impl;

import dao.Interface.ChiTietHoaDonDoiDao;
import entityJPA.ChiTietHoaDonDoi;
import utils.GenericImpl;

public class ChiTietHoaDonDoiImpl extends GenericImpl<ChiTietHoaDonDoi> implements ChiTietHoaDonDoiDao{

	public ChiTietHoaDonDoiImpl(Class<ChiTietHoaDonDoi> entityClass) {
		super(entityClass);
	}

}
