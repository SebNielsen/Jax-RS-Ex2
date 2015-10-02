/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sebastiannielsen
 */
public class Test {
    
    public static void main(String[] args) {
        test();
    }
    
    public static void test(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex2PU");
    EntityManager em = emf.createEntityManager();
    
    Person p = new Person();
    p.setFirstName("Sebastian");
    p.setLastName("Nielsen");
    
    em.getTransaction().begin();
    em.persist(p);
    em.getTransaction().commit();
    
//    
    }
}
