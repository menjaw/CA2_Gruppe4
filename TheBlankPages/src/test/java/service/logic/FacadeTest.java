package service.logic;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import service.entity.Company;
import service.entity.Person;

/**
 *
 * @author Group 4
 */
public class FacadeTest {
    
    Facade facade = new Facade();
    public FacadeTest() {
    }

//    @Test
//    public void testGetPerson() {
//        Person p = facade.getPerson(1);
//        assertTrue(p.getFirstName().equals("fn1"));
//    }
//    
//    @Test
//    public void testGetPersons() {
//        List<Person> p = facade.getPersons();
//        assertFalse(p.isEmpty());
//    }
//    
//    @Test
//    public void getPersonsByFirstName() {
//        List<Person> p = facade.getPersonsByFirstName("fn1");
//        assertTrue(p.size()>0);
//    }
//    
//    @Test
//    public void testAddPerson() {
//        Person personToAdd = new Person("newpersonfirstname","newpersonlastname","newpersonemail");
//        Person addedPerson = facade.addPerson(personToAdd);
//        assertTrue(addedPerson.getFirstName().equals("newpersonfirstname"));
//    }
//    
//    @Test
//    public void testUpdatePerson() {
//        Person personToUpdate = facade.getPerson(2);
//        personToUpdate.setFirstName("testFirstName");
//        Person updatedPerson = facade.updatePerson(personToUpdate);
//        assertTrue(updatedPerson.getFirstName().equals("testFirstName"));
//    }
//    
//    @Test
//    public void testDeletePerson() {
//        Person p = facade.deletePerson(3);
//        assertTrue(p.getFirstName().length()>0);
//    }
}