/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import service.entity.Person;

/**
 *
 * @author Group 4
 */
public class tester {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("pu", null).createEntityManager();
        //em.getTransaction().begin();
        //em.persist(new Person("fan","fin"));
        //em.getTransaction().commit();
        System.out.println(em.find(Person.class,1));
    }
}
