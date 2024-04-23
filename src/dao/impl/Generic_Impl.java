package dao.impl;

import java.rmi.RemoteException;
import java.util.List;

import jakarta.persistence.*;


public class Generic_Impl<T> {
    private EntityManagerFactory entityManagerFactory;
    private final Class<T> entityClass;

    public Generic_Impl(Class<T> entityClass, EntityManagerFactory emf) throws RemoteException{
        entityManagerFactory = emf; // EntityManagerFactory_Static.getEntityManagerFactory();
        this.entityClass = entityClass;
    }

    public T findById(Object id) throws RemoteException{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T result = entityManager.find(entityClass, id);
        entityManager.close();

        return result;
    }

	public List<T> findAll() throws RemoteException{
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e";

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<T> result = entityManager.createQuery(queryString, entityClass).getResultList();
        entityManager.close();

        return result;
    }

	public List<T> findByProperty(String propertyName, Object value) throws RemoteException{
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + propertyName + " = :value";

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<T> result = entityManager.createQuery(queryString, entityClass).setParameter("value", value).getResultList();
        entityManager.close();

        return result;
    }

    
    public boolean save(T entity) throws RemoteException {
        EntityManager     entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction   = null;
        try (entityManager) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();

            return true;
        } catch (PersistenceException e) {
            assert transaction != null;
            if (transaction.isActive()) {
                transaction.rollback();
            }

            return false;
        }
    }

    public boolean update(T entity) throws RemoteException {
        EntityManager     entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction   = null;
        try (entityManager) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            assert transaction != null;
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean delete(Object id) throws RemoteException {
        EntityManager     entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction   = null;
        try (entityManager) {
            transaction = entityManager.getTransaction();

            transaction.begin();
            T entity = entityManager.find(entityClass, id);
            entityManager.remove(entity);
            transaction.commit();

            return true;
        } catch (PersistenceException e) {
            assert transaction != null;
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }
}

