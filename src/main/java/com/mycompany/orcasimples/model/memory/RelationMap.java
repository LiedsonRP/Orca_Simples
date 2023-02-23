/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.model.memory;

import com.mycompany.orcasimples.model.entities.Item;
import com.mycompany.orcasimples.model.entities.RecipeItem;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que permite a manipulação da estrutura de grafos dos itens,
 sendo formada pelos componentes:

 - Item: Representado pela classe Item, trata-se dos nós(Node) do mapa de
 gráfico 
 
 - RecipeItem: Trata-se da ligação entre dois itens, permitindo o
 relacionamento 
 
 - Mapa: mapeamento onde fica armazenado os itens e seus
 relacionamentos

 O princípio desta estrutura de dados é que a modificação de um item afeta
 outros cadastrados que tenham tido um relacionamento com este, por isso
 internamente cada modificação além de afetar o item em si, também afeta os
 links criados por ele e/ou feitos com ele, sendo os principais métodos:

 - Adição de itens - Deleção de itens - Modificação de itens - Seleção de item
 específico - Seleção de todos o itens do mapa - Verifica se o item está no
 mapa - Verifica se os itens possuem ligação

 Na implementação do mapa foi utilizado a classe HashMap, de forma a facilitar
 o acesso dos itens por meio de um identificador.
 *
 * @author lieds
 */
public final class RelationMap {
    /**
     * Mapa dos itens
     */
    private HashMap<String, Item> map;
    /*
    * Método construtor que inicia o mapa de itens
     */
    public RelationMap() {
        this.map = new HashMap<>();
    }
    /**
     * Cadastra um conjunto de itens no mapa de itens;
     * @param itemList lista contendo os itens que serão cadastrados
     */
    public void addItem(ArrayList<Item> itemList) {
        for (Item item : itemList) {
            this.addItem(item);
        }
    }
    /**
     * Adiciona um Item no mapa de itens, garantindo desde sua criação que
     * os itens tenha seu conjunto de ligações, sendo todas são criadas com base
     * no LinkedTo (Ligações feitas)
     *
     * @param item item a ser adicionado
     */
    public void addItem(Item item) {

        if (!this.map.containsKey(item.getName())) {//verifica se o oldItem não existen no map de itens
            map.put(item.getName(), item);
                        
            if (!item.getLinkedTo().isEmpty()) { //checa se o item possui uma ligação configurada na criação                
                for (RecipeItem link : item.getLinkedTo()) {                    
                    this.linkItens(link);
                }
            }
        } else {
            throw new IllegalArgumentException("Item já cadastrado na memória!");
        }

    }
    /**
     * Liga dois ou mais itens existentes no mapa de itens
     *
     * @param linkList lista contendo todos os links a serem adicionados
     */
    private void linkItens(ArrayList<RecipeItem> linkList) {
        for (RecipeItem link : linkList) {
            this.linkItens(link);
        }
    }
    /**
     * Liga dois ou mais itens existentes no mapa de itens
     *
     * @param link objeto de link contendo o item que iniciou a ligação e o
     * que recebeu
     */
    private void linkItens(RecipeItem link) {        
        if (this.isItemInMap(link.getLinkOwner()) && this.isItemInMap(link.getLinkedWith())) {//verifica se os itens existem
            if (!this.checkItensIsLinked(link.getLinkOwner(), link.getLinkedWith())) { //verifica se os itens já possuem uma ligação                               
                link.getLinkedWith().receiveRecipeItem(link);          
            } else {
                throw new IllegalArgumentException("Os itens já possuem ligação!");
            }

        } else {
            throw new IllegalArgumentException("Item passado não existe na memória!");
        }
    }

