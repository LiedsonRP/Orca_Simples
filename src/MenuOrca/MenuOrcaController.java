/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MenuOrca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class MenuOrcaController extends menuOrg implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button butCadastrar;
    
    @FXML
    private MenuItem abaEmbalagem;
    
    @FXML
    private Button accordionComposto;

    @FXML
    private Button accordionEmbalagem;

    @FXML
    private Button accordionProduto;

    @FXML
    private Button accordionSImples;

    @FXML
    private TitledPane arcoCad;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
