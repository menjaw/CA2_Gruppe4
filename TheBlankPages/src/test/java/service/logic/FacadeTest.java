package service.logic;

import org.junit.Test;
import static org.junit.Assert.*;
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
    
}
