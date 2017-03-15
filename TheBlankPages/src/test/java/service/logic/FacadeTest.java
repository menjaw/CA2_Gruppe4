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

    @Test
    public void testGetPerson() {
        Person p = facade.getPerson(0);
        assertTrue(p.getFirstname().equals("firstname"));
    }
    
    @Test
    public void testGetPersons() {
        List<Person> p = facade.getPersons();
        assertTrue(p.size() == 2);
    }
    @Test
    public void testGetCompany() {
        Company c = facade.getCompany(0);
        assertTrue(c.getCvr() == 123456);
    }
    
}
