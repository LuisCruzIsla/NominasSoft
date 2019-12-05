/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.postgresql;

import Capa3_Dominio.Entidades.Periodo;
import Capa4_Persistencia.Gestor.GestorJDBC;
import Capa3_Dominio.Contratos.IPeriodo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public class PeriodoDAOPostgre implements IPeriodo{
    
    private GestorJDBC gestorJDBC;

    public PeriodoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public Periodo buscarPeriodoActivo() throws SQLException {
        Periodo periodo = null;
        ResultSet resultadoPeriodo;
        String sentenciaSQL;

        sentenciaSQL = "SELECT "
                + "PeriodoCodigo, "
                + "PeriodoFechaInicio, "
                + "PeriodoFechaFin, "
                + "PeriodoEstado "
                + "FROM Periodos "
                + "WHERE PeriodoEstado = 'E' ORDER BY PeriodoFechaInicio LIMIT 1";
        
        resultadoPeriodo = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadoPeriodo.next()){            
            periodo = new Periodo();
            periodo.setIdPeriodo(resultadoPeriodo.getString("PeriodoCodigo"));
            periodo.setFechaInicio(resultadoPeriodo.getDate("PeriodoFechaInicio"));
            periodo.setFechaFin(resultadoPeriodo.getDate("PeriodoFechaFin"));
            periodo.setEstado(resultadoPeriodo.getString("PeriodoEstado").charAt(0));
        }        
        resultadoPeriodo.close();
        return periodo;
    }

    @Override
    public int procesarPeriodo(String periodoID) throws SQLException {
        String sentenciaSQL = "UPDATE Periodos SET "
                + "PeriodoEstado = 'D' "
                + "WHERE PeriodoCodigo = '"+periodoID+"'";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        return sentencia.executeUpdate();
    }
    
}
