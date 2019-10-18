/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa2_Aplicacion;

import Capa3_Dominio.AFP;
import Capa3_Dominio.Contrato;
import Capa3_Dominio.Empleado;
import Capa4_Persistencia.Gestores.GestorJDBC;
import Capa4_Persistencia.AFPDAO;
import Capa4_Persistencia.ContratoDAO;
import Capa4_Persistencia.EmpleadoDAO;
import Capa4_Persistencia.Gestores.GestorGlobal;
import java.util.List;

/**
 *
 * @author user
 */
public class GestionarContratoServicio {
    
    private GestorJDBC gestorJDBC;
    private EmpleadoDAO empleadoDAO;
    private ContratoDAO contratoDAO;
    private AFPDAO afpDAO;
    
    public GestionarContratoServicio(){
        gestorJDBC = GestorGlobal.getInstance().getGestor();
        empleadoDAO = new EmpleadoDAO(gestorJDBC);
        contratoDAO = new ContratoDAO(gestorJDBC);
        afpDAO = new AFPDAO(gestorJDBC);
    }
    
    public Empleado buscarEmpleadoPorDNI(int DNI) throws Exception{
        gestorJDBC.abrirConexion();        
        Empleado empleado = empleadoDAO.buscarPorDNI(DNI);
        gestorJDBC.cerrarConexion();
        return empleado;
    }
    
    public List<AFP> obtenerListaAFP() throws Exception{
        gestorJDBC.abrirConexion();        
        List<AFP> listAFP = afpDAO.obtenerTodosLosAFP();
        gestorJDBC.cerrarConexion();
        return listAFP;
    }
    
    public int crearContrato(Contrato contrato) throws Exception{
        
        gestorJDBC.abrirConexion();
        Contrato contratoAnterior = contratoDAO.obtenerUltimoPorEmpleado(contrato.getEmpleado());
        
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
        
        int registros_afectados = contratoDAO.ingresar(contrato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
        
    }
    
    public int actualizarContrato(Contrato contrato) throws Exception{
        
        gestorJDBC.abrirConexion();
        Contrato contratoAntepenultimo = contratoDAO.obtenerAntepenultimoPorEmpleado(contrato.getEmpleado());
        
        if(contratoAntepenultimo!=null && !contratoAntepenultimo.esVigente()){
            throw new Exception("El contrato anterior aun es vigente");
        }
        
        if(!contrato.esRenovable(contratoAntepenultimo)){
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
        
        int registros_afectados = contratoDAO.actualizar(contrato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
        
    }
    
    public Contrato buscarContratoPorEmpleado(Empleado empleado) throws Exception{
        gestorJDBC.abrirConexion();        
        Contrato contrato = contratoDAO.obtenerUltimoPorEmpleado(empleado);
        gestorJDBC.cerrarConexion();
        return contrato;
    }

    public int anularContrato(Contrato contrato) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = contratoDAO.anular(contrato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
    
}
