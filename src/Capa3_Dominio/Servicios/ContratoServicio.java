/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Servicios;

import Capa3_Dominio.Entidades.Contrato;

/**
 *
 * @author LuisCriz
 */
public class ContratoServicio {
    public void validarDatos(Contrato contrato, Contrato contratoAnterior) throws Exception{
    
    if(contratoAnterior!=null && !contratoAnterior.esVigente()){
            throw new Exception("El contrato anterior aun es vigente");
        }
        
        if(!contrato.esRenovable(contratoAnterior)){
            throw new Exception("Hay un contrato pendiente, no puedes crear un nuevo contrato.");
        }
        
        if(!contrato.esFechaValida()){
            throw new Exception("Las fechas no son validas");
        }
        
        if(!contrato.esHoraValidaPorSemana()){
            throw new Exception("El total de horas contratadas no es valido.");
        }
        
        if(!contrato.esValorizacionAceptada()){
            throw new Exception("El valor por hora no corresponde a su grado academico.");
        }
        
    }
    
}
