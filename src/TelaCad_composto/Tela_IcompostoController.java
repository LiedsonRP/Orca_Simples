/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package TelaCad_composto;

import MenuOrca.menuOrg;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import TiposHinfo.TIpos;
import TiposHinfo.unidades;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class Tela_IcompostoController extends menuOrg implements Initializable {

    /**
     * Initializes the controller class.
     */
    /*combobox A*/
    @FXML
    private Button butCancelar;
    
    @FXML
    private ComboBox<unidades> Cb_UnI;
    
    private List<unidades> uni = new ArrayList<>();
    
    private ObservableList<unidades> obs_uni;
    
    /*combobox 1*/
    @FXML
    private ComboBox<unidades> Cb_uni1;
    
    private List<unidades> uni1 = new ArrayList<>();
    
    private ObservableList<unidades> obs_uni1;
    
    /*combobox 2*/
    @FXML
    private ComboBox<unidades> Cb_uni2;
    
    private List<unidades> uni2 = new ArrayList<>();
    
    private ObservableList<unidades> obs_uni2;
    
    /*combobox Tipos*/
    @FXML
    private ComboBox<TIpos> Cb_tIPOS;
    
    private List<TIpos> tips = new ArrayList<>();
    
    private ObservableList<TIpos> obs_tips;
    
    public void carregarTipos(){
        TIpos alimenticios = new TIpos(1,"Alimenticios");
        TIpos estampa = new TIpos(2,"Estamparia");
        
        unidades kilo = new unidades(1, "Kg");
        unidades gramas = new unidades(2, "G");
        unidades metro = new unidades(3, "Metro(s)");
        unidades centimetro = new unidades(4, "Cm");
        unidades litro = new unidades(5, "L");
        unidades milimetro = new unidades(6, "mm");
        unidades centilitro = new unidades(7, "Cl");
        unidades mililitro = new unidades(8, "Ml");
        unidades unidade = new unidades(9, "U");
        
        uni.add(kilo);
        uni.add(gramas);
        uni.add(metro);
        uni.add(centimetro);
        uni.add(litro);
        uni.add(mililitro);
        uni.add(centilitro);
        uni.add(mililitro);
        uni.add(unidade);
        
        tips.add(alimenticios);
        tips.add(estampa);
        
        
        obs_uni = FXCollections.observableArrayList(uni);
        Cb_UnI.setItems(obs_uni);
        obs_uni1 = FXCollections.observableArrayList(uni);
        Cb_uni1.setItems(obs_uni1);
        obs_uni2 = FXCollections.observableArrayList(uni);
        Cb_uni2.setItems(obs_uni2);
        obs_tips = FXCollections.observableArrayList(tips);
        Cb_tIPOS.setItems(obs_tips);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTipos();
    }    
    
}
