/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.memory;

import java.util.HashMap;
import model.util.FileTools;
import model.entities.CompoundFoodstock;
import model.entities.Product;
import model.entities.RecipeItem;
import model.entities.SimpleFoodstock;
import model.util.StorageTools;
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
    private static final String SIMPLE_FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\simplefoodstock.txt";
    private static final String COMPOUND_FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\compoundfoodstock.txt";
    private static final String PRODUCT_FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\product.txt";

    @BeforeClass
    public static void setUpClass() throws Exception {

        memory = new Memory();

        //Checa se os arquivos de armazenamento estão sendo criados
        if (!FileTools.checkFileExists(SIMPLE_FOODSTOCK_FILE_PATH)) {
            fail("O arquivo de armazenamento de insumos simples não foi criado");
        }

        if (!FileTools.checkFileExists(COMPOUND_FOODSTOCK_FILE_PATH)) {
            fail("O arquivo de armazenamento de insumos compostos não foi criado");
        }

        if (!FileTools.checkFileExists(PRODUCT_FOODSTOCK_FILE_PATH)) {
            fail("O arquivo de armazenamento de insumos compostos não foi criado");
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        //Deleta os arquivos de armazenamento após o teste                
        //FileTools.deleteFile(SIMPLE_FOODSTOCK_FILE_PATH);
        //FileTools.deleteFile(COMPOUND_FOODSTOCK_FILE_PATH);
        //FileTools.deleteFile(PRODUCT_FOODSTOCK_FILE_PATH);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadFile() {
        System.out.println(memory.getAllCompoundFoodstock().size());
        System.out.println(memory.getAllSimpleFoodstock().size());
        System.out.println(memory.getAllProducts().size());
    }

    /**
     * Test of insertSimpleFoodstock method, of class Memory.
     */
    @Test
    public void testInsertSimpleFoodstock() {
        System.out.println("insertSimpleFoodstock");
        SimpleFoodstock foodstock = new SimpleFoodstock("Manteiga", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(foodstock);

        for (String line : FileTools.readFile(SIMPLE_FOODSTOCK_FILE_PATH)) {
            assertEquals(line, Memory.generateSimpleFoodstockRegister(foodstock));
        }

        SimpleFoodstock foodstock2 = new SimpleFoodstock("Manteiga", "Alimentício", "g", 400.00, 6.50);
        memory.insertSimpleFoodstock(foodstock2);
    }

    /**
     * Test of getAllSimpleFoodstock method, of class Memory.
     */
    @Test
    public void testGetAllSimpleFoodstock() {

        System.out.println("getAllSimpleFoodstock");

        SimpleFoodstock simpleFoodstock2 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock2);

        SimpleFoodstock simpleFoodstock3 = new SimpleFoodstock("leite", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock3);

        assertTrue(memory.getAllSimpleFoodstock().size() == 2);
    }

    /**
     * Test of getSimpleFoodstock method, of class Memory.
     */
    @Test
    public void testGetSimpleFoodstock() {
        System.out.println("getFoodstock");
        SimpleFoodstock simpleFoodstock4;
        simpleFoodstock4 = new SimpleFoodstock("Amanteigada", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock4);

        SimpleFoodstock foodstock = memory.getSimpleFoodstock("Amanteigada");

        String exp = StorageTools.generateSimpleFoodstockRegister(simpleFoodstock4);
        String result = StorageTools.generateSimpleFoodstockRegister(foodstock);
        assertEquals(exp, result);
    }

    /**
     * Test of insertCompoundFoodstock method, of class Memory.
     */
    @Test
    public void testInsertCompoundFoodstock() {
        System.out.println("insertCompoundFoodstock");
        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item2 = new RecipeItem(compoundFoodstock, simpleFoodstock6, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item2);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        CompoundFoodstock compoundFoodstock2 = new CompoundFoodstock("Brigadeiro", "Alimentício", "kg", 1.5);

        RecipeItem item4 = new RecipeItem(compoundFoodstock2, simpleFoodstock5, 2.0, "g");
        RecipeItem item5 = new RecipeItem(compoundFoodstock2, simpleFoodstock6, 2.0, "g");
        RecipeItem item6 = new RecipeItem(compoundFoodstock2, simpleFoodstock7, 2.0, "g");

        compoundFoodstock2.addRecipeItem(item5);
        compoundFoodstock2.addRecipeItem(item4);
        compoundFoodstock2.addRecipeItem(item6);

        memory.insertCompoundFoodstock(compoundFoodstock2);

        CompoundFoodstock compoundFoodstock3 = new CompoundFoodstock("Massa especial", "Alimentício", "kg", 1.5);

        RecipeItem item7 = new RecipeItem(compoundFoodstock3, simpleFoodstock5, 2.0, "g");
        RecipeItem item8 = new RecipeItem(compoundFoodstock3, simpleFoodstock6, 2.0, "g");
        RecipeItem item9 = new RecipeItem(compoundFoodstock3, simpleFoodstock7, 2.0, "g");

        compoundFoodstock3.addRecipeItem(item7);
        compoundFoodstock3.addRecipeItem(item8);
        compoundFoodstock3.addRecipeItem(item9);

        memory.insertCompoundFoodstock(compoundFoodstock3);
    }

    /**
     * Test of getCompoundFoodstock method, of class Memory.
     */
    @Test
    public void testGetCompoundFoodstock() {
        System.out.println("getCompoundFoodstock");
        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item2 = new RecipeItem(compoundFoodstock, simpleFoodstock6, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item2);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        CompoundFoodstock result = memory.getCompoundFoodstock("Massa");

        assertEquals(Memory.generateCompoundFoodstockRegister(compoundFoodstock), Memory.generateCompoundFoodstockRegister(result));
    }

    /**
     * Test of getAllCompoundFoodstock method, of class Memory.
     */
    @Test
    public void testGetAllCompoundFoodstock() {
        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item2 = new RecipeItem(compoundFoodstock, simpleFoodstock6, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item2);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        CompoundFoodstock compoundFoodstock2 = new CompoundFoodstock("Brigadeiro", "Alimentício", "kg", 1.5);

        RecipeItem item4 = new RecipeItem(compoundFoodstock2, simpleFoodstock5, 2.0, "g");
        RecipeItem item5 = new RecipeItem(compoundFoodstock2, simpleFoodstock6, 2.0, "g");
        RecipeItem item6 = new RecipeItem(compoundFoodstock2, simpleFoodstock7, 2.0, "g");

        compoundFoodstock2.addRecipeItem(item5);
        compoundFoodstock2.addRecipeItem(item4);
        compoundFoodstock2.addRecipeItem(item6);

        memory.insertCompoundFoodstock(compoundFoodstock2);

        CompoundFoodstock compoundFoodstock3 = new CompoundFoodstock("Massa especial", "Alimentício", "kg", 1.5);

        RecipeItem item7 = new RecipeItem(compoundFoodstock3, simpleFoodstock5, 2.0, "g");
        RecipeItem item8 = new RecipeItem(compoundFoodstock3, simpleFoodstock6, 2.0, "g");
        RecipeItem item9 = new RecipeItem(compoundFoodstock3, simpleFoodstock7, 2.0, "g");

        compoundFoodstock3.addRecipeItem(item7);
        compoundFoodstock3.addRecipeItem(item8);
        compoundFoodstock3.addRecipeItem(item9);

        memory.insertCompoundFoodstock(compoundFoodstock3);

        assertTrue(memory.getAllCompoundFoodstock().size() == 3);
    }

    /**
     * Test of insertProduct method, of class Memory.
     */
    @Test
    public void testInsertProduct() {

        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        //iniciar cadastro do produto
        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        Product product = new Product("Bolo 14cm", "Alimentício", "UN", 10.0);

        RecipeItem item2 = new RecipeItem(product, simpleFoodstock6, 2.0, "g");
        RecipeItem item4 = new RecipeItem(product, compoundFoodstock, 50.0, "g");

        product.addRecipeItem(item2);
        product.addRecipeItem(item4);

        Product product3 = new Product("CreamAlgumaCoisa", "Alimentício", "UN", 10.0);
        RecipeItem item6 = new RecipeItem(product3, compoundFoodstock, 50.0, "g");
        product3.addRecipeItem(item6);

        memory.insertProduct(product3);

        memory.insertProduct(product);

        Product product2 = new Product("CreamCake", "Alimentício", "UN", 10.0);
        RecipeItem item5 = new RecipeItem(product2, compoundFoodstock, 50.0, "g");

        product2.addRecipeItem(item5);

        memory.insertProduct(product2);
    }

    /**
     * Test of getProduct method, of class Memory.
     */
    @Test
    public void testGetProduct() {
        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        //iniciar cadastro do produto
        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        Product product = new Product("Bolo 14cm", "Alimentício", "UN", 10.0);

        RecipeItem item2 = new RecipeItem(product, simpleFoodstock6, 2.0, "g");
        RecipeItem item4 = new RecipeItem(product, compoundFoodstock, 50.0, "g");

        product.addRecipeItem(item2);
        product.addRecipeItem(item4);

        memory.insertProduct(product);

        String register_expected = StorageTools.generateProductRegister(product);
        String register_resulted = StorageTools.generateProductRegister(memory.getProduct(product.getName()));

        assertEquals(register_expected, register_resulted);
    }

    /**
     * Test of getAllProducts method, of class Memory.
     */
    @Test
    public void testGetAllProducts() {
        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        //iniciar cadastro do produto
        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        Product product = new Product("Bolo 14cm", "Alimentício", "UN", 10.0);

        RecipeItem item2 = new RecipeItem(product, simpleFoodstock6, 2.0, "g");
        RecipeItem item4 = new RecipeItem(product, compoundFoodstock, 50.0, "g");

        product.addRecipeItem(item2);
        product.addRecipeItem(item4);

        memory.insertProduct(product);

        Product product2 = new Product("CreamCake", "Alimentício", "UN", 10.0);
        RecipeItem item5 = new RecipeItem(product2, compoundFoodstock, 50.0, "g");

        product2.addRecipeItem(item5);

        memory.insertProduct(product2);

        Product product3 = new Product("CreamAlgumaCoisa", "Alimentício", "UN", 10.0);
        RecipeItem item6 = new RecipeItem(product3, compoundFoodstock, 50.0, "g");
        product3.addRecipeItem(item6);

        memory.insertProduct(product3);

        int registerListSize = memory.getAllProducts().size();
        assertTrue(registerListSize == 3);
    }

    /**
     * Test of modifySimpleFoodstock method, of class Memory.
     */
    @Test
    public void testModifySimpleFoodstock() {

        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        //iniciar cadastro do produto
        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        Product product = new Product("Bolo 14cm", "Alimentício", "UN", 10.0);

        RecipeItem item2 = new RecipeItem(product, simpleFoodstock6, 2.0, "g");
        RecipeItem item4 = new RecipeItem(product, compoundFoodstock, 50.0, "g");

        product.addRecipeItem(item2);
        product.addRecipeItem(item4);

        memory.insertProduct(product);

        SimpleFoodstock modified = new SimpleFoodstock("merengue", "Alimentício", "g", 500.00, 8.50);
        memory.modify("embalagem", modified);

        CompoundFoodstock newComp = new CompoundFoodstock("Massa surpresa", "Alimentício", "kg", 1.5);
        RecipeItem item6 = new RecipeItem(newComp, simpleFoodstock5, 2.0, "g");
        newComp.addRecipeItem(item6);
        memory.modify("Massa", newComp);

        Product product2 = new Product("Bolo 15cm", "Alimentício", "UN", 10.0);
        
        RecipeItem item7 = new RecipeItem(product2, modified, 2.0, "g");
        RecipeItem item8 = new RecipeItem(product2, newComp, 50.0, "g");
        
        product2.addRecipeItem(item8);
        product2.addRecipeItem(item7);
        
        memory.modify("Bolo 14cm", product2);
    }

    /**
     * Test of deleteSimpleFoodstock method, of class Memory.
     */
    @Test
    public void testDeleteSimpleFoodstock() {
        SimpleFoodstock simpleFoodstock5 = new SimpleFoodstock("ninho", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock5);

        SimpleFoodstock simpleFoodstock7 = new SimpleFoodstock("nutela", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock7);

        CompoundFoodstock compoundFoodstock = new CompoundFoodstock("Massa", "Alimentício", "kg", 1.5);

        RecipeItem item1 = new RecipeItem(compoundFoodstock, simpleFoodstock5, 2.0, "g");
        RecipeItem item3 = new RecipeItem(compoundFoodstock, simpleFoodstock7, 2.0, "g");

        compoundFoodstock.addRecipeItem(item1);
        compoundFoodstock.addRecipeItem(item3);

        memory.insertCompoundFoodstock(compoundFoodstock);

        //iniciar cadastro do produto
        SimpleFoodstock simpleFoodstock6 = new SimpleFoodstock("embalagem", "Alimentício", "g", 500.00, 8.50);
        memory.insertSimpleFoodstock(simpleFoodstock6);

        Product product = new Product("Bolo 14cm", "Alimentício", "UN", 10.0);

        RecipeItem item2 = new RecipeItem(product, simpleFoodstock6, 2.0, "g");
        RecipeItem item4 = new RecipeItem(product, compoundFoodstock, 50.0, "g");

        product.addRecipeItem(item2);
        product.addRecipeItem(item4);

        memory.insertProduct(product);

        memory.delete(simpleFoodstock5.getName());
    }

    /**
     * Test of createSimpleFoodstockByRegister method, of class Memory.
     */
    @Test
    public void testCreateSimpleFoodstockByRegister() {
    }
}
