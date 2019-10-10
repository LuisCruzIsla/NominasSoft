/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FormGestionarContratoController implements Initializable {
    
    @FXML
    private JFXButton btnBuscar;
    
    @FXML
    private JFXTextField txtDNI;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Por favor ingresa el DNI.");
        validator.setIcon(new ImageView(getClass().getResource("/Imagenes/error.png").toString()));
        txtDNI.getValidators().add(validator);
        //Cuando salga del focus validar que no este vacio
        txtDNI.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) txtDNI.validate();
        });
        //Maximo de 8 digitos
        txtDNI.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtDNI.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (txtDNI.getText().length() > 8) {
                String s = txtDNI.getText().substring(0, 8);
                txtDNI.setText(s);
            }
        });
    }    
    
}
