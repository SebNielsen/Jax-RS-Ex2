/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sebastiannielsen
 */
public class Facade implements IPersonFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex2PU");
    EntityManager em = emf.createEntityManager();
    
    public Facade(){
        
    }
    
    @Override
    public Person addPerson(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    @Override
    public Person deletePerson(int PersonID) {
        Person p = em.find(Person.class, PersonID);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        return p;
    }

    
    @Override
    public Person getPerson(long id) {
        Person p = em.find(Person.class, id);
        return p;
    }
    
    
    @Override
    public List<Person> getPersons() {
        Query query = em.createNativeQuery("SELECT * FROM person", Person.class);
        List<Person> persons = query.getResultList();
        return persons;
    }

    
    @Override
    public Person editPerson(Person pers) {
        Person p = em.find(Person.class, pers.getId());
        if (p != null) {
            em.getTransaction().begin();
            p = pers;
            em.getTransaction().commit();
        }
        return p;
    }
}
