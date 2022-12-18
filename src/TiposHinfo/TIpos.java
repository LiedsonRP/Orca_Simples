/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiposHinfo;

/**
 *
 * @author Acer
 */
public class TIpos {
    
    private int id_tipo;
    private String tipo;

    public TIpos(int id_tipo, String tipo) {
        this.id_tipo = id_tipo;
        this.tipo = tipo;
    }
 
    
    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return getTipo();
    }
    
    
    
    
    
}
