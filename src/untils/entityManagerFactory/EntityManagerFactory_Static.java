package untils.entityManagerFactory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class EntityManagerFactory_Static {
    public static final String PERSISTENCE_UNIT_NAME = "jpa-mssql";
    @Getter
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    public static EntityManagerFactory resetEntityManagerFactory() {
        closeEntityManagerFactory();
        return entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
}
