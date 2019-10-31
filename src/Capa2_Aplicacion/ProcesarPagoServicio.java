/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa2_Aplicacion;

import Capa3_Dominio.Concepto;
import Capa3_Dominio.Contrato;
import Capa3_Dominio.Pago;
import Capa3_Dominio.Periodo;
import Capa4_Persistencia.ConceptoDAO;
import Capa4_Persistencia.ContratoDAO;
import Capa4_Persistencia.Gestores.GestorGlobal;
import Capa4_Persistencia.Gestores.GestorJDBC;
import Capa4_Persistencia.PeriodoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ProcesarPagoServicio {
    
    private GestorJDBC gestorJDBC;
    private ContratoDAO contratoDAO;
    private PeriodoDAO periodoDAO;
    private ConceptoDAO conceptoDAO;
    
    public ProcesarPagoServicio(){
        gestorJDBC = GestorGlobal.getInstance().getGestor();
        contratoDAO = new ContratoDAO(gestorJDBC);
        periodoDAO = new PeriodoDAO(gestorJDBC);
        conceptoDAO = new ConceptoDAO(gestorJDBC);
    }
    
    public Periodo buscarPeriodoActivo() throws Exception{
        gestorJDBC.abrirConexion();        
        Periodo periodo = periodoDAO.buscarPeriodoActivo();
        gestorJDBC.cerrarConexion();
        return periodo;
    }

    public List<Pago> procesar(Periodo periodo) throws Exception {
        
        if(!periodo.esActivo()){
            throw new Exception("El periodo no esta activo.");
        }
        
        gestorJDBC.abrirConexion();
        
        List<Contrato> contratos = new ArrayList<>();
        contratos = contratoDAO.obtenerTodosLosContratos();
        
        List<Pago> pagos = new ArrayList<>();
        Pago pago;
        Concepto concepto;
        for(Contrato contrato : contratos){
            if(contrato.esVigente()){
                concepto = conceptoDAO.buscarConcepto(contrato.getContratoId(), periodo.getIdPeriodo());
                pago = new Pago();
                //Seteamos el periodo,concepto y el contrato para calcular las reglas de negocio
                pago.setContrato(contrato);
                pago.setPeriodo(periodo);
                pago.setConcepto(concepto);
                //Seteamos el valor por hora sacandolo del contrato
                double valorPorHora = contrato.getValorPorHora();
                pago.setValorHoras(valorPorHora);
                //Calculamos la asignacion familiar y la seteamos en el Pago
                double asignacionFamiliar = contrato.calcularAsignacionFamiliar();
                pago.setAsignacionFamiliar(asignacionFamiliar);
                //Seteamos el porcentaje del AFP sacandolo del AFP del Contrato 
                double porcentajeAFP = contrato.getAfp().getDescuento();
                pago.setPorcentajeAFP(porcentajeAFP);
                //Seteamos el total de horas al crear el pago
                int totalHoras = pago.calcularTotalHoras();
                pago.setTotalHoras(totalHoras);
                pagos.add(pago);
            }
        }
        //periodoDAO.procesarPeriodo(periodo.getPeriodo());
        gestorJDBC.cerrarConexion();
        return pagos;
    }
    
}