    /**
     * Retorna todos os itens armazenados na árvore de itens ou valor null caso
     * esteja vazia
     *
     * @return ArrayList contendo todos os itens no tipo Item
     */
    public ArrayList<Item> getAllItens() {                
        return new ArrayList<>(this.map.values());
    }
    /**
     * Retorna um oldItem armazenado na árvore de itens ou valor null caso este
     * não exista
     *
     * @param itemName nome do oldItem a ser retornado
     * @return um item no formato Item
     */
    public Item getItem(String itemName) {
        return this.map.get(itemName);
    }
    /**
     * Deleta um item e suas ligações do mapa de itens.
     * 
     * @param itemName identificador do item
     */
    public void deleteItem(String itemName) {
        if (isItemInMap(itemName)) {//checa se o oldItem está na memória
            Item item = this.getItem(itemName);

            //Deleta primeiro as ligações
            if (!item.getLinkedFrom().isEmpty()) {
                this.deleteLinksUsingLinkedFrom(item.getLinkedFrom());
            }

            if (!item.getLinkedTo().isEmpty()) {
                this.deleteLinksUsingLinkedTo(item.getLinkedTo());
            }

            this.map.remove(itemName); //remove o oldItem

        } else {
            throw new IllegalArgumentException("Item não cadastrado na memória!");
        }
    }
    /**
     * Deleta as ligações de um oldItem nos itens que receberam a ligação
     *
     * @param linksToBeDeletedList lista de links que serão deletados nos itens
     * que receberam a ligação
     */
    private void deleteLinksUsingLinkedTo(ArrayList<RecipeItem> linksToBeDeletedList) {
        for (RecipeItem link : linksToBeDeletedList) {
            link.getLinkedWith().removeRecipeItemFromLinkedFrom(link);
        }
    }
    /**
     * Deleta as ligações de um oldItem nos itens que fizeram ligações
     *
     * @param linksToBeDeletedList lista de links que serão deletados nos itens
     * que iniciaram a ligação
     */
    private void deleteLinksUsingLinkedFrom(ArrayList<RecipeItem> linksToBeDeletedList) {
        for (RecipeItem link : linksToBeDeletedList) {
            link.getLinkOwner().removeRecipeItemFromLinkedTo(link);
        }
    }
    /**
     * Modifica o identificador e a estrutura das ligações no mapa de itens da
     * memória
     *
     * @param oldItemName identificador do item a ser modificado
     * @param newItem objeto do tipo Item contendo o objeto que contém as novas informações
     */
    public void modifyItem(String oldItemName, Item newItem) {

        if (this.map.containsKey(oldItemName)) {
            
            Item oldItem = this.getItem(oldItemName);
            
            if (oldItemName.equals(newItem.getName())) {//caso o identificado não tenha sido modificados                                
                this.updateItemLinks(newItem.getLinkedTo(), oldItem.getLinkedTo());
                this.map.replace(oldItemName, newItem);
            } else {//caso tenha ocorrido mudança no identificador                
                
                this.addItem(newItem);
                
                for (RecipeItem link : oldItem.getLinkedFrom()) {
                    RecipeItem newLink = new RecipeItem(link.getLinkOwner(), newItem, link.getQuant_used(), link.getUnit_measurement());
                    link.getLinkOwner().addRecipeItem(newLink);
                    newItem.receiveRecipeItem(newLink);
                }
                                                                
                this.deleteItem(oldItemName);
            }
        } else {
            throw new IllegalArgumentException("O Item não foi encontrado na memória!");
        }
    }
    /**
     * Atualiza as ligações de um item usando como referência a lista de links
     * antiga
     *
     * @param newLinkList lista contendo a nova configuração de ligações
     * @param oldLinkList lista contendo a antiga configuração de ligações
     */
    private void updateItemLinks(ArrayList<RecipeItem> newLinkList, ArrayList<RecipeItem> oldLinkList) {
        //Checa se houve links deletados
        ArrayList<RecipeItem> linksDeleted = this.getLinksDeletedOnList(newLinkList, oldLinkList);
        //Checa de houve links adicionados
        ArrayList<RecipeItem> linksAdded = this.getLinksAddedOnList(newLinkList, oldLinkList);

        if (!linksDeleted.isEmpty()) {
            this.deleteLinksUsingLinkedTo(linksDeleted);
        }

        if (!linksAdded.isEmpty()) {
            this.linkItens(linksAdded);
        }
    }    
     /**
     * Retorna os links que foram adicionados em uma nova lista, usando uma lista antiga como referência
     * @param newList nova lista que será usada como comparação
     * @param oldList antiga lista que será usada como referência
     * @return ArrayList contendo os links que foram adicionados em relação a uma lista original
     */
    private ArrayList<RecipeItem> getLinksAddedOnList(ArrayList<RecipeItem> newList, ArrayList<RecipeItem> oldList) {
        ArrayList<RecipeItem> linksAdded = RelationMap.getNotFoundLinksOnLists(oldList, newList);                
        return linksAdded;
    }    
    /**
     * Retorna os links que foram deletados de uma lista nova usando uma lista antiga como referência
     * @param newList nova lista que será usada de comparação
     * @param oldList antiga lista que será usada de referência
     * @return ArrayList contendo os links que foram deletados de uma lista original
     */
    private ArrayList<RecipeItem> getLinksDeletedOnList(ArrayList<RecipeItem> newList, ArrayList<RecipeItem> oldList) {
        ArrayList<RecipeItem> linksDeleted = RelationMap.getNotFoundLinksOnLists(newList, oldList);                
        return linksDeleted;
    }
    /**
     * Compara duas lista de links e retorna os que não estão contidos na lista usada como referência.
     *
     * @param listCompared lista que será comparada
     * @param listReference lista usada como refererência de comparação
     * @return ArrayList contendo a lista de links não encontrados
     */
    private static ArrayList<RecipeItem> getNotFoundLinksOnLists(ArrayList<RecipeItem> listCompared, ArrayList<RecipeItem> listReference) {
        boolean linkFound = false;
        ArrayList<RecipeItem> linksNotFound = new ArrayList<>();        
        for (RecipeItem linkReferece : listReference) {            
            for (RecipeItem linkCompared : listCompared) {                
                if (linkCompared.getLinkedWith().getName().equals(linkReferece.getLinkedWith().getName())) {//compara se cada link presente na lista comparada se encontra na lista de referência                    
                    linkFound = true;                    
                    break;
                } else {
                    linkFound = false;
                }
            }
            
            if (!linkFound) {//Caso o link não tenha sido encontrado, é adicionado a lista de deletados
                linksNotFound.add(linkReferece);
            }
        }

        return linksNotFound;
    }
    /**
     * Verifica se um oldItem está cadastrado no mapa
     *
     * @param item instancia do oldItem a ser buscado
     * @return true caso o item se encontre no mapa e false caso não
     */
    public boolean isItemInMap(Item item) {
        return this.map.containsKey(item.getName());
    }
    /**
     * Verifica se um oldItem está cadastrado no mapa
     *
     * @param itemName nome do oldItem a ser buscado
     * @return true caso o item se encontre no mapa e false caso não
     */
    public boolean isItemInMap(String itemName) {
        return this.map.containsKey(itemName);
    }
    /**
     * Verifica se um oldItem está ligado a outro oldItem em ambos os sentidos
     *
     * @param linkedTo oldItem que fez a ligação
     * @param linkedFrom oldItem que recebeu a ligação
     * @return true caso os itens possuam ligação e false caso não
     */
    public boolean checkItensIsLinked(Item linkedTo, Item linkedFrom) {

        if (this.checkItemIsLinkedTo(linkedTo, linkedFrom) && this.checkItemIsLinkedFrom(linkedFrom, linkedTo)) { //verifica se já existe uma ligação entre os itens            
            return true;
        }

        return this.checkItemIsLinkedFrom(linkedTo, linkedFrom) && this.checkItemIsLinkedTo(linkedFrom, linkedTo);
    }
    /**
     * Verifica se o item criou uma ligação com um outro em específico
     *
     * @param linkedTo item que iniciou a ligação
     * @param linkedFrom item que recebeu a ligação
     * @return Retorna true caso o link tenha feito uma ligação com o outro item e false caso não
     */
    public boolean checkItemIsLinkedTo(Item linkedTo, Item linkedFrom) {

        for (RecipeItem link : linkedTo.getLinkedTo()) {
            if (link.getLinkedWith().getName().equals(linkedFrom.getName())) {
                return true;
            }
        }

        return false;
    }
    /**
     * Verifica se o item foi ligado a outro em específico
     *
     * @param linkedFrom item que recebeu a ligação
     * @param linkedTo item que iniciou a ligação
     * @return Retorna true caso o link tenha recebido uma ligação do outro item e false caso não
     */
    public boolean checkItemIsLinkedFrom(Item linkedFrom, Item linkedTo) {

        for (RecipeItem link : linkedFrom.getLinkedFrom()) {
            if (link.getLinkOwner().getName().equals(linkedTo.getName())) {
                return true;
            }
        }

        return false;
    }
}