/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.memory;

import java.util.ArrayList;
import model.entities.CompoundFoodstock;
import model.entities.Item;
import model.entities.Product;
import model.entities.RecipeItem;
import model.entities.SimpleFoodstock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author lieds
 */
public class MemoryTest {        
    
    static Memory memory;                
    private static final String FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\Foodstck.txt";
    private static final String PRODUCT_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\Product.txt";

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        memory = new Memory();
        
        //Checa se os arquivos de armazenamento estão sendo criados
        if(!FileManagement.checkFileExists(FOODSTOCK_FILE_PATH)) {
            fail("O arquivo de armazenamento de insumos não foi criado");
        }
        
        if(!FileManagement.checkFileExists(PRODUCT_FILE_PATH)) {
            fail("O arquivo de armazenamento de produtos não foi criado");
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        //Deleta os arquivos de armazenamento após o teste
        FileManagement.deleteFile(FOODSTOCK_FILE_PATH);
        FileManagement.deleteFile(PRODUCT_FILE_PATH);
    }        
    
    @Before
    public void setUp() {        
    }
    
    @After
    public void tearDown() {
    }   

    /**
     * Test of addItem method, of class Memory.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");        
        
        SimpleFoodstock simpleFoodstock = new SimpleFoodstock("Manteiga", "Alimentício", "g", 500.00, 8.50);
        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 0.5);
        Product product = new Product("Bolo", "Alimentício", "UN", 1.0);                
        
        RecipeItem itemR1 = new RecipeItem(product, product, 0, PRODUCT_FILE_PATH);
    }    

    /**
     * Test of deleteItem method, of class Memory.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");        
    }

    /**
     * Test of modifyItem method, of class Memory.
     */
    @Test
    public void testModifyItem() {
        System.out.println("modifyItem");        
    }

    /**
     * Test of getProduct method, of class Memory.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");       
    }

    /**
     * Test of getSimpleFoodstock method, of class Memory.
     */
    @Test
    public void testGetSimpleFoodstock() {
        System.out.println("getSimpleFoodstock");        
    }

    /**
     * Test of getCompoundFoodstock method, of class Memory.
     */
    @Test
    public void testGetCompoundFoodstock() {
        System.out.println("getCompoundFoodstock");        
    }

    /**
     * Test of getAllSimpleFoodstocks method, of class Memory.
     */
    @Test
    public void testGetAllSimpleFoodstocks() {
        System.out.println("getAllSimpleFoodstocks");        
    }

    /**
     * Test of getAllCompoundFoodstock method, of class Memory.
     */
    @Test
    public void testGetAllCompoundFoodstock() {
        System.out.println("getAllCompoundFoodstock");        
    }

    /**
     * Test of getAllProducts method, of class Memory.
     */
    @Test
    public void testGetAllProducts() {
        System.out.println("getAllProducts");        
    }

    /**
     * Test of saveProducts method, of class Memory.
     */
    @Test
    public void testSaveProducts() {
        System.out.println("saveProducts");        
    }

    /**
     * Test of saveFoodstocks method, of class Memory.
     */
    @Test
    public void testSaveFoodstocks() {
        System.out.println("saveFoodstocks");        
    }
}
