package entityJPA;

import jakarta.persistence.EntityManagerFactory;

public class MainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-mssql");
		
//		DO NOT CLOSE
//		emf.close();
	}
}
