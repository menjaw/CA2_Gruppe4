package service.interfaces;

import java.util.List;
import service.entity.Company;
import service.entity.Person;

/**
 *
 * @author Group 4
 */
public interface FacadeInterface {
    Person getPerson(int id);
    List<Person> getPersons();
    List<Person> getPersonsByFirstName(String name);
    Person addPerson(Person p);
    Person updatePerson(Person p);
    Person deletePerson(int id);
    Company getCompany(int cvr);
    List<Person> getPersons(int zipCode);
}