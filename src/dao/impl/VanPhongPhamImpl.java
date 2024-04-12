package dao.impl;

import dao.VanPhongPhamDao;
import entity.VanPhongPham;
import utils.GenericImpl;

public class VanPhongPhamImpl extends GenericImpl<VanPhongPham> implements VanPhongPhamDao{

	public VanPhongPhamImpl(Class<VanPhongPham> entityClass) {
		super(entityClass);
	}

}
