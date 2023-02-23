/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.model.entities;

import java.util.ArrayList;

/**
 * Classe que representa os insumos compostos
 *
 * @author lieds
 */
public class CompoundFoodstock extends Item {

    /**
     * Quantidade produzida dado uma receita.
     */
    private double quant_produced;
    /**
     * Soma dos custos da receita do insumo composto.
     */
    private double material_cost;
    /**
     * Custo unitário do insumo composto dado uma receita.
     */
    private double unit_cost;

    /**
     * Método construtor dos insumos compostos
     *
     * @param name nome do insumo compostos
     * @param type tipo de insumo
     * @param unit_measurement unidade de medida do insumo composto
     * @param quant_produced quantidade produzida do insumo composto dada uma
     * receita
     */
    public CompoundFoodstock(String name, String type, String unit_measurement, double quant_produced) {
        super(name, type, unit_measurement);
        this.quant_produced = quant_produced;
    }    
    /**
     * Método construtor dos insumos compostos que permite adiciona a receita diretamente
     *
     * @param name nome do insumo compostos
     * @param type tipo de insumo
     * @param unit_measurement unidade de medida do insumo composto
     * @param quant_produced quantidade produzida do insumo composto dada uma receita
     * @param recipe ArrayList de RecipeItem contendo os itens da receita que forma o insumo composto
     */
    public CompoundFoodstock(String name, String type, String unit_measurement, double quant_produced, ArrayList<RecipeItem> recipe) {
        super(name, type, unit_measurement);
        this.quant_produced = quant_produced;
        this.setLinkedTo(recipe);
    }

    public double getQuant_produced() {
        return quant_produced;
    }

    public void setQuant_produced(double quant_produced) {
        this.quant_produced = quant_produced;
    }

    public double getMaterial_cost() {
        return material_cost;
    }

    public void setMaterial_cost(double material_cost) {
        this.material_cost = material_cost;
    }

    public double getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(double unit_cost) {
        this.unit_cost = unit_cost;
    }

}
