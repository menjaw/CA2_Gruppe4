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
public class Company extends InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private int cvr;
    private int numberOfEmployees;
    private double marketValue;

    public Company() {
    }

    public Company(String name, String description, int cvr, int numberOfEmployees, double marketValue) {
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numberOfEmployees = numberOfEmployees;
        this.marketValue = marketValue;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", description=" + description + ", cvr=" + cvr + ", numberOfEmployees=" + numberOfEmployees + ", marketValue=" + marketValue + '}';
    }
}
