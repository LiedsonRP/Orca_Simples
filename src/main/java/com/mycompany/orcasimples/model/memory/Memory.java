/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.model.memory;

import com.mycompany.orcasimples.model.util.StorageTools;
import java.util.ArrayList;
import com.mycompany.orcasimples.model.entities.CompoundFoodstock;
import com.mycompany.orcasimples.model.entities.Product;
import com.mycompany.orcasimples.model.entities.SimpleFoodstock;
import com.mycompany.orcasimples.model.util.FileTools;

/**
 * Classe que cuida da memória principal do sistema, sendo responsável por
 * armazenar os itens, enquanto com o auxilio do RelationMap, permite a integridade
 * de suas ligações.
 *
 * @author lieds
 */
public class Memory extends StorageTools {
    /**
     * Caminho do arquivo de insumos simples
     */
    private static final String SIMPLE_FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\simplefoodstock.txt";
    /**
     * Caminho do arquivo de insumos compostos
     */
    private static final String COMPOUND_FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\compoundfoodstock.txt";
    /**
     * Caminho do arquivo de produtos
     */
    private static final String PRODUCT_FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\product.txt";    
    /**
     * Mapa de relacionamento entre itens
     */
    private static RelationMap itensMap;

    /**
     * Método construtor responsável por inicializar a memória, tendo a função
     * de checar se os arquivos de armazenamento existem e caso não os cria,
     * para logo em seguida carregar seus dados na memória. Importante notar que os itens
     * devem ser carregados de acordo com o quão base eles são, sendo nisso o insumo simples
     * o item mais básico por nunca fazer uma ligação mas participar, sendo seguido pelo insumo composto
     * e pelo produto.
     */
    public Memory() {

        itensMap = new RelationMap();
        
        Memory.createStorageFileIfNotExists(SIMPLE_FOODSTOCK_FILE_PATH);
        Memory.createStorageFileIfNotExists(COMPOUND_FOODSTOCK_FILE_PATH);
        Memory.createStorageFileIfNotExists(PRODUCT_FOODSTOCK_FILE_PATH);        
        
        this.loadSimpleFoodstockRegisters();
        this.loadCompoundFoodstockRegisters();
        this.loadProductRegisters();
    }
    
    /**
     * Verifica se um item existe no mapa de itens.
     * @param itemName Nome do item a ser buscado
     * @return Retorna true caso o item esteja no mapa e false caso não.
     */
    public boolean checkIfItemExists(String itemName) {
        return itensMap.isItemInMap(itemName);
    }

    /**
     * Adiciona um insumo simples na memória por meio do mapa de relacionamentos
     *
     * @param foodstock objeto do tipo SimpleFoodstock que deverá ser cadastrado
     * @trows IllegalArgumentException
     */
    public void insertSimpleFoodstock(SimpleFoodstock foodstock) {
        if (!itensMap.isItemInMap(foodstock)) {
            itensMap.addItem(foodstock);
            saveInSimpleFoodstockFile();
        }
    }

    /**
     * Retorna um objeto de insumos simples contido no mapa de relacionamentos
     *
     * @param identifier String contendo o identificador de acesso do registro
     * @return Retorna um objeto do tipo SimpleFoodstock, contendo as ligações
     * do objeto
     */
    public SimpleFoodstock getSimpleFoodstock(String identifier) {
        return (SimpleFoodstock) itensMap.getItem(identifier);
    }

    /**
     * Retorna todos os insumos simples armazenados no mapa de relacionamentos.
     *
     * @return ArrayList contendo um conjunto de objetos do tipo SimpleFoodstock
     * referente
     */
    public ArrayList<SimpleFoodstock> getAllSimpleFoodstock() {

        ArrayList<SimpleFoodstock> foodstockList = new ArrayList<>();

        for (Item item : itensMap.getAllItens()) {
            if (item instanceof SimpleFoodstock) {
                SimpleFoodstock foodstock = (SimpleFoodstock) item;
                foodstockList.add(foodstock);
            }
        }

        return foodstockList;
    }

    /**
     * modifica um item que já existe no mapa de relacionamento,
     * garantindo que no caso qualquer alteração no identificador ou nos links
     * possam ser passadas corretamente para os outros itens que possuam alguma
     * relação com ele.
     *
     * @param oldItemName nome do item a ser modificado
     * @param newItem novo item que pode ter tido tanto seu modificador como
     * links modificados
     */
    public void modify(String oldItemName, Item newItem) {
        if (itensMap.isItemInMap(oldItemName)) {
            itensMap.modifyItem(oldItemName, newItem);
            this.saveAll();
        }

    }
    /**
     * Deleta um item e sua ligações com outros itens no mapa de relacionamento
     * @param identifier String contendo o identificador do insumo a ser deletado
     */
    public void delete(String identifier) {
        if(itensMap.isItemInMap(identifier)) {
            itensMap.deleteItem(identifier);
            this.saveAll();
        }
    }

