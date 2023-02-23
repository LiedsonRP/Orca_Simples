/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.model.util;

import java.util.ArrayList;
import com.mycompany.orcasimples.model.entities.CompoundFoodstock;
import com.mycompany.orcasimples.model.entities.Product;
import com.mycompany.orcasimples.model.entities.RecipeItem;
import com.mycompany.orcasimples.model.entities.SimpleFoodstock;

/**
 * Classe responsável por gerenciar as funções necessárias para manipular os
 * arquivos de armazanenamento, o que engloba a conversão de objetos para
 * registros, registros para objetos e sua escrita e leitura nos arquivos de
 * armazenamento.
 *
 * @author lieds
 */
public class StorageTools {

    /**
     * Separador das partes do registro
     */
    public static final String registerPartSeparator = ";";
    /**
     * Separador de registros de links
     */
    public static final String registerLinkSeparator = "/";
    /**
     * Separador dos dados do registro
     */
    public static final String registerDataSeparator = ",";

    /**
     * Separa as partes do registros em um Array
     *
     * @param line line de registro
     * @return Retorna um Array contendo as partes do registro
     */
    public static String[] separateRegistersPart(String line) {
        return line.split(StorageTools.registerPartSeparator);
    }

    /**
     * Separa um conjunto de links numa lista
     *
     * @param linksRegistersPart conjunto de registros dos links
     * @return Retorna um array contendo uma lista de registros de links
     */
    public static String[] separateLinksPart(String linksRegistersPart) {
        return linksRegistersPart.split(StorageTools.registerLinkSeparator);
    }

    /**
     * Separa os dados de um conjunto e retorna um array
     *
     * @param registerPart parte de um registro
     * @return Retorna os dados de um registro organizados num Array
     */
    public static String[] separateDataFromRegister(String registerPart) {
        return registerPart.split(StorageTools.registerDataSeparator);
    }

    /**
     * Retorna as informações de um item sem as ligações feitas por ele
     *
     * @param register registro do item
     * @return Um Array contendo os dados principais sobre o item
     */
    public static String[] getItemRegisterDataInfo(String register) {
        String[] parts = StorageTools.separateRegistersPart(register);
        String[] data = StorageTools.separateDataFromRegister(parts[0]);
        return data;
    }

    /**
     * Retorna parte do registro que armazenada as ligações recebidas pelo item
     *
     * @param register registro do item
     * @return Retorna uma String contendo o LinkedFrom(Ligações recebidas) do
     * item
     */
    public static String[] getLinkedFromPart(String register) {
        String[] parts = StorageTools.separateRegistersPart(register);
        String[] links = StorageTools.separateLinksPart(parts[1]);        
        return links;
    }

    /**
     * Retorna parte do registro que armazenada as ligações iniciadas pelo item
     *
     * @param register registro do item
     * @return Retorna uma String contendo o LinkedTo(Ligações feitas) do item
     */
    public static String[] getLinkedToPart(String register) {
        
        String[] links;
        String[] parts = StorageTools.separateRegistersPart(register);        
        
        if (parts.length == 2) {
            links = StorageTools.separateLinksPart(parts[1]);        
        } else {
            links = StorageTools.separateLinksPart(parts[2]);        
        }
        
        return links;
    }
    
    /**
     * Retorna a quantidade de partes que compõem o registro
     * @param register registro do item
     * @return Retorna o número de partes que possui o registro
     */
    public static int getNumParts(String register) {
        return StorageTools.separateRegistersPart(register).length;
    }

    /**
     * Retorna o os registro dos itens cadastrados no arquivo de armazenamento
     * caso o arquivo exista.
     *
     * @param file_path caminho do arquivo
     * @return Retonar uma ArrayList de Strings contendo os registros salvos num
     * arquivo de armazenamento
     */
    protected static ArrayList<String> loadRegistersFromFile(String file_path) {

        if (FileTools.checkFileExists(file_path)) {
            return new ArrayList(FileTools.readFile(file_path));
        }

        return null;
    }

    /**
     * Verifica se um arquivo de armazenamento existe no endereço especificado e
     * o cria caso não.
     *
     * @param file_path caminho onde deve estar o arquivo
     */
    protected static void createStorageFileIfNotExists(String file_path) {
        if (!FileTools.checkFileExists(file_path)) {
            FileTools.createFile(file_path);
        }
    }   

