/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion;

import Capa2_Aplicacion.GestionarContratoServicio;
import Capa3_Dominio.Empleado;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    private StackPane stackPane;
    
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
        
    @FXML
    private void buscarEmpleado(ActionEvent event){
        String cadenaDNI = txtDNI.getText();
        if(!cadenaDNI.isEmpty()){
            try{
                int dni = Integer.parseInt(cadenaDNI);
                GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
                Empleado empleado = gestionarContratoServicio.buscarEmpleadoPorDNI(dni);
                if(empleado!=null){
                    lbNombre.setText(empleado.getNombre());
                    lbDireccion.setText(empleado.getDireccion());
                    lbTelefono.setText("+51"+empleado.getTelefono());
                    lbFechaDeNacimiento.setText(""+empleado.getFechaNacimiento());
                    lbEstadoCivil.setText(""+empleado.getEstadoCivil());
                    lbGradoAcadameico.setText(empleado.getGradoAcademico());
                    btnCrearContrato.setDisable(false);
                    btnEditarContrato.setDisable(false);
                    btnAnularContrato.setDisable(false);
                }else{
                    JFXDialogLayout content = new JFXDialogLayout();
                    Label text = new Label("Error");
                    text.setGraphic(new ImageView("/Imagenes/error.png"));
                    content.setHeading(text);
                    content.setBody(new Text("No existe el empleado."));
                    JFXDialog dialog = new JFXDialog(stackPane,content,JFXDialog.DialogTransition.CENTER);
                    JFXButton btnOK = new JFXButton("OK");
                    btnOK.setOnAction((ActionEvent event1) -> {
                        dialog.close();
                    });
                    content.setActions(btnOK);
                    dialog.show();
                }
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
    
    @FXML
    private void crearContrato(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Capa1_Presentacion/FormCrearContrato.fxml"));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Capa1_Presentacion/FormEditarContrato.fxml"));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Capa1_Presentacion/FormAnularContrato.fxml"));
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
