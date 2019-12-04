/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Utils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import Capa1_Presentacion.Formularios.Controlador.interfaces.IOnClick;

/**
 *
 * @author user
 */
public class AlertMaker {
    
    public static void showMaterialDialog(StackPane root, Node nodeToBeBlurred, List<JFXButton> controls, String header, String body) {
        BoxBlur blur = new BoxBlur(3, 3, 3);
        if (controls.isEmpty()) {
            controls.add(new JFXButton("Okay"));
        }
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(root, dialogLayout, JFXDialog.DialogTransition.TOP);

        controls.forEach(controlButton -> {
            controlButton.getStyleClass().add("dialog-button");
            controlButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                dialog.close();
            });
        });

        dialogLayout.setHeading(new Label(header));
        dialogLayout.setBody(new Label(body));
        dialogLayout.setActions(controls);
        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            nodeToBeBlurred.setEffect(null);
        });
        nodeToBeBlurred.setEffect(blur);
    }
    
    public static void showOK(StackPane root, String mensaje,IOnClick iBtnAtras){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Respuesta"));
        content.setBody(new Text(mensaje));
        JFXDialog dialog = new JFXDialog(root,content,JFXDialog.DialogTransition.CENTER);
        JFXButton btnOK = new JFXButton("OK");
        btnOK.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        dialog.setOnDialogClosed(closeEvent -> {
            if(iBtnAtras!=null){
                iBtnAtras.onAtras();
            }
        });
        content.setActions(btnOK);
        dialog.show();
        //dialog.setOverlayClose(false);
    }
    
    public static void showOK(StackPane root, String mensaje){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Respuesta"));
        content.setBody(new Text(mensaje));
        JFXDialog dialog = new JFXDialog(root,content,JFXDialog.DialogTransition.CENTER);
        JFXButton btnOK = new JFXButton("OK");
        btnOK.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        content.setActions(btnOK);
        dialog.show();
        //dialog.setOverlayClose(false);
    }
    
    public static void showAdvertencia(StackPane root, String mensaje){
        JFXDialogLayout content = new JFXDialogLayout();
        Label text = new Label("Advertencia");
        text.setGraphic(new ImageView("/Imagenes/advertencia.png"));
        content.setHeading(text);
        content.setBody(new Text(mensaje));
        JFXDialog dialog = new JFXDialog(root,content,JFXDialog.DialogTransition.CENTER);
        JFXButton btnOK = new JFXButton("OK");
        btnOK.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        content.setActions(btnOK);
        dialog.show();
    }
    
    public static void showError(StackPane root, String mensaje){
        JFXDialogLayout content = new JFXDialogLayout();
        Label text = new Label("Error");
        text.setGraphic(new ImageView("/Imagenes/error.png"));
        content.setHeading(text);
        content.setBody(new Text(mensaje));
        JFXDialog dialog = new JFXDialog(root,content,JFXDialog.DialogTransition.CENTER);
        JFXButton btnOK = new JFXButton("OK");
        btnOK.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        content.setActions(btnOK);
        dialog.show();
    }
    
}
