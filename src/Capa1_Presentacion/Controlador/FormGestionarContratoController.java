/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Controlador;

import Capa2_Aplicacion.GestionarContratoServicio;
import Capa3_Dominio.Contrato;
import Capa3_Dominio.Empleado;
import Utils.AlertMaker;
import Utils.Constantes;
import Utils.View;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
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
public class FormGestionarContratoController implements Initializable {
    
    @FXML
    private AnchorPane rootMain;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane mainContainer;
    
    @FXML
    private JFXTextField txtDNI;
    
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbDireccion;
    @FXML
    private Label lbTelefono;
    @FXML
    private Label lbFechaDeNacimiento;
    @FXML
    private Label lbEstadoCivil;
    @FXML
    private Label lbGradoAcadameico;    
    
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnCrearContrato;
    @FXML
    private JFXButton btnEditarContrato;
    @FXML
    private JFXButton btnAnularContrato;
    
    //Data
    private Empleado empleado;
    private Contrato contrato;
        
    @FXML
    private void buscarEmpleado(ActionEvent event){
        String cadenaDNI = txtDNI.getText();
        if(!cadenaDNI.isEmpty()){
            try{
                int dni = Integer.parseInt(cadenaDNI);
                GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
                empleado = gestionarContratoServicio.buscarEmpleadoPorDNI(dni);
                if(empleado!=null){
                    contrato = gestionarContratoServicio.buscarContratoPorEmpleado(empleado);
                    lbNombre.setText(empleado.getNombre());
                    lbDireccion.setText(empleado.getDireccion());
                    lbTelefono.setText("+51"+empleado.getTelefono());
                    lbFechaDeNacimiento.setText(""+empleado.getFechaNacimiento());
                    lbEstadoCivil.setText(formatEstadoCivilEmpleado(empleado));
                    lbGradoAcadameico.setText(empleado.getGradoAcademico());
                    btnCrearContrato.setDisable(false);
                    btnEditarContrato.setDisable(false);
                    btnAnularContrato.setDisable(false);
                }else{
                    AlertMaker.showError(stackPane,"No existe el empleado.");
                }
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
    
    @FXML
    private void crearContrato(ActionEvent event){
        openViewGestionarContrato(View.CREAR_CONTRATO);
    }
    
    @FXML
    private void editarContrato(ActionEvent event){
        if(contrato== null || !contrato.esVigente()){
            AlertMaker.showError(stackPane,"No hay contrato vigente.");
            return;
        }
        openViewGestionarContrato(View.EDITAR_CONTRATO);
    }
    
    @FXML
    private void anularContrato(ActionEvent event){
        openViewGestionarContrato(View.ANULAR_CONTRATO);
    }
    
    private void openViewGestionarContrato(String view){
        try{
            FXMLLoader loader = Constantes.getInstance().pathViewFXML(view);
            Parent parent = loader.load();
            GestionarContrato controller = loader.getController();
            controller.setEmpleado(empleado);
            controller.setContratoAntiguo(contrato);
            controller.setiBtnAtras(() -> {
                rootMain.getChildren().clear();
                rootMain.getChildren().add(stackPane);
            });
            rootMain.getChildren().clear();
            rootMain.getChildren().add(parent);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    private String formatEstadoCivilEmpleado(Empleado empleado){
        if(empleado.getEstadoCivil()=='C'){
            return "Casado";
        }else if(empleado.getEstadoCivil()=='S'){
            return "Soltero";
        }else if(empleado.getEstadoCivil()=='D'){
            return "divorciado";
        }else if(empleado.getEstadoCivil()=='V'){
            return "Viudo";
        }
        return "";
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
