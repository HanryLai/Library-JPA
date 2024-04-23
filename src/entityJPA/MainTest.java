package entityJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-mssql");
//		Persistence.createEntityManagerFactory("jpa-mssql");
		
		EntityManager em = emf.createEntityManager();

		try {
			// create session
			em.getTransaction().begin();


			// do something
			em.getTransaction().commit();
		} catch (Exception exp) {
			em.getTransaction().rollback();
			// close session
		}
		em.close();

//		DO NOT CLOSE
//		emf.close();
	}
}
