/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import entity.Person;
import facade.Facade;
import facade.IPersonFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sebastiannielsen
 */
public class UnitTest {
    public UnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddNewPerson(){
        IPersonFacade facade = new Facade();
        Person p1 = new Person();
        p1.setFirstName("Jens");
        p1.setLastName("Nielsen");
        p1.setPhone("12345678");
        facade.addPerson(p1);
        
        Person p2 = new Person();
        p2.setFirstName("Jens");
        p2.setLastName("Nielsen");
        p2.setPhone("12345678");
        
        Person p3 = new Person();
        p3.setFirstName("Jens");
        p3.setLastName("Nielsen");
        p3.setPhone("12345678");
        
    }
}
