/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FormAnularContratoController extends GestionarContrato implements Initializable {
    
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
            iBtnAtras.onAtras();
       });
        content.setActions(btnOK);
        dialog.show();
        //dialog.setOverlayClose(false);
    }
    
    @FXML
    private void atras(ActionEvent event){
        iBtnAtras.onAtras();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
