/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.memory;

import model.entities.Product;
import model.entities.SimpleFoodstock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lieds
 */
public class MemoryTest {        
    
    Memory memory;                
    
    @Before
    public void setUp() {
        memory = new Memory();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
       
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class Memory.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        SimpleFoodstock foodstock = new SimpleFoodstock("Manteiga", "Alimentício", "g", 500, 8.50);                                       
        memory.addItem(foodstock);                
    }

    /**
     * Test of getAllRecordedFoodstocks method, of class Memory.
     */
    @Test
    public void testGetAllRecordedFoodstocks() {
        System.out.println("getAllRecordedFoodstocks");        
    }

    /**
     * Test of saveFoodstocks method, of class Memory.
     */
    @Test
    public void testSaveFoodstocks() {
        System.out.println("saveFoodstocks");        
    }
    
}
