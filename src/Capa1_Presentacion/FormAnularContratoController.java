/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FormAnularContratoController implements Initializable {
    
    @FXML
    private StackPane stackPane;
    
    @FXML
    private void anularContrato(ActionEvent event){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Respuesta"));
        content.setBody(new Text("Se anuló el contrato."));
        JFXDialog dialog = new JFXDialog(stackPane,content,JFXDialog.DialogTransition.CENTER);
        JFXButton btnOK = new JFXButton("OK");
        btnOK.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        dialog.setOnDialogClosed(closeEvent -> {
            Stage stage = (Stage) stackPane.getScene().getWindow();
            stage.close();
       });
        content.setActions(btnOK);
        dialog.show();
        //dialog.setOverlayClose(false);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
