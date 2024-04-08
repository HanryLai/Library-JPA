package utils;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AppUtils<T> {
	private final EntityManager entityManager;
    private final Class<T> entityClass;

    public AppUtils(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }
    
    public T findById(Object id) {
        return entityManager.find(entityClass, id);
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
            entityManager.persist(entity);
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
            entityManager.merge(entity);
            return true;
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            entityManager.remove(entity);
            return true;
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }
}

