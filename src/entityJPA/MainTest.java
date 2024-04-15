package entityJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;



public class MainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-mssql");
//		Persistence.createEntityManagerFactory("jpa-mssql");
		
	}
}
