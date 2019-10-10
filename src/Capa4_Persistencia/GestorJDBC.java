package Capa4_Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fermin Eras
 */

public abstract class GestorJDBC {
       protected Connection conexion; 
       

    public void iniciarTransaccion() {
        try {
            conexion.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
       public void terminarTransaccion() {
        try {
            conexion.commit();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void cancelarTransaccion() {
        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
           
        public PreparedStatement prepararSentencia(String sql)  {
        try {
            return conexion.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
              return null;
        }
    }
        public ResultSet ejecutarConsulta(String sql) {
        try {
            Statement sentencia;
            ResultSet resultado;
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace(); 
             return null;
        }
    
    }
    
}

