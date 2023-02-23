/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.FuncoesDeCalculo;

/**
 *
 * @author Acer
 */
public class Calculo {

    /*private int valorGasto_total;
    
    private double valorGasto;
    private int valor_unitario;
    private int quantidade_unitaria;
    
    private int quantidade_KG;
    private int quantidade_G;
    private int quantidade_Metro;
    private int quantidade_Cm;
    private int quantidade_MM;
    private int quantidade_Litro;
    private int quantidade_centL;
    private int quantidade_miliL;        
    
    //dados certos -> converter (caso necessário) -> calculo unitário
    
    public void calc_unitario(){
        int Qnt_uni;    
        int Vlr_gasto;
        int VlrTotal;
        
        Qnt_uni = quantidade_unitaria;
        Vlr_gasto = valorGasto;
       
        VlrTotal = Qnt_uni * Vlr_gasto;
        
        valorGasto_total = VlrTotal;  
    }*/

    public static double calc_unitario(double valor_gasto, double quantidade) {
        return valor_gasto * quantidade;
    }

    public void main() {
        /* Calculo func = new Calculo();
        func.quantidade_unitaria = 4;
        func.valorGasto = 5;
        func.calc_unitario();*/        
        System.out.println(Calculo.calc_unitario(12, 5.0));
    }
}
