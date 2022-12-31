/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.memory;

import java.util.ArrayList;
import model.entities.Item;
import model.entities.SimpleFoodstock;

/**
 * Classe responsável por gerenciar a memória principal do sistema
 * @author lieds
 */
public class Memory {                
    
    private static final String PRODUCT_FILE_PATH = "";
    private static final String FOODSTOCK_FILE_PATH = "C:\\Users\\lieds\\OneDrive\\Documentos\\GitHub\\Orca_simples\\Orca_simples\\Foodstck.txt";        
    
    private static ItensMap map;
    private static ArrayList<ArrayList> foodstockRecorded;
    
    public Memory() {        
        if (Memory.map == null) {
            map = new ItensMap();
        }
        //checa se os arquivos de armazenamento existem
        if (!FileManagement.checkFileExists(FOODSTOCK_FILE_PATH)) {
            //inserir a criação do arquivo
        }
        
        if(!FileManagement.checkFileExists(PRODUCT_FILE_PATH)) {
            //inserir a criação do arquivo
        }                                
    }
        
    public void addItem(Item item) {        
        Memory.map.addItem(item);
    }
    
    public Item getItem(String itemName) {
        return Memory.map.getItem(itemName);
    }
    
    public void getAllRecordedFoodstocks() {
        
    }
    
    public void saveFoodstocks() {
        
    }
    
}
