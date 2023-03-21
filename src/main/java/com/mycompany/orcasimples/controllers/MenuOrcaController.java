package com.mycompany.orcasimples.controllers;

import javafx.fxml.FXML;
import com.mycompany.orcasimples.model.util.FxmlTools;
import com.mycompany.orcasimples.model.util.FileTools;
import java.io.IOException;
import java.net.URL;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private AnchorPane subScene;

    @FXML
    void setSimpleFoodsctockCadScene(MouseEvent event) throws IOException {                       
        Parent node = FxmlTools.loadFXML("telaCad_simples");
        subScene.getChildren().add(node);
    }
}
