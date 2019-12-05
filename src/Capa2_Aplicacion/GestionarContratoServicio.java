/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa2_Aplicacion;

import Capa3_Dominio.Contratos.IAFPDAO;
import Capa3_Dominio.Contratos.IContratoDAO;
import Capa3_Dominio.Contratos.IEmpleadoDAO;
import Capa3_Dominio.Entidades.AFP;
import Capa3_Dominio.Entidades.Contrato;
import Capa3_Dominio.Entidades.Empleado;
import Capa3_Dominio.Servicios.ContratoServicio;
import Capa4_Persistencia.Gestor.Fabrica.FabricaAdstractaDAO;
import Capa4_Persistencia.Gestor.GestorJDBC;
import java.util.List;

/**
 *
 * @author user
 */
public class GestionarContratoServicio {
    
    private GestorJDBC gestorJDBC;
    //private EmpleadoDAOPostgre empleadoDAO;
    //private ContratoDAOPostgre contratoDAO;
    //private AFPDAOPostgre afpDAO;
    private IEmpleadoDAO empleadoDAO;
    private IContratoDAO contratoDAO;
    private IAFPDAO afpDAO;
    
    
    public GestionarContratoServicio(){
        FabricaAdstractaDAO fabricaAdstractaDAO= FabricaAdstractaDAO.getInstancia();
        gestorJDBC = fabricaAdstractaDAO.crearGestorJDBC();//GestorGlobal.getInstance().getGestor();
        empleadoDAO = fabricaAdstractaDAO.crearIEmpleadoDAO(gestorJDBC);//new EmpleadoDAOPostgre(gestorJDBC);
        contratoDAO = fabricaAdstractaDAO.crearIContratoDAO(gestorJDBC);//new ContratoDAOPostgre(gestorJDBC);
        afpDAO = fabricaAdstractaDAO.crearIAFPDAO(gestorJDBC); //new AFPDAOPostgre(gestorJDBC);
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
        Contrato contratoAnterior = contratoDAO.obtenerUltimoPorEmpleado(contrato.getEmpleado().getId());
     
        ContratoServicio contratoServicio = new ContratoServicio();
        contratoServicio.validarDatos(contrato, contratoAnterior);
        int registros_afectados = contratoDAO.ingresar(contrato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
        
    }
    
    public int actualizarContrato(Contrato contrato) throws Exception{
        
        gestorJDBC.abrirConexion();
        Contrato contratoAntepenultimo = contratoDAO.obtenerAntepenultimoPorEmpleado(contrato.getEmpleado().getId());
        
       ContratoServicio contratoServicio = new ContratoServicio();
        contratoServicio.validarDatos(contrato, contratoAntepenultimo);
        
        int registros_afectados = contratoDAO.actualizar(contrato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
        
    }
    
    public Contrato buscarContratoPorEmpleado(Empleado empleado) throws Exception{
        gestorJDBC.abrirConexion();        
        Contrato contrato = contratoDAO.obtenerUltimoPorEmpleado(empleado.getId());
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
