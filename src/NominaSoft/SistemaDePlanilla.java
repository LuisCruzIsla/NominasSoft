/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NominaSoft;

import java.time.LocalDate;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class SistemaDePlanilla extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(new Date());
        System.out.println(java.sql.Date.valueOf(LocalDate.now()));
        System.out.println(LocalDate.now());
        Parent root = FXMLLoader.load(getClass().getResource("/Capa1_Presentacion/FormGestionarContrato.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        System.out.println(new Date());
    }
    
}