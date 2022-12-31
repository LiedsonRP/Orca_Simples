/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

/**
 * Classe que permite a ligação entre dois itens
 * @author lieds 
 */
public class Link{
    /**
     * Item que iniciou a ligação
     */
    private Item linkOwner;
    /**
     * Item que recebeu a ligação
     */
    private Item linkedWith;        
    /**
     * Método construtor do link
     * @param linkOwner item que iniciou a ligação
     * @param linkedWith item que recebeu a ligação
     */
    public Link(Item linkOwner, Item linkedWith) {        
        this.linkedWith = linkedWith;
        this.linkOwner = linkOwner;
    }                

    public Item getLinkedWith() {
        return linkedWith;
    }

    public void setLinkedWith(Item linkedWith) {
        this.linkedWith = linkedWith;
    }

    public Item getLinkOwner() {
        return linkOwner;
    }

    public void setLinkOwner(Item linkOwner) {
        this.linkOwner = linkOwner;
    }            
}
