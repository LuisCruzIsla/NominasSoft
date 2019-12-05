/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.Gestor.Fabrica;

import Capa4_Persistencia.Gestor.GestorJDBC;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author COMPUTO-INGENIERIA
 */
public class GestorJDBCSQLite extends GestorJDBC {
    
    @Override
    public void abrirConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:sqlite:src/Capa4_Persistencia/sqlite/Database/NominaSoft.db";
            conexion = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }
    
}
