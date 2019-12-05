/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa2_Aplicacion;

import Capa3_Dominio.Contratos.*;
import Capa3_Dominio.Entidades.Concepto;
import Capa3_Dominio.Entidades.Contrato;
import Capa3_Dominio.Entidades.Pago;
import Capa3_Dominio.Entidades.Periodo;
import Capa4_Persistencia.Gestor.Fabrica.FabricaAdstractaDAO;
import Capa4_Persistencia.postgresql.ConceptoDAOPostgre;
import Capa4_Persistencia.postgresql.ContratoDAOPostgre;
import Capa4_Persistencia.Gestor.GestorJDBC;
import Capa4_Persistencia.postgresql.PagoDAOPostgre;
import Capa4_Persistencia.postgresql.PeriodoDAOPostgre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ProcesarPagoServicio {
    
    private GestorJDBC gestorJDBC;
    //private ContratoDAOPostgre contratoDAO;
    //private PeriodoDAOPostgre periodoDAO;
//    private ConceptoDAOPostgre conceptoDAO;
//    private PagoDAOPostgre pagoDAO;
    private IContratoDAO contratoDAO;
    private IPeriodo periodoDAO;
    private IConceptoDAO conceptoDAO;
    private IPagoDAO pagoDAO;
    
    
    
    public ProcesarPagoServicio(){
        FabricaAdstractaDAO fabricaAdstractaDAO= FabricaAdstractaDAO.getInstancia();
        gestorJDBC = fabricaAdstractaDAO.crearGestorJDBC();//GestorGlobal.getInstance().getGestor();
        contratoDAO = fabricaAdstractaDAO.crearIContratoDAO(gestorJDBC);
        periodoDAO = fabricaAdstractaDAO.crearIPeriodo(gestorJDBC);
        conceptoDAO = fabricaAdstractaDAO.crearIConceptoDAO(gestorJDBC);
        pagoDAO = fabricaAdstractaDAO.crearIPagoDAO(gestorJDBC);
    }
    
    public Periodo buscarPeriodoActivo() throws Exception{
        gestorJDBC.abrirConexion();        
        Periodo periodo = periodoDAO.buscarPeriodoActivo();
        gestorJDBC.cerrarConexion();
        //Flujo alternativo 1
        if(periodo==null){
            throw new Exception("No se puede procesar porque no existe periodo de pago activo");
        }
        return periodo;
    }

    public List<Pago> procesar(Periodo periodo) throws Exception {
        
        //FLujo alternativo 2
        if(!periodo.esActivo()){
            throw new Exception("No se puede procesar porque la fecha actual no corresponde a la fecha admitida para procesar pagos");
        }
        
        gestorJDBC.abrirConexion();
        
        List<Contrato> contratos = new ArrayList<>();
        contratos = contratoDAO.obtenerTodosLosContratos();
        
        //Flujo alternativo 3
        if(contratos.isEmpty()){
            throw new Exception("“No se puede procesar porque no existen contratos vigentes.");
        }
        
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
                double porcentajeAFP = contrato.getAfp().getPorcentajeDescuento();
                pago.setPorcentajeAFP(porcentajeAFP);
                //Seteamos el total de horas al crear el pago
                int totalHoras = pago.calcularTotalHoras();
                pago.setTotalHoras(totalHoras);
                pagos.add(pago);
                pagoDAO.ingresar(pago);
            }
        }
        periodoDAO.procesarPeriodo(periodo.getIdPeriodo());
        gestorJDBC.cerrarConexion();
        return pagos;
    }
    
}
