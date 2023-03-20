/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.model.memory;

/**
 * Classe que permite a ligação entre dois itens
 * @author lieds 
 */
public class RecipeItem{
    /**
     * Item que iniciou a ligação
     */
    private Item linkOwner;
    /**
     * Item que recebeu a ligação
     */
    private Item linkedWith;     
    /**
     * Quantidade usada do item
     */
    public double quant_used;
    /**
     * Unidade de medida do item na receita
     */
    public String unit_measurement;
    /**
     * Custo proporcional do item pela quantidade usada
     */   
    public double proportional_cost;
    /**
     * Método construtor do link
     * @param linkOwner item que iniciou a ligação
     * @param linkedWith item que recebeu a ligação
     */
    
    public RecipeItem(Item linkOwner, Item linkedWith) {        
        this.linkedWith = linkedWith;
        this.linkOwner = linkOwner;
    }    
    /**
     * Método construtor do item da receita
     * @param linkOwner item que possui a receita
     * @param linkedWith item que será usado na receita
     * @param quant_used quantidade usada na receita
     * @param unit_measurement unidade de medida de referência
     */
    public RecipeItem(Item linkOwner, Item linkedWith, double quant_used, String unit_measurement) {
        this.linkedWith = linkedWith;
        this.linkOwner = linkOwner;
        this.quant_used = quant_used;
        this.unit_measurement = unit_measurement;
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
    
    public double getQuant_used() {
        return quant_used;
    }

    public void setQuant_used(double quant_used) {
        this.quant_used = quant_used;
    }

    public String getUnit_measurement() {
        return unit_measurement;
    }

    public void setUnit_measurement(String unit_measurement) {
        this.unit_measurement = unit_measurement;
    }

    public double getProportional_cost() {
        return proportional_cost;
    }

    public void setProportional_cost(double proportional_cost) {
        this.proportional_cost = proportional_cost;
    }            
}
