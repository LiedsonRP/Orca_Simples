/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package TelaCad_InsuSimples;

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

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class TelaCad_insumoSimplesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox<TIpos> cb_TiposInsumos;
    
    private List<TIpos> ctg = new ArrayList<>();
    
    private ObservableList<TIpos> obs_tipos;

    @FXML
    private ComboBox<unidades> cb_UnidadeM;
    
    private List<unidades> uni = new ArrayList<>();
    
    private ObservableList<unidades> obs_unidades;
    
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
        unidades unidade = new unidades(8, "U");
        
        uni.add(kilo);
        uni.add(gramas);
        uni.add(metro);
        uni.add(centimetro);
        uni.add(litro);
        uni.add(mililitro);
        uni.add(centilitro);
        uni.add(mililitro);
        uni.add(unidade);
        
        
        ctg.add(alimenticios);
        ctg.add(estampa);
        
        obs_tipos = FXCollections.observableArrayList(ctg);
        obs_unidades = FXCollections.observableArrayList(uni);
        
        cb_TiposInsumos.setItems(obs_tipos);
        cb_UnidadeM.setItems(obs_unidades);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTipos();
    }    
    
}
