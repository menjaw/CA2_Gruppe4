package service.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Group 4
 */
@Entity
public class cityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int zipCode;
    private String city;

    public cityInfo() {
    }

    public cityInfo(int zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }
    
    public Integer getId() {
        return id;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "cityInfo{" + "id=" + id + ", zipCode=" + zipCode + ", city=" + city + '}';
    }
}
