package service.logic;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import service.entity.Company;
import service.entity.Person;
import service.interfaces.FacadeInterface;

/**
 *
 * @author Group 4
 */
public class Facade implements FacadeInterface {

    EntityManagerFactory emf;
    EntityManager em;
    
    @Override
    public Person getPerson(int id) {
        return new Person("firstname", "lastname", "email");
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Person> getPersons() {
        //make a list of persons
        // add two persons to the list
        //test to ensure you get the list
        //List<Person> persons = new ArrayList();
       // persons.add();
//        persons.add( new Person("hannibal", "Skriver"));
//        persons.add( new Person("martin", "kirk"));
        

        addEntityManagerFactory(emf);//add entity manager to get access to em methods
//        Query q1 = em.createNamedQuery("Person.findAll",Person.class);//retrieve data from database and save it in variable
        Query q1 = em.createQuery("Select p from Person p");//retrieve data from database and save it in variable
        List<Person> persons = (List<Person>) q1.getResultList();
        //q1.
//        Query q1 = em.createQuery("Select p from Person p", Person.class);//retrieve data from database and save it in variable
        em.close();
        //return q1.getResultList();//return the received data (a list of Person objects)
        
        return persons;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersons(int zipCode) {
       //make a list of persons
        // add two persons to the list
        //test to ensure you get the list
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company getCompany(int cvr) {
        return new Company("name", "description", 123456, 2000, 123456789.50, "email");
    }
}
