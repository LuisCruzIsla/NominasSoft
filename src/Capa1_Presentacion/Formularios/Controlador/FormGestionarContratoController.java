/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Formularios.Controlador;

import Capa1_Presentacion.Formularios.Controlador.parent.GestionarContrato;
import Capa1_Presentacion.Formularios.Controlador.interfaces.IOnClick;
import Capa2_Aplicacion.GestionarContratoServicio;
import Capa3_Dominio.Entidades.Contrato;
import Capa3_Dominio.Entidades.Empleado;
import Capa1_Presentacion.Utils.AlertMaker;
import Capa1_Presentacion.Utils.Constantes;
import Capa1_Presentacion.Utils.View;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

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
    private void buscarEmpleado(ActionEvent event) {
        String cadenaDNI = txtDNI.getText();
        if (!cadenaDNI.isEmpty()) {
            try {
                int dni = Integer.parseInt(cadenaDNI);
                GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
                empleado = gestionarContratoServicio.buscarEmpleadoPorDNI(dni);
                if (empleado != null) {
                    lbNombre.setText(empleado.getNombre());
                    lbDireccion.setText(empleado.getDireccion());
                    lbTelefono.setText("+51" + empleado.getTelefono());
                    lbFechaDeNacimiento.setText("" + empleado.getFechaNacimiento());
                    lbEstadoCivil.setText(formatEstadoCivilEmpleado(empleado));
                    lbGradoAcadameico.setText(empleado.getGradoAcademico().getNombreGrado());
                    btnCrearContrato.setDisable(false);
                    btnEditarContrato.setDisable(false);
                    btnAnularContrato.setDisable(false);
                } else {
                    AlertMaker.showError(stackPane, "No existe el empleado.");
                }
            } catch (Exception e) {
                AlertMaker.showError(stackPane, "Error: " + e.getMessage());
            }
        }
    }

    @FXML
    private void crearContrato(ActionEvent event) {
        openViewGestionarContrato(View.CREAR_CONTRATO);
    }

    @FXML
    private void editarContrato(ActionEvent event) {
        try {
            GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
            contrato = gestionarContratoServicio.buscarContratoPorEmpleado(empleado);
            if (contrato == null || !contrato.esVigente()) {
                AlertMaker.showError(stackPane, "No existe ningun contrato vigente.");
                return;
            }
            openViewGestionarContrato(View.EDITAR_CONTRATO);
        } catch (Exception e) {
            AlertMaker.showError(stackPane, "Error: " + e.getMessage());
        }
    }

    @FXML
    private void anularContrato(ActionEvent event) {
        try {
            GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
            contrato = gestionarContratoServicio.buscarContratoPorEmpleado(empleado);
            System.out.println(contrato);
            if (contrato == null || !contrato.esVigente()) {
                AlertMaker.showError(stackPane, "No existe ningun contrato vigente.");
                return;
            }
            openViewGestionarContrato(View.ANULAR_CONTRATO);
        } catch (Exception e) {
            AlertMaker.showError(stackPane, "Error: " + e.getMessage());
        }
    }

    private void openViewGestionarContrato(String view) {
        try {
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String formatEstadoCivilEmpleado(Empleado empleado) {
        switch (empleado.getEstadoCivil()) {
            case 'C':
                return "Casado";
            case 'S':
                return "Soltero";
            case 'D':
                return "divorciado";
            case 'V':
                return "Viudo";
            default:
                break;
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
        txtDNI.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtDNI.validate();
            }
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
