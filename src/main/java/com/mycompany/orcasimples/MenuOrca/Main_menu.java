/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package com.mycompany.orcasimples.MenuOrca;


import com.mycompany.orcasimples.OpcoesDeCad.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Acer
 */
public class Main_menu extends Application {
    
    private static Scene sceneSimples;
    private static Scene sceneOpCad;
    private static Scene sceneComposto;
    private static Scene sceneProduto;
    static Scene sceneMenu;
    static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader menuOrca = new FXMLLoader(getClass().getResource("MenuOrca.fxml"));
        FXMLLoader talaOpcao = new FXMLLoader(getClass().getResource("../TelaCad_embalagem/telaCad_embalagem.fxml"));
        FXMLLoader telaSimples = new FXMLLoader(getClass().getResource("../TelaCad_Simples/telaCad_simples.fxml"));
        FXMLLoader telaComposto = new FXMLLoader(getClass().getResource("../TelaCad_Composto/Tela_Icomposto.fxml"));
        FXMLLoader telaProduto = new FXMLLoader(getClass().getResource("../TelaCad_Produto/telaCadProduto.fxml"));
        primaryStage = stage;
        
        primaryStage.setTitle("Orçamento Simples");
        
        Parent parentMenu = menuOrca.load();
        Parent parentOpCad = talaOpcao.load();
        Parent parentSimples = telaSimples.load();
        Parent parentComposto = telaComposto.load();
        Parent parentProduto = telaProduto.load();
        
        
        sceneMenu = new Scene(parentMenu);
        sceneOpCad = new Scene(parentOpCad);
        sceneSimples = new Scene(parentSimples);
        sceneComposto = new Scene(parentComposto);
        sceneProduto = new Scene(parentProduto);
        
        
        
        stage.setScene(sceneMenu);
        stage.show();
        stage.setMaximized(true);
        
    }
    
    public static void changeScreen(int telas){
        switch(telas){
            case 1:
                primaryStage.setScene(sceneMenu);
                primaryStage.setMaximized(true);
                primaryStage.setResizable(true);
                
                break;
            case 2:
                primaryStage.setMaximized(true);
                primaryStage.setResizable(true);
                primaryStage.setScene(sceneOpCad);
                
                 break;
            case 3:
                primaryStage.setMaximized(true);
                primaryStage.setResizable(true);
                primaryStage.setScene(sceneSimples);
                break;
            case 4:
                primaryStage.setMaximized(true);
                primaryStage.setResizable(true);
                primaryStage.setScene(sceneComposto);
                break;
            case 5:
                primaryStage.setMaximized(true);
                primaryStage.setResizable(true);
                primaryStage.setScene(sceneProduto);
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
