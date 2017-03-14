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
    List<Person> getPersons(int zipCode);
    Company getCompany(int cvr);
}