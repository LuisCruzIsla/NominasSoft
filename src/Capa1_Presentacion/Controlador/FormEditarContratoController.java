/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Controlador;

import Capa2_Aplicacion.GestionarContratoServicio;
import Capa3_Dominio.AFP;
import Capa3_Dominio.Contrato;
import Capa3_Dominio.Empleado;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FormEditarContratoController extends GestionarContrato implements Initializable {
    
    @FXML
    private StackPane stackPane;
    
    @FXML
    private DatePicker dpFechaInicio;
    @FXML
    private DatePicker dpFechaFin;
    
    @FXML
    private JFXTextField txtCargo;
    @FXML
    private JFXTextField txtHorasSemana;
    @FXML
    private JFXTextField txtValorPorHora;
    
    @FXML
    private JFXComboBox<AFP> cmbAFP;
    
    @FXML
    private JFXCheckBox cbAsignacionFamiliar;
    
    @FXML
    private void editarContrato(ActionEvent event){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Respuesta"));
        content.setBody(new Text("Se guardó las modificaciones del contrato."));
        JFXDialog dialog = new JFXDialog(stackPane,content,JFXDialog.DialogTransition.CENTER);
        JFXButton btnOK = new JFXButton("OK");
        btnOK.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        dialog.setOnDialogClosed(closeEvent -> {
            iBtnAtras.atras();
       });
        content.setActions(btnOK);
        dialog.show();
        //dialog.setOverlayClose(false);
    }
    
    @FXML
    private void atras(ActionEvent event){
        iBtnAtras.atras();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
            List<AFP> listAFP = gestionarContratoServicio.obtenerListaAFP();
            cmbAFP.getItems().addAll(listAFP);
            cmbAFP.setConverter(new StringConverter<AFP>() {
                @Override
                public String toString(AFP object) {
                    return object.getNombre();
                }

                @Override
                public AFP fromString(String string) {
                    return null;
                }
            });
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        txtHorasSemana.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtHorasSemana.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        txtValorPorHora.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtValorPorHora.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }    
    
    public void setContratoAntiguo(Contrato contratoAntiguo) {
        this.contratoAntiguo = contratoAntiguo;
        start();
    }
    
    public void start() {
        //dpFechaInicio.setValue(contratoAntiguo.getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        //dpFechaFin.setValue(contratoAntiguo.getFechaFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        txtCargo.setText(contratoAntiguo.getCargo());
        cmbAFP.setValue(contratoAntiguo.getAfp());
    }
    
}
