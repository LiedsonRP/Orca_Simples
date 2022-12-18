/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package orca_simples;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FXMLTela1Controller implements Initializable {

    
    @FXML
    private Button BTN_CADASTRA;

    @FXML
    private Button BTN_CANCELA;

    @FXML
    private AnchorPane QNT_PORCAO;

    @FXML
    private TextField Qnt_PORCAO;

    @FXML
     private Spinner<?> Spner_qnt1;

    @FXML
    private Spinner<?> Spner_qnt2;

    @FXML
    private TextField TExtFILD_NOME;

    @FXML
    private TextField TExtFILD_NOME_simples1;

    @FXML
    private TextField TExtFILD_NOME_simples2;

    @FXML
    private TextField Tag_tipoDeIten;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
