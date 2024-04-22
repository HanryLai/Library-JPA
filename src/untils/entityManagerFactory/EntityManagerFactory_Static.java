package untils.entityManagerFactory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactory_Static {
    public static final String PERSISTENCE_UNIT_NAME = "jpa-mssql";
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    public static EntityManagerFactory resetEntityManagerFactory() {
        closeEntityManagerFactory();
        return entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
}
