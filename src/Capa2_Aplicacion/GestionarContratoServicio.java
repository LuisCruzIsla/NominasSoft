/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa2_Aplicacion;

import Capa3_Dominio.AFP;
import Capa3_Dominio.Contrato;
import Capa3_Dominio.Empleado;
import Capa4_Persistencia.GestorJDBC;
import Capa4_PersistenciaPostgreSql.AFPDAO;
import Capa4_PersistenciaPostgreSql.ContratoDAO;
import Capa4_PersistenciaPostgreSql.EmpleadoDAO;
import Capa4_PersistenciaPostgreSql.GestorJDBCPostgre;
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
        gestorJDBC = new GestorJDBCPostgre();
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
        
        if(!contrato.esVigente()){
            throw new Exception("La fecha fin debe ser mayor a la fecha actual y el contrato debe estar vigente.");
        }
        
        if(!contrato.esVigente()){
            throw new Exception("La fecha fin debe ser mayor a la fecha actual y el contrato debe estar vigente.");
        }
        
        gestorJDBC.abrirConexion();
        int registros_afectados = contratoDAO.ingresar(contrato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
    
}
