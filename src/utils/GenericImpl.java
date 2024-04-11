package utils;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class GenericImpl<T> implements GenericDao<T>{
	private EntityManager entityManager = Persistence
												.createEntityManagerFactory("")
												.createEntityManager();
    private final Class<T> entityClass;

    public GenericImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public T findById(Object id) {
        return entityManager.find(entityClass, id);
    }
    
    @Override
	public void open() {
		entityManager = Persistence.createEntityManagerFactory("NguyenTanLoc_21059391")
				.createEntityManager();
	}

	@Override
	public void close() {
		entityManager.close();
	}

    @SuppressWarnings("unchecked")
	public List<T> findAll() {
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        Query query = entityManager.createQuery(queryString, entityClass);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + propertyName + " = :value";
        Query query = entityManager.createQuery(queryString, entityClass);
        query.setParameter("value", value);
        return query.getResultList();
    }

    
    public boolean save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
        	transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
        	transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean delete(Object id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
        	transaction.begin();
        	T entity = entityManager.find(entityClass, id);
            entityManager.remove(entity);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }
}

