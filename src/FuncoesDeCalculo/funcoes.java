/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncoesDeCalculo;

/**
 *
 * @author Acer
 */
public class funcoes {
    private int valorGasto_total;
    private int valorGasto;
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
    
    
    
    public void calc_unitario(){
        int Qnt_uni;
        int Vlr_gasto;
        int VlrTotal;
        
        Qnt_uni = quantidade_unitaria;
        Vlr_gasto = valorGasto;
       
        VlrTotal = Qnt_uni * Vlr_gasto;
        
        valorGasto_total = VlrTotal;  
    }
    
    
}
