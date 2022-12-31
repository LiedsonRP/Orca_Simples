/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.memory;

import model.entities.Item;
import model.entities.Link;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe utilitária que permite a manipulação da estrutura de grafos dos itens
 *
 * @author lieds
 */
public class ItensMap {

    private static HashMap<String, Item> map;

    /*
    * M étodo construtor que inicia a arvore de memória
     */
    public ItensMap() {

        if (ItensMap.map == null) {
            ItensMap.map = new HashMap<>();
        }
    }

    /**
     * Adiciona um oldItem no mapa de itens
     *
     * @param item oldItem a ser adicionado
     */
    public void addItem(Item item) {

        if (!ItensMap.map.containsKey(item.getName())) {//verifica se o oldItem não existen no map de itens
            map.put(item.getName(), item);

            if (!item.getLinkedTo().isEmpty()) { //checa se o oldItem possui uma ligação configurada na criação
                for (Link link : item.getLinkedTo()) {
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
     * @param link objeto de link contendo o oldItem que iniciou a ligação e o que
 recebeu
     */
    private void linkItens(ArrayList<Link> linkList) {
        for (Link link : linkList) {
            this.linkItens(link);
        }
    }

    /**
     * Liga dois ou mais itens existentes no mapa de itens
     *
     * @param link objeto de link contendo o oldItem que iniciou a ligação e o que
 recebeu
     */
    private void linkItens(Link link) {

        if (this.isItemInMap(link.getLinkOwner()) && this.isItemInMap(link.getLinkedWith())) {//verifica se os itens existem                                                                    
            if (!ItensMap.checkItensIsLinked(link.getLinkOwner(), link.getLinkedWith())) { //verifica se os itens já possuem uma ligação               
                link.getLinkedWith().receiveLink(link);
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
     * @return ArrayList
     */
    public ArrayList<Item> getAllItens() {
        return new ArrayList<>(ItensMap.map.values());
    }

    /**
     * Retorna um oldItem armazenado na árvore de itens ou valor null caso este não
 exista
     *
     * @param itemName nome do oldItem a ser retornado
     * @return Collection
     */
    public Item getItem(String itemName) {
        return ItensMap.map.get(itemName);
    }

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

            ItensMap.map.remove(itemName); //remove o oldItem

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
    private void deleteLinksUsingLinkedTo(ArrayList<Link> linksToBeDeletedList) {
        for (Link link : linksToBeDeletedList) {
            link.getLinkedWith().removeLinkFromLinkedFrom(link);
        }
    }

    /**
     * Deleta as ligações de um oldItem nos itens que fizeram ligações
     *
     * @param linksToBeDeletedList lista de links que serão deletados nos itens
     * que iniciaram a ligação
     */
    private void deleteLinksUsingLinkedFrom(ArrayList<Link> linksToBeDeletedList) {
        for (Link link : linksToBeDeletedList) {
            link.getLinkOwner().removeLinkFromLinkedTo(link);
        }
    }

    /**
     * Modifica o identificador e a estrutura das ligações no mapa de itens da
     * memória
     *
     * @param oldItemName
     * @param newItem
     */
    public void modifyItem(String oldItemName, Item newItem) {

        if (ItensMap.map.containsKey(oldItemName)) {
            Item oldItem = this.getItem(oldItemName);
            if (oldItemName.equals(newItem.getName())) {//caso o identificado não tenha sido modificados                                
                this.updateItemLinks(newItem.getLinkedTo(), oldItem.getLinkedTo());
                ItensMap.map.replace(oldItemName, newItem);
            } else {//caso tenha ocorrido mudança no identificador
                this.addItem(newItem);
                this.deleteItem(oldItemName);
            }
        } else {
            throw new IllegalArgumentException("O Item não foi encontrado na memória!");
        }
    }

    /**
     * Atualiza as ligações de um item usando como referência a lista de links antiga
     * @param newLinkList lista contendo a nova configuração de ligações
     * @param oldLinkList lista contendo a antiga configuração de ligações
     */
    private void updateItemLinks(ArrayList<Link> newLinkList, ArrayList<Link> oldLinkList) {
        //Checa se houve links deletados
        ArrayList<Link> linksDeleted = Link.getLinksDeletedOnList(newLinkList, oldLinkList);
        //Checa de houve links adicionados
        ArrayList<Link> linksAdded = Link.getLinksAddedOnList(newLinkList, oldLinkList);

        if (!linksDeleted.isEmpty()) {
            this.deleteLinksUsingLinkedTo(linksDeleted);
        }

        if (!linksAdded.isEmpty()) {
            this.linkItens(linksAdded);
        }
    }

    /**
     * Verifica se um oldItem está cadastrado no mapa
     *
     * @param item instancia do oldItem a ser buscado
     * @return Boolean
     */
    private boolean isItemInMap(Item item) {
        return ItensMap.map.containsKey(item.getName());
    }

    /**
     * Verifica se um oldItem está cadastrado no mapa
     *
     * @param itemName nome do oldItem a ser buscado
     * @return Boolean
     */
    public boolean isItemInMap(String itemName) {
        return ItensMap.map.containsKey(itemName);
    }

    /**
     * Verifica se um oldItem está ligado a outro oldItem em ambos os sentidos
     *
     * @param linkedTo oldItem que fez a ligação
     * @param linkedFrom oldItem que recebeu a ligação
     * @return boolean
     */
    private static boolean checkItensIsLinked(Item linkedTo, Item linkedFrom) {

        if (Item.checkItemIsLinkedTo(linkedTo, linkedFrom) && Item.checkItemIsLinkedFrom(linkedFrom, linkedTo)) { //verifica se já existe uma ligação entre os itens            
            return true;
        }

        return Item.checkItemIsLinkedFrom(linkedTo, linkedFrom) && Item.checkItemIsLinkedTo(linkedFrom, linkedTo);
    }
}
