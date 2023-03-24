package com.mycompany.orcasimples.controllers;

import javafx.fxml.FXML;
import com.mycompany.orcasimples.model.util.FxmlTools;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
    private Pane subScene;            
    
    @FXML
    void setSimpleFoodsctockCadScene(MouseEvent event){                                       
        setSceneInSubScene("telaCadSimples");
    }
    
    @FXML
    void setCompoundFoodstockScene(MouseEvent event) {
        setSceneInSubScene("telaCadCompoundFoodstock");
    }

    @FXML
    void setPackagingCadScene(MouseEvent event) {
        setSceneInSubScene("telaCadEmbalagem");
    }

    @FXML
    void setProductCadScene(MouseEvent event) {
        setSceneInSubScene("telaCadProduto");
    }
    
    private void setSceneInSubScene(String sceneName) {
        Parent node;                                                  
        try {
            
            if (!subScene.getChildren().isEmpty()) {
                subScene.getChildren().remove(0);
            }
            
            node = FxmlTools.loadFXML(sceneName);
            subScene.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(MenuOrcaController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
