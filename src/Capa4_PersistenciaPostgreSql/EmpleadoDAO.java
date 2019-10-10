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
    public Empleado buscarPorDNI(String dni) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
