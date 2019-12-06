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
import Capa1_Presentacion.Formularios.Controlador.parent.PagoTable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author COMPUTO-INGENIERIA
 */
public class FormProcesarPagoController implements Initializable {
    
    @FXML
    private JFXTreeTableView<PagoTable> treeView;
    
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
            List<Pago> pagosTemp = procesarPagoServicio.procesar(periodo);
            List<PagoTable> pagos = new ArrayList<>();
            for(Pago pago : pagosTemp){
                pagos.add(new PagoTable(pago));
            }
            ObservableList<PagoTable> pagosObservable = FXCollections.observableArrayList(pagos);
            JFXTreeTableColumn<PagoTable,String> codigoEmpleado = new JFXTreeTableColumn<>("Codigo del Empleado");
            codigoEmpleado.setPrefWidth(80D);
            codigoEmpleado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    return new SimpleStringProperty(param.getValue().getValue().getPago().getContrato().getEmpleado().getId());
                }
            });
            JFXTreeTableColumn<PagoTable,String> nombreEmpleado = new JFXTreeTableColumn<>("Nombre del Empleado");
            nombreEmpleado.setPrefWidth(200D);
            nombreEmpleado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    return new SimpleStringProperty(param.getValue().getValue().getPago().getContrato().getEmpleado().getNombre());
                }
            });
            JFXTreeTableColumn<PagoTable,String> dniEmpleado = new JFXTreeTableColumn<>("DNI");
            dniEmpleado.setPrefWidth(75D);
            dniEmpleado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    return new SimpleStringProperty(""+param.getValue().getValue().getPago().getContrato().getEmpleado().getDni());
                }
            });
            JFXTreeTableColumn<PagoTable,String> totalDeHoras = new JFXTreeTableColumn<>("Total de Horas");
            totalDeHoras.setPrefWidth(100D);
            totalDeHoras.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    return new SimpleStringProperty(""+param.getValue().getValue().getPago().getTotalHoras());
                }
            });
            JFXTreeTableColumn<PagoTable,String> valorPorHora = new JFXTreeTableColumn<>("Valor por hora");
            valorPorHora.setPrefWidth(100D);
            valorPorHora.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().getPago().getValorHoras());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<PagoTable,String> sueldoBasico = new JFXTreeTableColumn<>("Sueldo Basico");
            sueldoBasico.setPrefWidth(100D);
            sueldoBasico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().getPago().calcularSueldoBasico());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<PagoTable,String> totalDeIngresos = new JFXTreeTableColumn<>("Total de Ingresos");
            totalDeIngresos.setPrefWidth(100D);
            totalDeIngresos.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().getPago().calcularTotalIngreso());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<PagoTable,String> totalDeDescuentos = new JFXTreeTableColumn<>("Total de Descuentos");
            totalDeDescuentos.setPrefWidth(100D);
            totalDeDescuentos.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().getPago().calcularTotalDescuento());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            JFXTreeTableColumn<PagoTable,String> sueldoNeto = new JFXTreeTableColumn<>("Sueldo Neto");
            sueldoNeto.setPrefWidth(100D);
            sueldoNeto.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTable, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PagoTable, String> param) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    String valor = format.format(param.getValue().getValue().getPago().calcularSueldoNeto());
                    return new SimpleStringProperty("S/. "+valor);
                }
            });
            TreeItem<PagoTable> root = new RecursiveTreeItem<PagoTable>(pagosObservable,RecursiveTreeObject::getChildren);
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
