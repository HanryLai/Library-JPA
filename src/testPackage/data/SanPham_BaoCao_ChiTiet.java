package testPackage.data;

import entityJPA.*;
import entityJPA.otherID.ChiTietBanBaoCaoID;
import jakarta.persistence.EntityManager;
import untils.entityManagerFactory.EntityManagerFactory_Static;

import java.time.LocalDateTime;

public class SanPham_BaoCao_ChiTiet {
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactory_Static.getEntityManagerFactory().createEntityManager();

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
