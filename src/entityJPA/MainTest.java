package entityJPA;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-mssql");
//		Persistence.createEntityManagerFactory("jpa-mssql");
		
		System.out.println("asasdd");

//		DO NOT CLOSE
//		emf.close();
	}
}
