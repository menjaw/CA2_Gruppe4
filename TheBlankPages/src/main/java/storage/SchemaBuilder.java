package storage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Group 4
 */
public class SchemaBuilder {
    public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
//        Persistence.generateSchema("pu", null);
        
        Persistence.generateSchema("pu", null);
        
        
        
    }
}
