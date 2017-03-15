package service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Group 4
 */
@Entity
//@Table(name = "person")
//@NamedQueries({
//    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
//    })
public class Person extends InfoEntity implements Serializable {
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Hobby> hobbies = new ArrayList();
    
    private static final long serialVersionUID = 1L;
    private String firstname;
    private String lastname;
    
    public Person() {
    }

    public Person(String firstname, String lastname, String email) {
        super(email);
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public void addHobby(Hobby hobby){
        this.hobbies.add(hobby);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" + "firstname=" + firstname + ", lastname=" + lastname + '}';
    }
    
   
}
