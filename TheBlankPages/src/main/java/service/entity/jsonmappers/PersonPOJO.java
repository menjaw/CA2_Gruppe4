package service.entity.jsonmappers;

import service.entity.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;


@Entity
public class PersonPOJO extends InfoEntity implements Serializable {

//    /private static final long serialVersionUID = 1L;
 
    private String firstName, lastName;
    
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Hobby> hobbies = new ArrayList<>();
    
    public PersonPOJO() {
    }

    public PersonPOJO(String firstName, String lastName, String email) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    
    
}
