/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Controlador;

import Capa3_Dominio.Pago;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author COMPUTO-INGENIERIA
 */
public class FormProcesarPagoController implements Initializable {
    
    @FXML
    private JFXTreeTableView<Pago> treeView;

    @FXML
    private JFXButton btnProcesar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
