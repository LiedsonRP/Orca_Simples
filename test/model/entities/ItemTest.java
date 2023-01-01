/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lieds
 */
public class ItemTest {
    
    public ItemTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }   

    /**
     * Test of addLink method, of class Item.
     */
    @Test
    public void testAddLink() {
        System.out.println("addLink");
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        massa.addLink(link);
        
        assertTrue("A manteiga não foi inserida na lista de ligações feitas!",massa.getLinkedTo().contains(link));
        
        RecipeItem link2 = new RecipeItem(massa, manteiga);
        massa.addLink(link2);
        
        assertFalse("Um ligação repetida foi cadastrada!", massa.getLinkedTo().contains(link2));        
    }

    /**
     * Test of receiveLink method, of class Item.
     */
    @Test
    public void testReceiveLink() {
        System.out.println("receiveLink");
        
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        manteiga.receiveLink(link);
        
        assertTrue("A massa não foi inserida na lista de ligações recebidas!",manteiga.getLinkedFrom().contains(link));
        
        RecipeItem link2 = new RecipeItem(massa, manteiga);
        massa.receiveLink(link2);
        
        assertFalse("Um ligação repetida foi cadastrada!", manteiga.getLinkedFrom().contains(link2));        
    }

    /**
     * Test of removeLinkFromLinkedFrom method, of class Item.
     */
    @Test
    public void testRemoveLinkFromLinkedFrom() {
        System.out.println("removeLinkFromLinkedFrom");
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        manteiga.receiveLink(link);
        
        manteiga.removeLinkFromLinkedFrom(link);
        
        assertFalse("O link não foi deletado da lista!", manteiga.getLinkedFrom().contains(link));
    }   

    /**
     * Test of removeLinkFromLinkedTo method, of class Item.
     */
    @Test
    public void testRemoveLinkFromLinkedTo() {
        System.out.println("removeLinkFromLinkedTo");
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        massa.addLink(link);
        
        massa.removeLinkFromLinkedTo(link);
        
        assertFalse("O link não foi deletado da lista!", massa.getLinkedTo().contains(link));
    }       
    
}
