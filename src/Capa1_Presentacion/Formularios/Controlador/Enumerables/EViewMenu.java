/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Formularios.Controlador.Enumerables;

import Capa1_Presentacion.Utils.View;
import javafx.scene.Parent;

/**
 *
 * @author user
 */
public enum EViewMenu {

    GESTIONAR_CONTRATO(View.GESTIONAR_CONTRATO, null),
    PROCESAR_PAGO(View.PROCESAR_PAGO,null),
    REGISTRAR_EMPLEADO("",null),
    SALIR("",null);
        
    private final String view;
    private Parent root;

    private EViewMenu(String view, Parent root) {
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