    /**
     * Adiciona um insumo composto na memória por meio do mapa de relacionamentos
     *
     * @param foodstock objeto do tipo CompoundFoodstock que deverá ser
     * cadastrado
     * @trows IllegalArgumentException
     */
    public void insertCompoundFoodstock(CompoundFoodstock foodstock) {
        if (!itensMap.isItemInMap(foodstock)) {
            itensMap.addItem(foodstock);
            this.saveInSimpleFoodstockFile();
            this.saveInCompoundFoodstockFile();
        }
    }

    /**
     * Retorna um insumo composto junto de sua receita através de um
     * identificador
     *
     * @param identifier identificador do insumo composto
     * @return Retorna um objeto do tipo CompoundFoodstock com o insumo composto
     * referente ao identificador
     */
    public CompoundFoodstock getCompoundFoodstock(String identifier) {
        return (CompoundFoodstock) itensMap.getItem(identifier);
    }

    /**
     * Retorna todos os produtos armazenados no mapa de relacionamentos.
     *
     * @return ArrayList contendo um conjunto de objetos do tipo
     * CompoundFoodstock
     */
    public ArrayList<CompoundFoodstock> getAllCompoundFoodstock() {
        ArrayList<CompoundFoodstock> foodstockList = new ArrayList<>();

        for (Item item : itensMap.getAllItens()) {
            if (item instanceof CompoundFoodstock) {
                CompoundFoodstock foodstock = (CompoundFoodstock) item;
                foodstockList.add(foodstock);
            }
        }

        return foodstockList;
    }        

    /**
     * Adiciona um produto na memória por meio do mapa de relacionamentos
     *
     * @param product objeto do tipo Product que deverá ser cadastrado
     * @trows IllegalArgumentException
     */
    public void insertProduct(Product product) {
        if (!itensMap.isItemInMap(product)) {
            itensMap.addItem(product);
            this.saveAll();
        }
    }

    /**
     * Retorna um produto junto de sua receita através de um identificador
     *
     * @param identifier identificador do produto
     * @return Retorna um objeto do tipo produto referente ao identificador
     */
    public Product getProduct(String identifier) {
        return (Product) itensMap.getItem(identifier);
    }

    /**
     * Retorna todos os produtos armazenados no mapa de relacionamentos.
     *
     * @return ArrayList contendo um conjunto de objetos do tipo Product     
     */
    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> productList = new ArrayList<>();

        for (Item item : itensMap.getAllItens()) {
            if (item instanceof Product) {
                Product product = (Product) item;
                productList.add(product);
            }
        }

