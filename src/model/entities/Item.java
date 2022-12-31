/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;

/**
 *
 * @author lieds
 */
public class Item {

    private String name;
    private ArrayList<Link> linkedTo;
    private ArrayList<Link> linkedFrom;

    public Item(String identifier) {
        this.name = identifier;
        this.linkedTo = new ArrayList<>();
        this.linkedFrom = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Link> getLinkedTo() {
        return linkedTo;
    }

    public void setLinkedTo(ArrayList<Link> linkedTo) {
        this.linkedTo = linkedTo;
    }

    public ArrayList<Link> getLinkedFrom() {
        return linkedFrom;
    }

    public void setLinkedFrom(ArrayList<Link> linkedFrom) {
        this.linkedFrom = linkedFrom;
    }

    /**
     * Adiciona um link na lista de ligações iniciadas     
     * @param link link contendo o item que iniciou a ligação e quem recebeu
     */
    public void addLink(Link link) {
        if (!Item.checkItemIsLinkedTo(this, link.getLinkedWith())) {
            this.linkedTo.add(link);
        }
    }

    /**
     * Adicionar um link a lista de ligações recebidas     
     * @param link link contendo o item que iniciou a ligação e quem recebeu
     */
    public void receiveLink(Link link) {
        if (!checkItemIsLinkedFrom(this, link.getLinkOwner())) {
            this.linkedFrom.add(link);
        }
    }

    /**
     * Remove um link da lista de ligações recebidas     
     * @param link link a ser deletado
     */
    public void removeLinkFromLinkedFrom(Link link) {
        if (Item.checkItemIsLinkedFrom(this, link.getLinkOwner())) {
            int pos = this.getIndexOfLinkOnLinkedFrom(link);            
            
            if(pos != -1) {
                this.linkedFrom.remove(pos);
            }
        }
    }

    /**
     * Retorna a posição de um link da lista de ligações recebidas
     * @param link link a ser buscado
     * @return int
     */
    public int getIndexOfLinkOnLinkedFrom(Link link) {
        for (Link linkedFrom : this.linkedFrom) {            
            if (linkedFrom.getLinkOwner().getName().equals(link.getLinkOwner().getName())) {
                return this.linkedFrom.indexOf(linkedFrom);
            }
        }
        return -1;
    }

    /**
     * Remove um link da lista de ligações estabelecidas e retonar um null caso não encontre
     * @param link link a ser deletado
     */
    public void removeLinkFromLinkedTo(Link link) {
        if (Item.checkItemIsLinkedTo(this, link.getLinkedWith())) {
            int pos = this.getIndexOfLinkOnLinkedTo(link);
            
            if (pos != -1) {
                this.linkedTo.remove(pos);
            }            
        }
    }

    /**
     * Retona a posição de um link da lista de ligações estabelecidas e retorna um null caso não encontre
     * @param link link a ser buscado
     * @return int
     */
    public int getIndexOfLinkOnLinkedTo(Link link) {
        for (Link linkedTo : this.linkedTo) {
            if (linkedTo.getLinkedWith().getName().equals(link.getLinkedWith().getName())) {
                return this.linkedTo.indexOf(linkedTo);
            }
        }

        return -1;
    }

    /**
     * Verifica se o item criou uma ligação com um outro em específico
     *
     * @param linkedTo item que iniciou a ligação
     * @param linkedFrom item que recebeu a ligação
     * @return Boolean
     */
    public static boolean checkItemIsLinkedTo(Item linkedTo, Item linkedFrom) {

        for (Link link : linkedTo.getLinkedTo()) {
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
     * @return Boolean
     */
    public static boolean checkItemIsLinkedFrom(Item linkedFrom, Item linkedTo) {

        for (Link link : linkedFrom.getLinkedFrom()) {
            if (link.getLinkOwner().getName().equals(linkedTo.getName())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String description = "Name: " + this.getName() + "\n-------------------------------------\n"
                + "Fez ligação com:";
        String link_descTo = "";
        String link_descFrom = "";

        for (Link link : this.getLinkedTo()) {
            link_descTo = link_descTo.concat("\nOwner: " + link.getLinkOwner().getName()
                    + "\nLinkedWith: " + link.getLinkedWith().getName()
                    + "\n*************************");

            description = description.concat("\n" + link_descTo);
        }

        description = description.concat("\n-----------------------------------\n"
                + "Recebeu ligação de: ");

        for (Link link : this.getLinkedFrom()) {
            link_descFrom = link_descFrom.concat("\nOwner: " + link.getLinkOwner().getName()
                    + "\nLinkedWith: " + link.getLinkedWith().getName()
                    + "\n*************************");

            description = description.concat("\n" + link_descFrom);
        }

        return description;
    }
}
