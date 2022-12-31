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
public class Link{

    private Item linkOwner;
    private Item linkedWith;        

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
    
    /**
     * Retorna os links que foram adicionados em uma nova lista, usando uma lista antiga como referência
     * @param newList nova lista que será usada como comparação
     * @param oldList antiga lista que será usada como referência
     * @return ArrayList
     */
    public static ArrayList<Link> getLinksAddedOnList(ArrayList<Link> newList, ArrayList<Link> oldList) {
        ArrayList<Link> linksAdded = Link.getNotFoundLinksOnLists(oldList, newList);                
        return linksAdded;
    }
    
    /**
     * Retorna os links que foram deletados de uma lista nova usando uma lista antiga como referência
     * @param newList nova lista que será usada de comparação
     * @param oldList antiga lista que será usada de referência
     * @return ArrayList
     */
    public static ArrayList<Link> getLinksDeletedOnList(ArrayList<Link> newList, ArrayList<Link> oldList) {
        ArrayList<Link> linksDeleted = Link.getNotFoundLinksOnLists(newList, oldList);                
        return linksDeleted;
    }

    /**
     * Compara duas lista de links e retorna os que não estão contidos na lista usada como referência.
     *
     * @param listCompared lista que será comparada
     * @param listReference lista usada como refererência de comparação
     * @return ArrayList
     */
    private static ArrayList<Link> getNotFoundLinksOnLists(ArrayList<Link> listCompared, ArrayList<Link> listReference) {
        boolean linkFound = false;
        ArrayList<Link> linksNotFound = new ArrayList<>();        
        for (Link linkReferece : listReference) {            
            for (Link linkCompared : listCompared) {                
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
}