    /**
     * Cria o registro de um insumos simples para que possa ser armazenado na
     * lista de registros.
     *
     * @param foodstock insumo simples que será convertido num registro
     * @return Uma String contendo o registro que representa o objeto
     */
    public static String generateSimpleFoodstockRegister(SimpleFoodstock foodstock) {
        String dataSeparator = StorageTools.registerDataSeparator;
        String partSeparator = StorageTools.registerPartSeparator;

        return foodstock.getName() + dataSeparator
                + foodstock.getType() + dataSeparator
                + foodstock.getUnit_measurement() + dataSeparator
                + foodstock.getQuant_purchased() + dataSeparator
                + foodstock.getValue_payed() + partSeparator
                + StorageTools.createLinkedFromRegisterLinks(foodstock.getLinkedFrom());
    }    

    /**
     * Retorna o registro que representa o insumo composto na memória
     *
     * @param foodstock Objeto do tipo CompoundFoodstock (Insumo Composto) que
     * será transformado em registro
     * @return Uma String contendo o registro que representa o objeto
     */
    public static String generateCompoundFoodstockRegister(CompoundFoodstock foodstock) {

        String dataSeparator = StorageTools.registerDataSeparator;
        String partSeparator = StorageTools.registerPartSeparator;

        return foodstock.getName() + ","
                + foodstock.getType() + dataSeparator
                + foodstock.getUnit_measurement() + dataSeparator
                + foodstock.getQuant_produced() + partSeparator
                + createLinkedFromRegisterLinks(foodstock.getLinkedFrom()) + partSeparator
                + createLinkedToRegisterLinks(foodstock.getLinkedTo());
    }   

    /**
     * Retorna o registro que representa o produto na memória
     *
     * @param product objeto do tipo Product (Produto) que será transformado em
     * registro
     * @return Uma String contendo o registro que representa o objeto
     */
    public static String generateProductRegister(Product product) {

        String dataSeparator = StorageTools.registerDataSeparator;
        String partSeparator = StorageTools.registerPartSeparator;

        return product.getName() + dataSeparator
                + product.getType() + dataSeparator
                + product.getUnit_measurement() + dataSeparator
                + product.getQuant_produced() + partSeparator
                + createLinkedToRegisterLinks(product.getLinkedTo());
    }

    /**
     * Retorna o registro que representa o link entre os itens no linkedTo
     *
     * @param link link que será convertido num registro
     * @return Retorna um registro contendo as informações do link
     */
    public static String generateLinkedToRegister(RecipeItem link) {

        String separator = StorageTools.registerDataSeparator;

        return link.getLinkedWith().getName() + separator
                + link.quant_used + separator
                + link.getUnit_measurement();
    }
    /**
     * Retorna o registro que representa o link entre os itens no linkedFrom
     *
     * @param link link que será convertido num registro
     * @return Retorna um registro contendo as informações do link
     */
    public static String generateLinkedFromRegister(RecipeItem link) {

        String separator = StorageTools.registerDataSeparator;

        return link.getLinkOwner().getName() + separator
                + link.quant_used + separator
                + link.getUnit_measurement();
    }
    
    /**
     * Retorna o registro que representa os links que o item criou
     *
     * @param recipe ArrayList contendo receitas de itens/links (RecipeItem)
     * @return Retorna uma String contendo o código de registro da lista de
     * links feitos
     */
    protected static String createLinkedToRegisterLinks(ArrayList<RecipeItem> recipe) {
        String linksRegister = "";

        for (RecipeItem link : recipe) {
            linksRegister = linksRegister.concat(StorageTools.generateLinkedToRegister(link).concat(StorageTools.registerLinkSeparator));
        }

        return linksRegister;
    }
    
    /**
     * Retorna os registros que representam os links que o item recebeu
     *
     * @param linkList ArrayList contendo links que o item recebeu
     * @return Retorna uma String contendo o código de registro da lista de
     * links recebidos
     */
    protected static String createLinkedFromRegisterLinks(ArrayList<RecipeItem> linkList) {
        String linksRegister = "";

        for (RecipeItem link : linkList) {
            linksRegister = linksRegister.concat(StorageTools.generateLinkedFromRegister(link).concat(StorageTools.registerLinkSeparator));
        }

        return linksRegister;
    }
}
