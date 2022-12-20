/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package MenuOrca;


import OpcoesDeCad.*;
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
    static Scene sceneMenu;
    static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader menuOrca = new FXMLLoader(getClass().getResource("MenuOrca.fxml"));
        FXMLLoader talaOpcao = new FXMLLoader(getClass().getResource("../TelaCad_embalagem/telaCad_embalagem.fxml"));
        FXMLLoader telaSimples = new FXMLLoader(getClass().getResource("../TelaCad_Simples/telaCad_simples.fxml"));
        primaryStage = stage;
        
        primaryStage.setTitle("Orçamento Simples");
        
        Parent parentMenu = menuOrca.load();
        Parent parentOpCad = talaOpcao.load();
        Parent parentSimples = telaSimples.load();
        
        
        sceneMenu = new Scene(parentMenu);
        sceneOpCad = new Scene(parentOpCad);
        sceneSimples = new Scene(parentSimples);
        
        
        
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
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
