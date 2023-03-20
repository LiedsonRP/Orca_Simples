/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.model.memory;

import java.util.ArrayList;

/**
 * Classe que é inserida no mapa de memória, sendo está considerado um node (Nó)
 * do mapa. É formado essencialmente pelos seguintes componentes:
 *
 * - Identificador (name): nome que permite o acesso no mapa de itens -
 * LinkedTo: Conjunto de ligações que ele fez com outros itens, sendo uma lista
 * de Links - LinkedFrom: Conjunto de ligações que ele recebeu, sendo uma lista
 * de links
 *
 * Na hora de se referir a um nó e seus relacionamentos com outros nós, é
 * importante ficar atento a via do relacionamento, pois ele pode tanto fazer
 * ligações como recebe-las.
 *
 * OBS: Outros dados não relacionados ao identficador ou link encontradas na
 * classe, tratam-se já da implementação desse nó para que possa de fato ser
 * considerado um item requisitado pelo projeto.
 *
 * OBS2: para adicionar novos objetos no mapa de itens, basta fazer com que as
 * novas classes se tornem filhas de item
 *
 * @author lieds
 */
public class Item {

    /**
     * Nome do item
     */
    private String name;
    /**
     * Tipo de item (alimentício, estamparia e etc)
     */
    private String type;
    /**
     * Unidade medida do item
     */
    private String unit_measurement;
    /**
     * Lista de ligações que o item fez
     */
    private ArrayList<RecipeItem> linkedTo;
    /**
     * Lista de ligações que o item recebeu
     */
    private ArrayList<RecipeItem> linkedFrom;

    /**
     * Método construtor que permite a criação de um nó
     *
     * @param identifier nome que identifica o item no mapa dos itens
     */
    public Item(String identifier) {
        this.name = identifier;
        this.linkedTo = new ArrayList<>();
        this.linkedFrom = new ArrayList<>();
    }

    /**
     * Método construtor que permite a criação de um item genêrico
     *
     * @param identifier nome que identifica o item no mapa dos itens
     * @param type tipo de item
     * @param unit_measurement unidade de medida do item
     */
    public Item(String identifier, String type, String unit_measurement) {
        this.name = identifier;
        this.type = type;
        this.unit_measurement = unit_measurement;
        this.linkedTo = new ArrayList<>();
        this.linkedFrom = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit_measurement() {
        return unit_measurement;
    }

    public void setUnit_measurement(String unit_measurement) {
        this.unit_measurement = unit_measurement;
    }

    public ArrayList<RecipeItem> getLinkedTo() {
        return linkedTo;
    }

    public void setLinkedTo(ArrayList<RecipeItem> linkedTo) {
        this.linkedTo = linkedTo;
    }

    public ArrayList<RecipeItem> getLinkedFrom() {
        return linkedFrom;
    }

    public void setLinkedFrom(ArrayList<RecipeItem> linkedFrom) {
        this.linkedFrom = linkedFrom;
    }

    /**
     * Adiciona um link na lista de ligações iniciadas
     *
     * @param link link contendo o item que iniciou a ligação e quem recebeu
     */
    public void addRecipeItem(RecipeItem link) {
        if (this.getIndexOfRecipeItemOnLinkedTo(link) == -1) {            
            this.linkedTo.add(link);
        }
    }

    /**
     * Adicionar um link a lista de ligações recebidas
     *
     * @param link link contendo o item que iniciou a ligação e quem recebeu
     */
    public void receiveRecipeItem(RecipeItem link) {
        if (this.getIndexOfRecipeItemOnLinkedFrom(link) == -1) {                
            this.linkedFrom.add(link);            
        }
    }

    /**
     * Remove um link da lista de ligações recebidas
     *
     * @param link link a ser deletado
     */
    public void removeRecipeItemFromLinkedFrom(RecipeItem link) {
        int pos = this.getIndexOfRecipeItemOnLinkedFrom(link);
        if (pos != -1) {
            this.linkedFrom.remove(pos);
        }
    }
    /**
     * Retorna a posição de um link da lista de ligações recebidas
     *
     * @param link link a ser buscado
     * @return int
     */
    private int getIndexOfRecipeItemOnLinkedFrom(RecipeItem link) {
        for (RecipeItem linkedFrom : this.linkedFrom) {
            if (linkedFrom.getLinkOwner().getName().equals(link.getLinkOwner().getName())) {
                return this.linkedFrom.indexOf(linkedFrom);
            }
        }
        return -1;
    }
    /**
     * Remove um link da lista de ligações estabelecidas e retonar um null caso
     * não encontre
     *
     * @param link link a ser deletado
     */
    public void removeRecipeItemFromLinkedTo(RecipeItem link) {
        int pos = this.getIndexOfRecipeItemOnLinkedTo(link);
        if (pos != -1) {
            this.linkedTo.remove(pos);
        }
    }
    /**
     * Retona a posição de um link da lista de ligações estabelecidas e retorna
     * um null caso não encontre
     *
     * @param link link a ser buscado
     * @return int
     */
    private int getIndexOfRecipeItemOnLinkedTo(RecipeItem link) {
        for (RecipeItem linkedTo : this.linkedTo) {
            if (linkedTo.getLinkedWith().getName().equals(link.getLinkedWith().getName())) {
                return this.linkedTo.indexOf(linkedTo);
            }
        }

        return -1;
    }        
    /**
     * Método usado para verificar os dados inseridos no objeto
     *
     * @return String
     */
    @Override
    public String toString() {
        String description = "Name: " + this.getName() + "\n-------------------------------------\n"
                + "Fez ligação com:";
        String link_descTo = "";
        String link_descFrom = "";

        for (RecipeItem link : this.getLinkedTo()) {
            link_descTo = link_descTo.concat("\nOwner: " + link.getLinkOwner().getName()
                    + "\nLinkedWith: " + link.getLinkedWith().getName()
                    + "\n*************************");

            description = description.concat("\n" + link_descTo);
        }

        description = description.concat("\n-----------------------------------\n"
                + "Recebeu ligação de: ");

        for (RecipeItem link : this.getLinkedFrom()) {
            link_descFrom = link_descFrom.concat("\nOwner: " + link.getLinkOwner().getName()
                    + "\nLinkedWith: " + link.getLinkedWith().getName()
                    + "\n*************************");

            description = description.concat("\n" + link_descFrom);
        }

        return description;
    }            
}
