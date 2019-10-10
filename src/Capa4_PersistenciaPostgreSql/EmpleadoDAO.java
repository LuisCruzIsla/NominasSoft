/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_PersistenciaPostgreSql;

import Capa3_Dominio.Empleado;
import Capa3_Dominio.Interfaces.IEmpleadoDAO;
import Capa4_Persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */

public class EmpleadoDAO implements IEmpleadoDAO{
        GestorJDBC gestorJDBC;

    public EmpleadoDAO(GestorJDBC gestorJDBC) {
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
            empleado.setNombre(resultadoEmpleado.getString("empleadonombre"));
            empleado.setDni(resultadoEmpleado.getInt("empleadodni"));
            empleado.setDireccion(resultadoEmpleado.getString("empleadodireccion"));
            empleado.setTelefono(resultadoEmpleado.getInt("empleadotelefono"));
            empleado.setFechaNacimiento(resultadoEmpleado.getDate("empleadofechanacimiento"));
            empleado.setEstadoCivil(resultadoEmpleado.getString("empleadoestadocivil").charAt(0));
            empleado.setGradoAcademico(resultadoEmpleado.getString("empleadogradoacademico"));
        }        
        resultadoEmpleado.close();
        return empleado; 
    }
    
}