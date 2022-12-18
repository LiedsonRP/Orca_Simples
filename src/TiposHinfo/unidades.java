/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiposHinfo;

/**
 *
 * @author Acer
 */
public class unidades {
    private int id_uni;
    private String unidade;

    public unidades(int id_uni, String unidade) {
        this.id_uni = id_uni;
        this.unidade = unidade;
    }

    public int getId_uni() {
        return id_uni;
    }

    public void setId_uni(int id_uni) {
        this.id_uni = id_uni;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return getUnidade();
    }
    
    
    
}