        return productList;
    }

    /**
     * Salva todos os registros contidos na memória de insumos simples no
     * arquivo de armazenamento.
     */
    private void saveInSimpleFoodstockFile() {

        String file_info = "";

        for (Item item : itensMap.getAllItens()) {
            if (item instanceof SimpleFoodstock) {
                SimpleFoodstock foodstock = (SimpleFoodstock) item;
                file_info = file_info.concat(StorageTools.generateSimpleFoodstockRegister(foodstock)).concat("\n");
            }
        }

        FileTools.writeFile(file_info, SIMPLE_FOODSTOCK_FILE_PATH);
    }

    /**
     * Salva os registros da lista de insumos compostos no arquivo de
     * armazenamento.
     */
    private void saveInCompoundFoodstockFile() {
        String file_info = "";

        for (Item item : itensMap.getAllItens()) {
            if (item instanceof CompoundFoodstock) {
                CompoundFoodstock foodstock = (CompoundFoodstock) item;
                file_info = file_info.concat(StorageTools.generateCompoundFoodstockRegister(foodstock)).concat("\n");
            }
        }

        FileTools.writeFile(file_info, COMPOUND_FOODSTOCK_FILE_PATH);
    }

    /**
     * Salva os registros da lista de produtos no arquivo de
     * armazenamento.
     */
    private void saveInProductFile() {
        String file_info = "";

        for (Item item : itensMap.getAllItens()) {
            if (item instanceof Product) {
                Product product = (Product) item;
                file_info = file_info.concat(StorageTools.generateProductRegister(product)).concat("\n");
            }
        }

        FileTools.writeFile(file_info, PRODUCT_FOODSTOCK_FILE_PATH);
    }

    /**
     * Preenche a memória com todos os registros salvos no arquivo de
     * armazenamento de insumos simples.
     */
    private void loadSimpleFoodstockRegisters() {

        ArrayList<String> registers = Memory.loadRegistersFromFile(SIMPLE_FOODSTOCK_FILE_PATH);

        for (String register : registers) {
            SimpleFoodstock simpleFoodstock = this.createSimpleFoodstockByRegister(register);            
            itensMap.addItem(simpleFoodstock);
        }
    }

    /**
     * Preenche a memória com todos os registros salvos no arquivo de
     * armazenamento de insumos composto.
     */
    private void loadCompoundFoodstockRegisters() {

        ArrayList<String> registers = Memory.loadRegistersFromFile(COMPOUND_FOODSTOCK_FILE_PATH);

        for (String register : registers) {
            CompoundFoodstock compoundFoodstock = this.createCompoundFoodstockFromRegister(register);
            itensMap.addItem(compoundFoodstock);
        }
    }
    
    /**
     * Preenche a memória com todos os registros salvos no arquivo de
     * armazenamento de produtos.
     */
    private void loadProductRegisters() {

        ArrayList<String> registers = Memory.loadRegistersFromFile(PRODUCT_FOODSTOCK_FILE_PATH);

        for (String register : registers) {
            Product product = this.createProductFromRegister(register);
            itensMap.addItem(product);
        }
    }
    
    /**
     * Salva cada item em seu arquivo de armazenamento
     */
    private void saveAll() {
        this.saveInSimpleFoodstockFile();
        this.saveInCompoundFoodstockFile();
        this.saveInProductFile();
    }

    /**
     * Cria um objeto do tipo SimpleFoodstock (insumos simples) com base num
     * registro do armazenamento.
     *
     * @param register registro que guarda as informações do item
     * @return Retorna um objeto do tipo SimpleFoodstock sem suas ligações.
     */
    public SimpleFoodstock createSimpleFoodstockByRegister(String register) {

        String[] parts = StorageTools.separateRegistersPart(register);
        String[] info = StorageTools.separateDataFromRegister(parts[0]);

        Double quant_purchase = Double.valueOf(info[3]);
        Double value_payed = Double.valueOf(info[4]);

        return new SimpleFoodstock(info[0], info[1], info[2], quant_purchase, value_payed);
    }

    /**
     * Retorna um insumo composto junto junto de suas ligações feitas (linkedTo) com base
     * num registro.
     *
     * @param register registro do insumo composto
     * @return Um objeto do tipo CompoundFoodstock com suas ligações
     */
    private CompoundFoodstock createCompoundFoodstockFromRegister(String register) {

        String[] info = StorageTools.getItemRegisterDataInfo(register);
        Double quant_produced = Double.valueOf(info[3]);
        CompoundFoodstock compoundFoodstock = new CompoundFoodstock(info[0], info[1], info[2], quant_produced);

        String[] linkedTo = StorageTools.getLinkedToPart(register);
        ArrayList<RecipeItem> recipe = this.createLinksFromLinkedToByRegister(compoundFoodstock, linkedTo);
        compoundFoodstock.setLinkedTo(recipe);

        return compoundFoodstock;
    }
    
    /**
     * Retorna um produto junto junto de suas ligações feitas (linkedTo) com base
     * num registro.
     *
     * @param register registro do produto
     * @return Um objeto do tipo Product com suas ligações
     */
    private Product createProductFromRegister(String register) {

        String[] info = StorageTools.getItemRegisterDataInfo(register);
        Double quant_produced = Double.valueOf(info[3]);
        Product product = new Product(info[0], info[1], info[2], quant_produced);

        String[] linkedTo = StorageTools.getLinkedToPart(register);
        ArrayList<RecipeItem> recipe = this.createLinksFromLinkedToByRegister(product, linkedTo);
        product.setLinkedTo(recipe);

        return product;
    }

    /**
     * Recebe uma lista com as partes do registro que representam links do
     * linkedTo e retorna uma lista contendo os objetos de links.
     *
     * @param linkedOwner objeto de item genêrico Item que iniciou a ligação
     * @param linkedToPart array de String contendo a lista de registros de
     * links
     * @return Retorna uma ArrayList contendo os links criados através dos
     * registros
     */
    private ArrayList<RecipeItem> createLinksFromLinkedToByRegister(Item linkedOwner, String[] linkedToPart) {

        ArrayList<RecipeItem> recipe = new ArrayList<>();
        RecipeItem recipeItem = null;

        for (String linkRegister : linkedToPart) {

            String[] dataLink = StorageTools.separateDataFromRegister(linkRegister);
            Double quant_used = Double.valueOf(dataLink[1]);
            Item item = itensMap.getItem(dataLink[0]);

            recipeItem = new RecipeItem(linkedOwner, item, quant_used, dataLink[2]);
            recipe.add(recipeItem);
        }

        return recipe;
    }        
}
