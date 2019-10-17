/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Controlador;

import Capa3_Dominio.Empleado;

/**
 *
 * @author user
 */
public class GestionarContrato {
    
    //Data
    protected IBtnAtras iBtnAtras;
    protected Empleado empleado;

    public IBtnAtras getiBtnAtras() {
        return iBtnAtras;
    }

    public void setiBtnAtras(IBtnAtras iBtnAtras) {
        this.iBtnAtras = iBtnAtras;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
