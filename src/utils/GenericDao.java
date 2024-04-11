package utils;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public interface GenericDao<T> {
	public void open();
	public void close();
	public boolean save(T obj);
	public boolean update(T obj);
	public boolean delete(Object id);
	public T findById(Object id);
	public List<T> findAll();
	public List<T> findByProperty(String property, Object value);
}
