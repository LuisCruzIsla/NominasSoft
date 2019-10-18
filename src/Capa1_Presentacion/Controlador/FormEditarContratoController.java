/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Controlador;

import Capa1_Presentacion.Utils.AlertMaker;
import Capa2_Aplicacion.GestionarContratoServicio;
import Capa3_Dominio.AFP;
import Capa3_Dominio.Contrato;
import Capa1_Presentacion.Utils.Constantes;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
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
    private void editarContrato(ActionEvent event) {
        String cargo = txtCargo.getText();
        String horasPorSemanaTexto = txtHorasSemana.getText();
        String valorPorHoraTexto = txtValorPorHora.getText();
        LocalDate fechaInicio = dpFechaInicio.getValue();
        LocalDate fechaFin = dpFechaFin.getValue();
        AFP afp = cmbAFP.getValue();

        if (cargo.isEmpty() || horasPorSemanaTexto.isEmpty() || valorPorHoraTexto.isEmpty()) {
            AlertMaker.showAdvertencia(stackPane, "No pueden existir campos vacios.");
            return;
        }

        if (fechaInicio == null || fechaFin == null) {
            AlertMaker.showAdvertencia(stackPane, "Por favor rellena los campos de fechas.");
            return;
        }

        if (fechaInicio.getYear() < 2000 || fechaFin.getYear() < 2000) {
            AlertMaker.showAdvertencia(stackPane, "No puedes registrar un contrato antes del año 2000.");
            return;
        }

        if (afp == null) {
            AlertMaker.showAdvertencia(stackPane, "Por favor seleccione una AFP.");
            return;
        }

        int horasPorSemana = Integer.parseInt(horasPorSemanaTexto);
        double valorPorHora = Double.parseDouble(valorPorHoraTexto);

        Contrato contrato = new Contrato();
        contrato.setContratoId(contratoAntiguo.getContratoId());
        contrato.setFechaInicio(Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        contrato.setFechaFin(Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        contrato.setCargo(cargo);
        contrato.setAfp(afp);
        contrato.setAsignacionFamiliar(cbAsignacionFamiliar.isSelected());
        contrato.setTotalHorasSemanal(horasPorSemana);
        contrato.setValorPorHora(valorPorHora);
        contrato.setEmpleado(empleado);

        try {
            GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
            int registros_afectados = gestionarContratoServicio.actualizarContrato(contrato);
            if (registros_afectados == 1) {
                AlertMaker.showOK(stackPane, "Se guardó las modificaciones del contrato.", iBtnAtras);
            } else {
                AlertMaker.showError(stackPane, "Error al editar.");
            }
        } catch (Exception e) {
            AlertMaker.showError(stackPane, "Error: " + e.getMessage());
        }
    }

    @FXML
    private void atras(ActionEvent event) {
        iBtnAtras.onAtras();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        txtHorasSemana.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtHorasSemana.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        txtValorPorHora.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.isEmpty()){
                txtValorPorHora.setText(newValue);
                return;
            }
            newValue = newValue.trim().replaceAll("[dDfF]","");
            txtValorPorHora.setText(newValue);
            try {
                double valor = Double.parseDouble(newValue);
            } catch (Exception e) {
                txtValorPorHora.setText(oldValue);
            }
        });
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
