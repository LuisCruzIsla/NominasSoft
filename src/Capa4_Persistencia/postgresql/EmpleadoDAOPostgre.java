/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.postgresql;

import Capa3_Dominio.Enumerables.EGrados;
import Capa3_Dominio.Entidades.Empleado;
import Capa3_Dominio.Contratos.IEmpleadoDAO;
import Capa4_Persistencia.Gestor.GestorJDBC;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */

public class EmpleadoDAOPostgre implements IEmpleadoDAO{
        
    private GestorJDBC gestorJDBC;

    public EmpleadoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public Empleado buscarPorDNI(int dni) throws SQLException {
        Empleado empleado = null;
        ResultSet resultadoEmpleado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT "
                + "empleadocodigo, "
                + "empleadonombre, "
                + "empleadodni, "
                + "empleadodireccion, "
                + "empleadotelefono, "
                + "empleadofechanacimiento, "
                + "empleadoestadocivil, "
                + "empleadogradoacademico "
                + "FROM empleados "
                + "WHERE empleadodni = '"+dni+"'";
        
        resultadoEmpleado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadoEmpleado.next()){            
            empleado = new Empleado();
            empleado.setId(resultadoEmpleado.getString("empleadocodigo"));
            empleado.setNombre(resultadoEmpleado.getString("empleadonombre"));
            empleado.setDni(resultadoEmpleado.getInt("empleadodni"));
            empleado.setDireccion(resultadoEmpleado.getString("empleadodireccion"));
            empleado.setTelefono(resultadoEmpleado.getInt("empleadotelefono"));
            empleado.setFechaNacimiento(resultadoEmpleado.getDate("empleadofechanacimiento"));
            empleado.setEstadoCivil(resultadoEmpleado.getString("empleadoestadocivil").charAt(0));
            empleado.setGradoAcademico(EGrados.fromString(resultadoEmpleado.getString("empleadogradoacademico")));
        }        
        resultadoEmpleado.close();
        return empleado; 
    }

    @Override
    public Empleado buscarPorCodigo(String empleadoID) throws SQLException {
        Empleado empleado = null;
        ResultSet resultadoEmpleado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT "
                + "empleadocodigo, "
                + "empleadonombre, "
                + "empleadodni, "
                + "empleadodireccion, "
                + "empleadotelefono, "
                + "empleadofechanacimiento, "
                + "empleadoestadocivil, "
                + "empleadogradoacademico "
                + "FROM empleados "
                + "WHERE empleadocodigo = '"+empleadoID+"'";
        
        resultadoEmpleado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadoEmpleado.next()){            
            empleado = new Empleado();
            empleado.setId(resultadoEmpleado.getString("empleadocodigo"));
            empleado.setNombre(resultadoEmpleado.getString("empleadonombre"));
            empleado.setDni(resultadoEmpleado.getInt("empleadodni"));
            empleado.setDireccion(resultadoEmpleado.getString("empleadodireccion"));
            empleado.setTelefono(resultadoEmpleado.getInt("empleadotelefono"));
            empleado.setFechaNacimiento(resultadoEmpleado.getDate("empleadofechanacimiento"));
            empleado.setEstadoCivil(resultadoEmpleado.getString("empleadoestadocivil").charAt(0));
            empleado.setGradoAcademico(EGrados.fromString(resultadoEmpleado.getString("empleadogradoacademico")));
        }        
        resultadoEmpleado.close();
        return empleado;
    }
    
}