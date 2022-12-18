/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package OpcoesDeCad;

import MenuOrca.Main_menu;
import MenuOrca.menuOrg;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class TelaOpCadController extends menuOrg implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button butCancel;

    @FXML
    private ToggleGroup cadtipos;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
