/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package TestDeTabela;

import TestDeTabela.cod_tabela.comandotabela;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FXMLTabelaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ToggleGroup TIPOS;

    @FXML
    private TableColumn<comandotabela, String> coll_DESC = new TableColumn<>();

    @FXML
    private TableColumn<comandotabela, String> coll_bruto = new TableColumn<>();

    @FXML
    private TableColumn<comandotabela, String> coll_noME = new TableColumn<>();

    @FXML
    private TableColumn<?, ?> coll_tyPE;

    @FXML
    private TextField nome_produto;

    @FXML
    private TableView<comandotabela> tab_Total = new TableView<comandotabela>();
    
    @FXML
    private TextField nomeProduto;
    
    @FXML
    private TextField custoBruto;

    @FXML
    private TextArea desc_prod;

    @FXML
    private void cad_tab(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }    
    
    private void prencheTab(ArrayList<comandotabela> ta){
        ObservableList<comandotabela> tab = FXCollections.observableArrayList(ta);
        
        coll_noME.setCellValueFactory(new PropertyValueFactory<comandotabela, String>("nome_prop"));
        coll_bruto.setCellValueFactory(new PropertyValueFactory<comandotabela, String>("valor_bruto"));
        coll_DESC.setCellValueFactory(new PropertyValueFactory<comandotabela, String>("descricao"));
        
        tab_Total.setItems(tab);
        
    }
    
}