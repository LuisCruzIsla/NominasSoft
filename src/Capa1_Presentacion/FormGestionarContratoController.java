/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FormGestionarContratoController implements Initializable {
    
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnCrearContrato;
    @FXML
    private JFXButton btnEditarContrato;
    @FXML
    private JFXButton btnAnularContrato;
    
    @FXML
    private JFXTextField txtDNI;
    
    @FXML
    private void buscarEmpleado(ActionEvent event){
        String dni = txtDNI.getText();
        if(!dni.isEmpty()){
            btnCrearContrato.setDisable(false);
            btnEditarContrato.setDisable(false);
            btnAnularContrato.setDisable(false);
        }
    }
    
    @FXML
    private void crearContrato(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Presentacion/FormCrearContrato.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Crear Contrato");
            stage.setScene(new Scene(root1));  
            stage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    @FXML
    private void editarContrato(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Presentacion/FormEditarContrato.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Editar Contrato");
            stage.setScene(new Scene(root1));  
            stage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    @FXML
    private void anularContrato(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Presentacion/FormAnularContrato.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Anular Contrato");
            stage.setScene(new Scene(root1));  
            stage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

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
