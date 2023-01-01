/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.memory;

import java.util.ArrayList;
import java.util.HashMap;
import model.entities.CompoundFoodstock;
import model.entities.Item;
import model.entities.Product;
import model.entities.SimpleFoodstock;

/**
 * Classe responsável por manipular a memória do sistema
 *
 * @author lieds
 */
public class Memory {

    private static final String PRODUCT_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\Product.txt";
    private static final String FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\Foodstck.txt";

    /**
     * Mapa dos itens cadastrados pelo usuário e seus relacionamentos
     */
    private static ItensMap map;
    /**
     * Mapa de registros dos insumos
     */
    private static HashMap<String, String> foodstockRegisterMap;
    /**
     * Mapa de registros dos produtos
     */
    private static HashMap<String, String> productRegisterMap;
    /**
     * Método construtor responsável por inicializar a memória do sistema, observando se:
     * 
     * 1 - Os arquivos de armazenamento foram já criados e se não os cria
     * 2 - Povoa o mapa de itens com os dados dos arquivos
     */
    public Memory() {
        if (Memory.map == null) {
            map = new ItensMap();
        }
        //checa se os arquivos de armazenamento existem
        if (!FileManagement.checkFileExists(FOODSTOCK_FILE_PATH)) {
            FileManagement.createFile(FOODSTOCK_FILE_PATH);
        }

        if (!FileManagement.checkFileExists(PRODUCT_FILE_PATH)) {
            FileManagement.createFile(PRODUCT_FILE_PATH);
        }
        
        //Povoar o mapa com itens salvos nos arquivos caso preenchidos
    }
    /**
     * Adiciona um item qualquer no mapa de itens e no arquivo de armazenamento
     * @param item 
     */
    public void addItem(Item item) {                
        //Importante verificar se o item é um insumo ou produto
    }
    /**
     * Deleta um item do mapa de itens e do arquivo de armazenamento
     *
     * @param itemName
     */
    public void deleteItem(String itemName) {
        //Importante verificar se o item é um insumo ou produto
    }
    /**
     * Modifica o registro de um item no mapa de itens e salva as alterações na memória de armazenamento
     * @param itemName
     * @param newItem 
     */
    public void modifyItem(String itemName, Item newItem) {    
        //Importante verificar se o item é um insumo ou produto
    }
    /**
     * Retorna um produto específico da memória
     *
     * @param itemName
     * @return
     */
    public Product getProduct(String itemName) {
        return null;
    }
    /**
     * Retorna um insumo simples específico da memória
     *
     * @param itemName
     * @return
     */
    public SimpleFoodstock getSimpleFoodstock(String itemName) {
        return null;
    }
    /**
     * Retorna um insumo composto específico da Memória
     *
     * @param itemName
     * @return
     */
    public CompoundFoodstock getCompoundFoodstock(String itemName) {
        return null;
    }
    /**
     * Retorna os insumos simples no mapa de arquivos
     *
     * @return
     */
    public ArrayList<SimpleFoodstock> getAllSimpleFoodstocks() {
        return null;
    }
    /**
     * Retorna todos os insumos compostos cadastrados no arquivo de
     * armazenamento
     *
     * @return
     */
    public ArrayList<CompoundFoodstock> getAllCompoundFoodstock() {
        return null;
    }
    /**
     * Retorna os produtos cadastrados
     *
     * @return
     */
    public ArrayList<Product> getAllProducts() {
        return null;
    }    
    /**
     * Salva os produtos do mapa no arquivo de armazenamento
     */
    public void saveProducts() {

    }
    /**
     * Salva os insumos do mapa no arquivo de armazenamento
     */    
    public void saveFoodstocks() {

    }
}
