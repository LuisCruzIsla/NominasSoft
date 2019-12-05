/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Formularios.Controlador;

import Capa1_Presentacion.Utils.AlertMaker;
import Capa1_Presentacion.Utils.Constantes;
import Capa2_Aplicacion.ProcesarPagoServicio;
import Capa3_Dominio.Entidades.Pago;
import Capa3_Dominio.Entidades.Periodo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.text.DecimalFormat;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author COMPUTO-INGENIERIA
 */
public class FormProcesarPagoController implements Initializable {
    
    @FXML
    private JFXTreeTableView<Pago> treeView;
    
    @FXML
    private StackPane stackPane;

    @FXML
    private JFXButton btnProcesar;
    
    @FXML
    private DatePicker dpFechaFin;

    @FXML
    private DatePicker dpFechaInicio;
    
    //Data
    private Periodo periodo;
    
    @FXML
    private void procesar(ActionEvent event) {
        try{
            ProcesarPagoServicio procesarPagoServicio = new ProcesarPagoServicio();
            List<Pago> pagos = procesarPagoServicio.procesar(periodo);
            ObservableList<Pago> pagosObservable = FXCollections.observableArrayList(pagos);
            JFXTreeTableColumn<Pago,String> codigoEmpleado = new JFXTreeTableColumn<>("Codigo del Empleado");
            codigoEmpleado.setPrefWidth(80D);
            codigoEmpleado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    return new SimpleStringProperty(param.getValue().getValue().getContrato().getEmpleado().getId());
                }
            });
            JFXTreeTableColumn<Pago,String> nombreEmpleado = new JFXTreeTableColumn<>("Nombre del Empleado");
            nombreEmpleado.setPrefWidth(200D);
            nombreEmpleado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    return new SimpleStringProperty(param.getValue().getValue().getContrato().getEmpleado().getNombre());
                }
            });
            JFXTreeTableColumn<Pago,String> dniEmpleado = new JFXTreeTableColumn<>("DNI");
            dniEmpleado.setPrefWidth(75D);
            dniEmpleado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    return new SimpleStringProperty(""+param.getValue().getValue().getContrato().getEmpleado().getDni());
                }
            });
            JFXTreeTableColumn<Pago,String> totalDeHoras = new JFXTreeTableColumn<>("Total de Horas");
            totalDeHoras.setPrefWidth(100D);
            totalDeHoras.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    return new SimpleStringProperty(""+param.getValue().getValue().getTotalHoras());
                }
            });
            JFXTreeTableColumn<Pago,String> valorPorHora = new JFXTreeTableColumn<>("Valor por hora");
            valorPorHora.setPrefWidth(100D);
            valorPorHora.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().getValorHoras());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<Pago,String> sueldoBasico = new JFXTreeTableColumn<>("Sueldo Basico");
            sueldoBasico.setPrefWidth(100D);
            sueldoBasico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().calcularSueldoBasico());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<Pago,String> totalDeIngresos = new JFXTreeTableColumn<>("Total de Ingresos");
            totalDeIngresos.setPrefWidth(100D);
            totalDeIngresos.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().calcularTotalIngreso());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<Pago,String> totalDeDescuentos = new JFXTreeTableColumn<>("Total de Descuentos");
            totalDeDescuentos.setPrefWidth(100D);
            totalDeDescuentos.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().calcularTotalDescuento());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<Pago,String> sueldoNeto = new JFXTreeTableColumn<>("Sueldo Neto");
            sueldoNeto.setPrefWidth(100D);
            sueldoNeto.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Pago, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Pago, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().calcularSueldoNeto());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            TreeItem<Pago> root = new RecursiveTreeItem<Pago>(pagosObservable,RecursiveTreeObject::getChildren);
            treeView.getColumns().setAll(codigoEmpleado,nombreEmpleado,dniEmpleado,totalDeHoras,valorPorHora,sueldoBasico,totalDeIngresos,totalDeDescuentos,sueldoNeto);
            treeView.setRoot(root);
            treeView.setShowRoot(false);
            AlertMaker.showOK(stackPane, "Se procesaron los pagos de todos los empleados");
            actualizarPeriodo();
        }catch (Exception e) {
            AlertMaker.showError(stackPane, "Error: " + e.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualizarPeriodo();
    }    
    
    private void actualizarPeriodo(){
        try{
            ProcesarPagoServicio procesarPagoServicio = new ProcesarPagoServicio();
            periodo = procesarPagoServicio.buscarPeriodoActivo();
            dpFechaInicio.setValue(Constantes.DATE_TO_LOCALDATE_UTC(periodo.getFechaInicio()));
            dpFechaFin.setValue(Constantes.DATE_TO_LOCALDATE_UTC(periodo.getFechaFin()));
        }catch(Exception e){
            AlertMaker.showError(stackPane, "Error: " + e.getMessage());
        }
    }
    
}
