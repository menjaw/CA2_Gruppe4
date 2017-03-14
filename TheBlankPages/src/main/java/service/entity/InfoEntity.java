package service.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Group 4
 */
@Entity
public class InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "Address")
    private Address address;
    @OneToMany(mappedBy = "infoEntity")
    @JoinColumn(name = "id", referencedColumnName = "Phone")
    private List<Phone> phones;

    public InfoEntity() {
    }

    public InfoEntity(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "InfoEntity{" + "id=" + id + ", email=" + email + '}';
    }
}
