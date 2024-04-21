package dao.impl;

import java.rmi.RemoteException;
import java.util.List;

import dao.Interface.GenericDao;
import jakarta.persistence.*;

public class GenericImpl<T> {
    private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
    private final Class<T> entityClass;

    public GenericImpl(Class<T> entityClass) throws RemoteException{
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-mssql");
        entityManager = entityManagerFactory.createEntityManager();
        this.entityClass = entityClass;
    }

	public void open() throws RemoteException {
       if (!entityManager.isOpen()) {
           entityManager = entityManagerFactory.createEntityManager();
       }
	}

	public void close() throws RemoteException {
		 if (entityManager.isOpen()) {
              entityManager.close();
         }
	}

    public T findById(Object id) throws RemoteException{
        open();
        T result = entityManager.find(entityClass, id);
        close();

        return result;
    }

	public List<T> findAll() throws RemoteException{
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e";

        open();
        List<T> result = entityManager.createQuery(queryString, entityClass).getResultList();
        close();

        return result;
    }

	public List<T> findByProperty(String propertyName, Object value) throws RemoteException{
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + propertyName + " = :value";

        open();
        List<T> result = entityManager.createQuery(queryString, entityClass).setParameter("value", value).getResultList();
        close();

        return result;
    }

    
    public boolean save(T entity) throws RemoteException{
        open();
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
        finally {
            close();
        }
    }

    public boolean update(T entity) throws RemoteException{
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

    public boolean delete(Object id) throws RemoteException{
        open();
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
        finally {
            close();
        }
    }
}

