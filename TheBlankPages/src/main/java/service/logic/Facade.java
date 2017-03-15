package service.logic;

import java.util.ArrayList;
import java.util.List;
import service.entity.Company;
import service.entity.Person;
import service.interfaces.FacadeInterface;

/**
 *
 * @author Group 4
 */
public class Facade implements FacadeInterface {

    @Override
    public Person getPerson(int id) {
        return new Person("firstname", "lastname");
    }

    @Override
    public List<Person> getPersons() {
        //make a list of persons
        // add two persons to the list
        //test to ensure you get the list
        List<Person> persons = new ArrayList();
        
        persons.add( new Person("hannibal", "Skriver"));
        persons.add( new Person("martin", "kirk"));
        
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
        return new Company("name", "description", 123456, 2000, 123456789.50);
    }
}
