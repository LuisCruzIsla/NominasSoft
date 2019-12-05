/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.Gestor.Fabrica;

import Capa4_Persistencia.Gestor.Gestores.GestorJDBC;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fermin Eras
 */

public class GestorJDBCPostgre extends GestorJDBC {
    
    public void abrirConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Nomina";
            conexion = DriverManager.getConnection(url, "postgres", "melacomes123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }
    
}
