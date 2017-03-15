package service.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Group 4
 */
@Entity
public class Phone implements Serializable {
    @ManyToOne
    @JoinColumn()
    private InfoEntity infoEntity;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    int phone;
    String description;

    public Phone() {
    }

    public Phone(int phone, String description) {
        this.phone = phone;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", phone=" + phone + ", description=" + description + '}';
    }
}
