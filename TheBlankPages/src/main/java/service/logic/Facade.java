package service.logic;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
        Person p = em.find(Person.class,id);
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
    
//    @Override
//    public Person updatePerson(Person p) {
//        em = emf.createEntityManager();
//        TypedQuery<Person> result = em.createNamedQuery("Person.findById", Person.class);
//        Person personToUpdate = result.setParameter("id", p.getId()).getSingleResult();
//
//        //Udfør ændringerne i databasen
//        em.getTransaction().begin();
//        //Tag fat i personToUpdate-variablen og set de forskellige værdier
//        personToUpdate.setFirstName(p.getFirstName());
//        personToUpdate.setLastName(p.getLastName());
//        personToUpdate.setPhones(2,1234);
////                
////                (p.getPhones().get(0));
//        em.getTransaction().commit();
//        em.close();
//
//        //Returner den opdateret person
//        return personToUpdate;
//    }
        
    @Override
    public Person updatePerson(Person personWithUpdatedDetails) {
        em = emf.createEntityManager();
        Person personToModify = em.find(Person.class,personWithUpdatedDetails.getId());
        personToModify.setFirstName(personWithUpdatedDetails.getFirstName());
        personToModify.setLastName(personWithUpdatedDetails.getLastName());
        mergeData(personToModify, em);
        em = emf.createEntityManager();
        Person personModified = em.find(Person.class,personToModify.getId());
        return personModified;
        
        
//        TypedQuery<Person> result = em.createNamedQuery("Person.findById", Person.class);
//        Person personToUpdate = result.setParameter("id", p.getId()).getSingleResult();

        //Udfør ændringerne i databasen
//        em.getTransaction().begin();
        //Tag fat i personToUpdate-variablen og set de forskellige værdier
//        personToUpdate.setFirstName(p.getFirstName());
//        personToUpdate.setLastName(p.getLastName());
//        personToUpdate.setPhones(2,1234);
//                
//                (p.getPhones().get(0));
//        em.getTransaction().commit();
//        em.close();

        //Returner den opdateret person
    }    
        
    
    
    @Override
    public Person deletePerson(int id) {
        em = emf.createEntityManager();
        Person personToDelete = em.find(Person.class, id);
        deleteData(personToDelete, em);
        return personToDelete;
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
    
    private boolean mergeData(Object o, EntityManager em){
        try{
            em.getTransaction().begin();
            em.merge(o);
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