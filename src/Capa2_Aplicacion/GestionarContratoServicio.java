/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa2_Aplicacion;

import Capa3_Dominio.Empleado;
import Capa4_Persistencia.GestorJDBC;
import Capa4_PersistenciaPostgreSql.EmpleadoDAO;
import Capa4_PersistenciaPostgreSql.GestorJDBCPostgre;

/**
 *
 * @author user
 */
public class GestionarContratoServicio {
    
    private GestorJDBC gestorJDBC; 
    private EmpleadoDAO empleadoDAO;
    
    public GestionarContratoServicio(){
        gestorJDBC = new GestorJDBCPostgre();
        empleadoDAO = new EmpleadoDAO(gestorJDBC);
    }
    
    public Empleado buscarEmpleadoPorDNI(int DNI) throws Exception{
        gestorJDBC.abrirConexion();        
        Empleado empleado = empleadoDAO.buscarPorDNI(DNI);
        gestorJDBC.cerrarConexion();
        return empleado;
    }
    
}
