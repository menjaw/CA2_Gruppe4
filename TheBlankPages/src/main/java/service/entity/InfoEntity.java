package service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Group 4
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn
public class InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @ManyToOne
    //@JoinColumn()
    private Address address;
    @OneToMany(mappedBy = "infoEntity", cascade = CascadeType.ALL)
    @JoinColumn(name = "IE_ID")
    private List<Phone> phones = new ArrayList();

    public InfoEntity() {
    }

    public InfoEntity(String email) {
        this.email = email;
    }
    
    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }
    
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
    
    @Override
    public String toString() {
        return "InfoEntity{" + "id=" + id + ", email=" + email + '}';
    }
}
