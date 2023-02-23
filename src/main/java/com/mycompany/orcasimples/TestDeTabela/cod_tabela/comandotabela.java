/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDeTabela.cod_tabela;

/**
 *
 * @author Acer
 */
public class comandotabela {
 
    private String nome_prop;
    private String Tipo;
    private int valor_bruto;
    private String descricao;

    public comandotabela(String nome, String Tipo, int valor_bruto, String descricao) {
        this.nome_prop = nome;
        this.Tipo = Tipo;
        this.valor_bruto = valor_bruto;
        this.descricao = descricao;
    }
    
    public String getNome() {
        return nome_prop;
    }

    public void setNome(String nome) {
        this.nome_prop = nome;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getValor_bruto() {
        return valor_bruto;
    }

    public void setValor_bruto(int valor_bruto) {
        this.valor_bruto = valor_bruto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    }
