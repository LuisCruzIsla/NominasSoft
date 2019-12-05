/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Formularios.Controlador;

import Capa1_Presentacion.Utils.Constantes;
import Capa1_Presentacion.Utils.View;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FormMenuPrincipalController implements Initializable {
    
    private enum EViewMenu{
        
        GESTIONAR_CONTRATO(View.GESTIONAR_CONTRATO,null),
        PROCESAR_PAGO(View.PROCESAR_PAGO,null),
        REGISTRAR_EMPLEADO("",null),
        SALIR("",null);
        
        private final String view;
        private Parent root;
        
        private EViewMenu(String view,Parent root) {
            this.view = view;
            this.root = root;
        }
        
        public String getView() {
            return view;
        }

        public Parent getRoot() {
            return root;
        }

        public void setRoot(Parent root) {
            this.root = root;
        }  
        
    }
    
    private static final String COLOR_NORMAL_BUTTON = "#03A9F4"; //Light Blue 500
    private static final String COLOR_SELECT_BUTTON = "#0277BD"; //Light Blue 800
    
    private EViewMenu viewActual;
    
    @FXML
    private BorderPane bpMain;
    
    @FXML
    private JFXButton btnGestionarContrato;
    @FXML
    private JFXButton btnProcesarPago;
    @FXML
    private JFXButton btnRegistrarEmpleado;
    @FXML
    private JFXButton btnSalir;
    
    @FXML
    private void gestionarContrato(ActionEvent event) throws Exception{
        openView(EViewMenu.GESTIONAR_CONTRATO);
    }
    
    @FXML
    private void procesarPago(ActionEvent event) throws Exception{
        openView(EViewMenu.PROCESAR_PAGO);
    }
    
    @FXML
    private void registrarEmpleado(ActionEvent event) throws Exception{
        openView(EViewMenu.REGISTRAR_EMPLEADO);
    }
    
    @FXML
    private void salir(ActionEvent event) throws Exception{
        System.exit(0);
        //openView(EViewMenu.SALIR);
    }
    
    private void openView(EViewMenu viewMenu) throws Exception{
        if(viewActual==null || !viewActual.equals(viewMenu)){
            if(!viewMenu.getView().isEmpty()){
                if(viewMenu.getRoot()==null){
                    Parent root = Constantes.getInstance().pathViewParent(viewMenu.getView());
                    viewMenu.setRoot(root);
                }
                bpMain.setCenter(viewMenu.getRoot());
            }
            viewActual = viewMenu;
            actualizarBackgroundBotones();
        }
    }

    private void actualizarBackgroundBotones() {
        verificarEstadoButton(btnGestionarContrato,EViewMenu.GESTIONAR_CONTRATO);
        verificarEstadoButton(btnProcesarPago,EViewMenu.PROCESAR_PAGO);
        verificarEstadoButton(btnRegistrarEmpleado,EViewMenu.REGISTRAR_EMPLEADO);
        verificarEstadoButton(btnSalir,EViewMenu.SALIR);
    }
    
    private void verificarEstadoButton(JFXButton button, EViewMenu viewMenu){
        button.setStyle("-fx-border-color: white; -fx-border-width: 0px 0px 2px 0px;"
                +"-fx-background-color:"+
                        (viewActual.equals(viewMenu) 
                                ? COLOR_SELECT_BUTTON 
                                : COLOR_NORMAL_BUTTON));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            openView(EViewMenu.GESTIONAR_CONTRATO);
        } catch (Exception ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }    
    
}
