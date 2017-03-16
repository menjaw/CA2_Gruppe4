package service.logic;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import service.entity.Company;
import service.entity.InfoEntity;
import service.entity.Person;
import service.interfaces.FacadeInterface;

/**
 *
 * @author Group 4
 */
public class Facade implements FacadeInterface {

    EntityManagerFactory emf;
    EntityManager em;
    
    public Facade() {
        emf = Persistence.createEntityManagerFactory("pu");
    }

    @Override
    public Person getPerson(int id) {
        em = emf.createEntityManager();
        Person p = em.find(Person.class,1);
        return p;
    }
    
    @Override
    public List<Person> getPersons() {
        em = emf.createEntityManager();
        Query q1 = em.createQuery("Select p from Person p");//retrieve data from database and save it in variable
        return q1.getResultList();//return the received data (a list of Person objects)
    }
    
    @Override
    public Person addPerson(Person p) {
        em = emf.createEntityManager();
        persistData(p, em);
        return p;
    }
    
    
    
    
    
    
    private boolean persistData(Object o, EntityManager em){
        try{
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }
        catch(Exception e){
            return false;
        }
        finally{
            em.close();
        }
        return true;
    }
    
    private boolean deleteData(Object o, EntityManager em){
        try{
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        }
        catch(Exception e){
            return false;
        }
        finally{
            em.close();
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   

    @Override
    public Company getCompany(int cvr) {
        return new Company("name", "description", 123456, 2000, 123456789.50, "email");
    }

    @Override
    public List<Person> getPersons(int zipCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
