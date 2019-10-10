/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_PersistenciaPostgreSql;

import Capa4_Persistencia.GestorJDBC;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fermin Eras
 */

public class GestorJDBCPostgre extends GestorJDBC {
   
    public void abrirConexion() {
        try {
            Class.forName("org.sqlserver.Driver");
            String url = "jdbc:sqlserver://localhost:?/?";
            conexion = DriverManager.getConnection(url, "?", "?");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }
        
     
}
