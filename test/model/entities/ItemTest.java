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
     * Test of addRecipeItem method, of class Item.
     */
    @Test
    public void testAddRecipeItemtest() {
        System.out.println("addLink");
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        massa.addRecipeItem(link);
        
        assertTrue("A manteiga não foi inserida na lista de ligações feitas!",massa.getLinkedTo().contains(link));
        
        RecipeItem link2 = new RecipeItem(massa, manteiga);
        massa.addRecipeItem(link2);
        
        assertFalse("Um ligação repetida foi cadastrada!", massa.getLinkedTo().contains(link2));        
    }

    /**
     * Test of receiveRecipeItem method, of class Item.
     */
    @Test
    public void testReceiveLink() {
        System.out.println("receiveLink");
        
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        manteiga.receiveRecipeItem(link);
        
        assertTrue("A massa não foi inserida na lista de ligações recebidas!",manteiga.getLinkedFrom().contains(link));
        
        RecipeItem link2 = new RecipeItem(massa, manteiga);
        massa.receiveRecipeItem(link2);
        
        assertFalse("Um ligação repetida foi cadastrada!", manteiga.getLinkedFrom().contains(link2));        
    }

    /**
     * Test of removeRecipeItemFromLinkedFrom method, of class Item.
     */
    @Test
    public void testRemoveRecipeItemFromLinkedFrom() {
        System.out.println("removeLinkFromLinkedFrom");
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        manteiga.receiveRecipeItem(link);
        
        manteiga.removeRecipeItemFromLinkedFrom(link);
        
        assertFalse("O link não foi deletado da lista!", manteiga.getLinkedFrom().contains(link));
    }   

    /**
     * Test of removeRecipeItemFromLinkedTo method, of class Item.
     */
    @Test
    public void testRemoveRecipeItemFromLinkedTotestRemoveRecipeItemFromLinkedTo() {
        System.out.println("removeLinkFromLinkedTo");
        Item manteiga = new Item("Manteiga");
        Item massa = new Item("Massa");
        RecipeItem link = new RecipeItem(massa, manteiga);
        massa.addRecipeItem(link);
        
        massa.removeRecipeItemFromLinkedTo(link);
        
        assertFalse("O link não foi deletado da lista!", massa.getLinkedTo().contains(link));
    }       
    
}
