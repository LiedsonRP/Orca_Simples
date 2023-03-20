package com.mycompany.orcasimples.controllers;

import com.mycompany.orcasimples.App;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MenuOrcaController {

    @FXML
    private Button btnCadCompFoostock;

    @FXML
    private Button btnCadPackaging;

    @FXML
    private Button btnCadProduct;

    @FXML
    private Button btnCadSimpleFoodstock;

    @FXML
    private Button btnShowCompFoodstock;

    @FXML
    private Button btnShowPackagingTable;

    @FXML
    private Button btnShowProdTable;

    @FXML
    private Button btnShowSimpleFoodstock;

    @FXML
    private SubScene subScene;
    
    @FXML
    public void setSimpleFoodsctockCadScene(MouseEvent event) {   
        try {
            subScene = new SubScene(loadFXML("../telaCad_simples"), 0, 0);
        } catch (IOException ex) {
            Logger.getLogger(MenuOrcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
