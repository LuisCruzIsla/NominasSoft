package Capa4_Persistencia.Gestor;

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
    
    public abstract void abrirConexion() throws Exception;
    
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    
    public void iniciarTransaccion() throws SQLException{
        conexion.setAutoCommit(false);
    }
    
    public void terminarTransaccion() throws SQLException{
        conexion.commit();
        conexion.setAutoCommit(true);
        conexion.close();
    }
    
    public void cancelarTransaccion() throws SQLException{
        conexion.rollback();
        conexion.setAutoCommit(true);
        conexion.close();
    }
    
    public PreparedStatement prepararSentencia(String sql) throws SQLException{
        return conexion.prepareStatement(sql);
    }
    
    public ResultSet ejecutarConsulta(String sql) throws SQLException{
        Statement sentencia;
        ResultSet resultado;
        sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        return resultado;
    }
}

