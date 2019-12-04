/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Formularios.Controlador.parent;

import Capa1_Presentacion.Formularios.Controlador.interfaces.IOnClick;
import Capa3_Dominio.Entidades.Contrato;
import Capa3_Dominio.Entidades.Empleado;

/**
 *
 * @author user
 */
public class GestionarContrato {
        
    //Data
    protected IOnClick iBtnAtras;
    protected Empleado empleado;
    protected Contrato contratoAntiguo;

    public IOnClick getiBtnAtras() {
        return iBtnAtras;
    }

    public void setiBtnAtras(IOnClick iBtnAtras) {
        this.iBtnAtras = iBtnAtras;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Contrato getContratoAntiguo() {
        return contratoAntiguo;
    }

    public void setContratoAntiguo(Contrato contratoAntiguo) {
        this.contratoAntiguo = contratoAntiguo;
    }
    
}
