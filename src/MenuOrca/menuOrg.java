/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuOrca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Acer
 */
public class menuOrg {
    @FXML
    void cadastra_Iten(ActionEvent event) {
        Main_menu.changeScreen(2);
    }
    
    @FXML
    void voltaMenu(ActionEvent event) {
        Main_menu.changeScreen(1);
    }
}