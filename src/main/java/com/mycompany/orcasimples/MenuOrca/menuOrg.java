/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orcasimples.MenuOrca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Acer
 */
public class menuOrg {
    @FXML
    void cadastra_Embalagem(ActionEvent event) {
        Main_menu.changeScreen(2);
    }
    
    @FXML
    void voltaMenu(ActionEvent event) {
        Main_menu.changeScreen(1);
    }
    
    @FXML
    void cadastra_Simples(ActionEvent event){
        Main_menu.changeScreen(3);
    }
    @FXML
    void cadastra_Composto(ActionEvent event){
        Main_menu.changeScreen(4);
    }
    @FXML
    void cadastra_Produto(ActionEvent event){
        Main_menu.changeScreen(5);
    }
}
