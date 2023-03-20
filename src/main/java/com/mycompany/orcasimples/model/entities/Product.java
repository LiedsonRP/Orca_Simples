/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.model.entities;

import com.mycompany.orcasimples.model.memory.Item;

/**
 * Classe que representa os produtos.
 * @author lieds
 */
public class Product extends Item {
    /**
     * Quantidade produzida do produto dado uma receita.
     */
    private double quant_produced;
    /**
     * Soma dos custos da receita do produto.
     */
    private double material_cost;
    /**
     * Método construtor do produto
     * @param name nome do produto
     * @param type tipo de produto
     * @param unit_measurement unidade de medida do produto
     * @param quant_produced quantidade produzida
     */
    public Product(String name, String type, String unit_measurement, double quant_produced) {
        super(name, type, unit_measurement);
        this.quant_produced = quant_produced;
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
}
