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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lieds
 */
public class ItensMapTest {

    public static ItensMap instance;

    @Before
    public void setUp() {
        instance = new ItensMap();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of checkItemIsLinkedTo method, of class ItensMap.
     */
    @Test
    public void testCheckItemIsLinkedTo() {
        System.out.println("checkItemIsLinkedTo");
        //configura a manteiga
        Item manteiga = new Item("Manteiga");

        //Configura a massa
        Item massa = new Item("Massa");
        Link massa_manteiga = new Link(massa, manteiga);
        massa.addLink(massa_manteiga);
        manteiga.receiveLink(massa_manteiga);

        assertTrue("O itens não possuem ligação!", instance.checkItemIsLinkedTo(massa, manteiga));
    }

    /**
     * Test of checkItemIsLinkedFrom method, of class ItensMap.
     */
    @Test
    public void testCheckItemIsLinkedFrom() {
        //configura a manteiga
        Item manteiga = new Item("Manteiga");

        //Configura a massa
        Item massa = new Item("Massa");
        Link massa_manteiga = new Link(massa, manteiga);

        massa.addLink(massa_manteiga);
        manteiga.receiveLink(massa_manteiga);

        assertTrue("O itens não possuem ligação!", instance.checkItemIsLinkedTo(massa, manteiga));
    }

    /**
     * Test of checkItensIsLinked method, of class ItensMap.
     */
    @Test
    public void testCheckItensIsLinked() {
        System.out.println("checkItensIsLinked");
        //configura a manteiga
        Item manteiga = new Item("Manteiga");

        //Configura a massa
        Item massa = new Item("Massa");
        Link massa_manteiga = new Link(massa, manteiga);

        massa.addLink(massa_manteiga);
        manteiga.receiveLink(massa_manteiga);

        assertTrue("O itens não possuem ligação!", instance.checkItensIsLinked(massa, manteiga));
    }

    /**
     * Test of addItem method, of class ItensMap.
     */
    @Test
    public void testAddItem() {
        //Teste do item simples
        System.out.println("addSimpleItem");
        Item manteiga = new Item("Manteiga");
        instance.addItem(manteiga);

        try {
            System.out.println("Checando se aceita cadastro repitido");
            instance.addItem(manteiga);
            fail("O item já existe, porém foi cadastrado");
        } catch (IllegalArgumentException ex) {
            //Teste do item composto
            System.out.println("addCompoundItem");

            Item leite = new Item("Leite");
            instance.addItem(leite);

            Item embalagem = new Item("Embalagem");
            instance.addItem(embalagem);

            //configura a massa e suas ligações
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
            } catch (IllegalArgumentException ext) {
                //Teste na manteiga
                assertTrue("Checando ligação no sentido do ligante (massa-manteiga)", instance.checkItemIsLinkedTo(massa, manteiga));
                assertTrue("Checando ligação no sentido do receptor(massa-manteiga)", instance.checkItemIsLinkedFrom(manteiga, massa));
                //Teste no leite
                assertTrue("Checando ligação no sentido do ligante(massa-leite)", instance.checkItemIsLinkedTo(massa, leite));
                assertTrue("Checando ligação no sentido do receptor(massa-leite)", instance.checkItemIsLinkedFrom(leite, massa));
                //Teste na embalagem
                assertTrue("Checando ligação no sentido do ligante(massa-embalagem)", instance.checkItemIsLinkedTo(massa, embalagem));
                assertTrue("Checando ligação no sentido do receptor(massa-embalagem)", instance.checkItemIsLinkedFrom(embalagem, massa));
            }
        }
    }

    /**
     * Test of getAllItens method, of class ItensMap.
     */
    @Test
    public void testGetAllItens() {
        System.out.println("getAllItens");

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

        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item("Embalagem");

        instance.addItem(manteiga);
        instance.addItem(leite);
        instance.addItem(embalagem);

        Item massa = new Item("Massa");

        Link link1 = new Link(massa, manteiga);
        Link link2 = new Link(massa, leite);
        Link link3 = new Link(massa, embalagem);

        massa.addLink(link1);
        massa.addLink(link2);
        massa.addLink(link3);

        Item bolo = new Item("Bolo");

        Link link4 = new Link(bolo, manteiga);
        Link link5 = new Link(bolo, leite);
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
        } else if (instance.checkItemIsLinkedTo(massa, manteiga)) {
            massa = instance.getItem(massa.getName());
            System.out.println(massa.toString());
            fail("Ainda existe ligação entre massa e manteiga mesmo após a deleção da ligação");
        } else if (instance.checkItemIsLinkedTo(bolo, manteiga)) {
            bolo = instance.getItem(massa.getName());
            System.out.println(bolo.toString());
            fail("Ainda existe ligação entre bolo e manteiga mesmo após a deleção da ligação");
        }

        instance.deleteItem(bolo.getName());

        if (instance.isItemInMap(bolo.getName())) {
            fail("bolo não foi deletado");
        } else if (instance.checkItemIsLinkedFrom(leite, bolo)) {
            fail("O relacionamento de bolo e leite ainda persiste");
        } else if (instance.checkItemIsLinkedFrom(embalagem, bolo)) {
            fail("O relacionamento de bolo e embalagem ainda persiste");
        } else if (instance.checkItemIsLinkedFrom(massa, bolo)) {
            fail("O relacionamento de bolo e massa ainda persiste");
        }
    }

    /**
     * Test of modifyItem method, of class ItensMap.
     */
    @Test
    public void testModifyItem() {
        System.out.println("modifyItem");

        Item manteiga = new Item("Manteiga");
        Item leite = new Item("Leite");
        Item embalagem = new Item("Embalagem");

        instance.addItem(manteiga);
        instance.addItem(leite);
        instance.addItem(embalagem);

        Item massa = new Item("Massa");

        Link link1 = new Link(massa, manteiga);
        Link link2 = new Link(massa, leite);
        Link link3 = new Link(massa, embalagem);

        massa.addLink(link1);
        massa.addLink(link3);

        instance.addItem(massa);

        //Modificação de remoção de link
        Item newMassa1 = new Item("Massa");
        newMassa1.removeLinkFromLinkedTo(link1);

        instance.modifyItem(massa.getName(), newMassa1);

        massa = instance.getItem("Massa");

        if (instance.checkItemIsLinkedFrom(manteiga, massa) && instance.checkItemIsLinkedTo(massa, manteiga) && massa.equals(newMassa1)) {
            fail("O item ainda manteve a ligação apesar da modificação");
        }

        //Modificação de adicionar link
        Item newMassa2 = new Item("Massa");
        newMassa2.addLink(link2);
        instance.modifyItem(massa.getName(), newMassa2);

        massa = instance.getItem("Massa");

        if (!instance.checkItemIsLinkedFrom(leite, massa) && massa.equals(newMassa2)) {
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
        assertNotNull("O objeto foi criado com sucesso!", newMassa4);
    }    
}