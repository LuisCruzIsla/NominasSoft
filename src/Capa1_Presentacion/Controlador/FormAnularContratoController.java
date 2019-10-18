/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Controlador;

import Capa1_Presentacion.Utils.AlertMaker;
import Capa1_Presentacion.Utils.Constantes;
import Capa2_Aplicacion.GestionarContratoServicio;
import Capa3_Dominio.AFP;
import Capa3_Dominio.Contrato;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FormAnularContratoController extends GestionarContrato implements Initializable {
    
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
    private void anularContrato(ActionEvent event){
        try{
            GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
            int registros_afectados = gestionarContratoServicio.anularContrato(contratoAntiguo);
            if(registros_afectados == 1){
                 AlertMaker.showOK(stackPane,"Se anuló el contrato.",iBtnAtras);
            }else{
                AlertMaker.showError(stackPane,"Error al anular.");
            }
        }catch(Exception e){
            AlertMaker.showError(stackPane,"Error: "+e.getMessage());
        }
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
    }
    
    public void setContratoAntiguo(Contrato contratoAntiguo) {
        this.contratoAntiguo = contratoAntiguo;
        start();
    }

    public void start() {
        dpFechaInicio.setValue(Constantes.DATE_TO_LOCALDATE(contratoAntiguo.getFechaInicio()));
        dpFechaFin.setValue(Constantes.DATE_TO_LOCALDATE(contratoAntiguo.getFechaFin()));
        txtCargo.setText(contratoAntiguo.getCargo());
        for (int i = 0; i < cmbAFP.getItems().size(); i++) {
            if (cmbAFP.getItems().get(i).getId() == contratoAntiguo.getAfp().getId()) {
                cmbAFP.getSelectionModel().select(i);
            }
        }
        cbAsignacionFamiliar.setSelected(contratoAntiguo.isAsignacionFamiliar());
        txtHorasSemana.setText("" + contratoAntiguo.getTotalHorasSemanal());
        txtValorPorHora.setText(Double.toString(contratoAntiguo.getValorPorHora()));
    }
    
}
