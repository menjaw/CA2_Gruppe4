package service.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Group 4
 */
@Entity
public class Address implements Serializable {
    
    @OneToMany(mappedBy = "address")
    private List<InfoEntity> infoEntities;
    
    @ManyToOne
    private CityInfo cityInfo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String additionalInfo;

    public Address() {
    }

    public Address(String street, String additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", additionalInfo=" + additionalInfo + '}';
    }
}