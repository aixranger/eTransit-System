/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ssivakan
 */
public class JUnitTesting {
    
    public JUnitTesting() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    
    public void testPositiveCheck(){
        boolean ans = true;
        boolean val;
        int m = 70;
        
        val = AdultAccount.positiveCheck(m);
        assertEquals(ans,val); 
    }
    
    @Test
    
    public void testTypeAccMembership(){
        AccMembership a = new AccMembership("a","a", 3);
        String ans = "Student Account" ;
        String val;
        int m = 0;
        
        val = a.TypeAccMembership(m);
        assertEquals(ans,val); 
    
    }
    
    @Test
    
    public void testSearchAccMembership(){
        AccMembership a = new AccMembership("a","a", 3);
        int ans = 0 ;
        int val;
        String m = "a";
        
        val = a.searchAccMembership(m);
        assertEquals(ans,val); 
    
    }
    
      @Test
    
    public void testLogin(){
        AccMembership a = new AccMembership("a","a", 3);
        
        assertTrue(a.login("a","a")); 
    
    }
     @Test
     public void testLoginAuth(){
        AccMembership a = new AccMembership("b","b", 3);
        boolean ans = false;
        boolean val;
        
        
        val = eTransit.LoginAuth("a","a");
        assertEquals(ans,val); 
    
    }
      
    
}

