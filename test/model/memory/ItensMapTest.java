/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.memory;

import java.util.ArrayList;
import java.util.Collection;
import model.entities.Item;
import model.entities.Link;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lieds
 */
public class ItensMapTest {
    
    public ItensMapTest() {
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

    /**
     * Test of addItem method, of class ItensMap.
     */
    @Test
    public void testAddSimpleItem() {
        
        System.out.println("addSimpleItem");
        
        ItensMap instance = new ItensMap();        
        Item manteiga = new Item("Manteiga");        
        instance.addItem(manteiga);
        
        try {
            System.out.println("Checando se aceita cadastro repitido");
            instance.addItem(manteiga);        
            fail("O item já existe, porém foi cadastrado");
        } catch (IllegalArgumentException ex) {
            System.out.println("Teste passed");
            System.out.println(manteiga.toString());
        }
        
        
    }
    
    /**
     * Test of addItem method, of class ItensMap.
     */
    @Test
    public void testAddCompoundItem() {
        System.out.println("addCompoundItem");
        
        ItensMap instance = new ItensMap();                
        Item manteiga = new Item("Manteiga");        
        instance.addItem(manteiga);
        
        Item leite = new Item("Leite");        
        instance.addItem(leite);
        
        Item embalagem = new Item("Embalagem");        
        instance.addItem(embalagem);
                
        Item massa = new Item("Massa");
        Link massa_manteiga = new Link(massa, manteiga);
        Link massa_leite = new Link(massa, leite);
        Link massa_embalagem = new Link(massa, embalagem);
        
        massa.addLink(massa_manteiga);
        massa.addLink(massa_embalagem);
        massa.addLink(massa_leite);        
        
        instance.addItem(massa);
        
        try {
            System.out.println("Checando se aceita cadastro repitido");
            instance.addItem(massa);        
            fail("O item já existe, porém foi cadastrado");
        } catch (IllegalArgumentException ex) {            
            System.out.println(massa.toString());
            System.out.println("\n\n++++++++++++++++++++++++++++++++++\n\n");   
            System.out.println(manteiga.toString());
            System.out.println("\n\n++++++++++++++++++++++++++++++++++\n\n");   
            System.out.println(leite.toString());
            System.out.println("\n\n++++++++++++++++++++++++++++++++++\n\n");   
            System.out.println(embalagem.toString());
            assertTrue("Checando ligação no sentido do ligante", Item.checkItemIsLinkedTo(massa, manteiga));
            assertTrue("Checando ligação no sentido do receptor", Item.checkItemIsLinkedFrom(manteiga, massa));
        }
                
    }

    /**
     * Test of getAllItens method, of class ItensMap.
     */
    @Test
    public void testGetAllItens() {
        System.out.println("getAllItens");
        
        ItensMap instance = new ItensMap();
        
        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item("Embalagem");
        Item massa = new Item("Massa");        
        Item alga = new Item("Alga");        
        
        ArrayList<Item> list = new ArrayList<>();
        list.add(manteiga);
        list.add(massa);
        list.add(embalagem);
        list.add(alga);
        list.add(leite);
        
        instance.addItem(manteiga);        
        instance.addItem(leite);        
        instance.addItem(embalagem);        
        instance.addItem(massa);        
        instance.addItem(alga);                       
        
        Collection<Item> expResult = list;
        Collection<Item> result = instance.getAllItens();
        assertEquals(expResult, result);                
    }

    /**
     * Test of getItem method, of class ItensMap.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        String itemName = "Leite";
        ItensMap instance = new ItensMap();
        
        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item("Embalagem");
        Item massa = new Item("Massa");        
        Item alga = new Item("Alga");        
        
        instance.addItem(manteiga);        
        instance.addItem(leite);        
        instance.addItem(embalagem);        
        instance.addItem(massa);        
        instance.addItem(alga);                       
        
        String expResult = "Leite";
        String result = instance.getItem(itemName).getName();
        assertEquals(expResult, result);                
    }          

    /**
     * Test of deleteItem method, of class ItensMap.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");        
        ItensMap instance = new ItensMap();
        
        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item ("Embalagem");
                
        instance.addItem(manteiga);
        instance.addItem(leite);
        instance.addItem(embalagem);
        
        Item massa = new Item("Massa");                
        
        Link link1 = new Link(massa, manteiga);        
        Link link2= new Link(massa, leite);
        Link link3 = new Link(massa, embalagem);
        
        massa.addLink(link1);
        massa.addLink(link2);
        massa.addLink(link3);
        
        Item bolo = new Item("Bolo");
        
        Link link4 = new Link(bolo, manteiga);        
        Link link5= new Link(bolo, leite);
        Link link6 = new Link(bolo, embalagem);
        Link link7 = new Link(bolo, massa);
        
        bolo.addLink(link4);
        bolo.addLink(link5);
        bolo.addLink(link6);
        bolo.addLink(link7);
                                
        instance.addItem(massa);                
        instance.addItem(bolo);                
        
        instance.deleteItem(manteiga.getName());        
        
        if (instance.isItemInMap(manteiga.getName())) {
            fail("Manteiga não foi deletada");
        } else if (Item.checkItemIsLinkedTo(massa, manteiga)) {
            massa = instance.getItem(massa.getName());
            System.out.println(massa.toString());
            fail("Ainda existe ligação entre massa e manteiga mesmo após a deleção da ligação");
        } else if (Item.checkItemIsLinkedTo(bolo, manteiga)) {
            bolo = instance.getItem(massa.getName());
            System.out.println(bolo.toString());
            fail("Ainda existe ligação entre bolo e manteiga mesmo após a deleção da ligação");
        }
        
        instance.deleteItem(bolo.getName());
        
        if (instance.isItemInMap(bolo.getName())) {
            fail("bolo não foi deletado");
        }else if (Item.checkItemIsLinkedFrom(leite, bolo)) {
            fail("O relacionamento de bolo e leite ainda persiste");
        }else if (Item.checkItemIsLinkedFrom(embalagem, bolo)) {
            fail("O relacionamento de bolo e embalagem ainda persiste");
        } else if (Item.checkItemIsLinkedFrom(massa, bolo)) {
            fail("O relacionamento de bolo e massa ainda persiste");
        }                
    }
    
    /**
     * Test of modifyItem method, of class ItensMap.
     */
    @Test
    public void modifyItem() {
        System.out.println("modifyItem");        
        ItensMap instance = new ItensMap();
        
        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item ("Embalagem");
                
        instance.addItem(manteiga);
        instance.addItem(leite);
        instance.addItem(embalagem);
        
        Item massa = new Item("Massa");                
        
        Link link1 = new Link(massa, manteiga);        
        Link link2= new Link(massa, leite);
        Link link3 = new Link(massa, embalagem);
        
        massa.addLink(link1);        
        massa.addLink(link3);                        
                                
        instance.addItem(massa);                        
        
        //Modificação de remoção de link
        Item newMassa1 = new Item("Massa");
        newMassa1.removeLinkFromLinkedTo(link1);
        
        instance.modifyItem(massa.getName(), newMassa1);                
        
        massa = instance.getItem("Massa");
        
        if (Item.checkItemIsLinkedFrom(manteiga, massa) && Item.checkItemIsLinkedTo(massa, manteiga) && massa.equals(newMassa1)) {
            fail("O item ainda manteve a ligação apesar da modificação");
        }        
        
        //Modificação de adicionar link
        Item newMassa2 = new Item("Massa");
        newMassa2.addLink(link2);
        instance.modifyItem(massa.getName(), newMassa2);
        
        massa = instance.getItem("Massa");
        
        if (!Item.checkItemIsLinkedFrom(leite, massa) && massa.equals(newMassa2)) {
            fail("O item não conseguiu criar uma ligação com o leite!");
        }
        
        //Modificação do identificador
        Item newMassa3 = new Item("Massa Surpresa");
        
        Link link4 = new Link(newMassa3, manteiga);
        Link link5 = new Link(newMassa3, leite);
        Link link6 = new Link(newMassa3, embalagem);
        
        newMassa3.addLink(link4);
        newMassa3.addLink(link5);
        newMassa3.addLink(link6);
                
        massa = instance.getItem("Massa");
        instance.modifyItem(massa.getName(), newMassa3);        
        
        Item newMassa4 = instance.getItem("Massa Surpresa");                
        Item newMassa5 = instance.getItem("Massa");
        
        assertNull("O item já não existe!", newMassa5);        
        assertNotNull("O objeto foi criado com sucesso!",newMassa4);               
    }
    
    @Test
    public void testGetLinksDeletedOnList() {
        System.out.println("getLinksDeleted");        
        ItensMap instance = new ItensMap();
        
        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item ("Embalagem");
                
        instance.addItem(manteiga);
        instance.addItem(leite);
        instance.addItem(embalagem);
        
        Item massa = new Item("Massa");                
        
        Link link1 = new Link(massa, manteiga);        
        Link link2= new Link(massa, leite);
        Link link3 = new Link(massa, embalagem);
        
        massa.addLink(link1);
        massa.addLink(link2);
        massa.addLink(link3);
                                                        
        instance.addItem(massa);
        Item newMassa = new Item("Massa");
        massa = instance.getItem("Massa");
                
        
        newMassa.addLink(link1);
        newMassa.addLink(link2);
        newMassa.addLink(link3);
        
        newMassa.removeLinkFromLinkedTo(link3);                
        newMassa.removeLinkFromLinkedTo(link2);
        
        ArrayList<Link> linksDeleted = Link.getLinksDeletedOnList(newMassa.getLinkedTo(), massa.getLinkedTo());
        if(linksDeleted.isEmpty()) {
            System.out.println(linksDeleted.toString());
           fail("A comparação falhou!");
        }
        
        System.out.println(linksDeleted.toString());
    }
    
    @Test
    public void testGetLinksAddedOnList() {
        System.out.println("getLinksAdded");        
        ItensMap instance = new ItensMap();
        
        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item ("Embalagem");
                
        instance.addItem(manteiga);
        instance.addItem(leite);
        instance.addItem(embalagem);
        
        Item massa = new Item("Massa");                
        
        Link link1 = new Link(massa, manteiga);        
        Link link2= new Link(massa, leite);
        Link link3 = new Link(massa, embalagem);
        
        massa.addLink(link1);        
        massa.addLink(link3);
                                                        
        instance.addItem(massa);
        Item newMassa = new Item("Massa");
        massa = instance.getItem("Massa");
                
        
        newMassa.addLink(link1);
        newMassa.addLink(link2);
        newMassa.addLink(link3);                        
        
        ArrayList<Link> linksAdded = Link.getLinksAddedOnList(newMassa.getLinkedTo(), massa.getLinkedTo());
        if(linksAdded.isEmpty()) {
            System.out.println(linksAdded.toString());
           fail("A comparação falhou!");
        }
        
        System.out.println(linksAdded.toString());
    }
    
}
