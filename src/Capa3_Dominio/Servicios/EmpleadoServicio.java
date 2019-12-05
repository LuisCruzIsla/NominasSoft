/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Servicios;

import Capa3_Dominio.Entidades.Empleado;

/**
 *
 * @author user
 */
public class EmpleadoServicio {
    
    public String formatEstadoCivilEmpleado(Empleado empleado) {
        switch (empleado.getEstadoCivil()) {
            case 'C':
                return "Casado";
            case 'S':
                return "Soltero";
            case 'D':
                return "divorciado";
            case 'V':
                return "Viudo";
            default:
                break;
        }
        return "";
    }
    
}
