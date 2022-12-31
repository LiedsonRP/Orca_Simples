/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

/**
 * Classe que representa um item usado numa receita
 * @author lieds
 */
public class RecipeItem extends Link {
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
     * Método construtor do item da receita
     * @param linkOwner item que possui a receita
     * @param linkedWith item que será usado na receita
     */
    public RecipeItem(Item linkOwner, Item linkedWith) {
        super(linkOwner, linkedWith);
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
