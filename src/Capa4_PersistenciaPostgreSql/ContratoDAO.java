/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_PersistenciaPostgreSql;

import Capa3_Dominio.Contrato;
import Capa3_Dominio.Interfaces.IContratoDAO;
import Capa4_Persistencia.GestorJDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public class ContratoDAO implements IContratoDAO{
    
    private GestorJDBC gestorJDBC;

    public ContratoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Contrato contrato) throws SQLException {
        String sentenciaSQL = "insert into contratos("
                + "contratofechainicio, "
                + "contratofechafin, "
                + "contratoasignacionfamiliar, "
                + "contratototalhorassemanal, "
                + "contratovalorhoras, "
                + "contratocargo, "
                + "afpid, "
                + "empleadocodigo) "
                + "values(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDate(1, new Date(contrato.getFechaInicio().getTime()));
        sentencia.setDate(2, new Date(contrato.getFechaFin().getTime()));
        sentencia.setString(3, contrato.isAsignacionFamiliar() ? "T" : "F");
        sentencia.setInt(4, contrato.getTotalHorasSemanal());
        sentencia.setDouble(5, contrato.getValorPorHora());
        sentencia.setString(6, contrato.getCargo());
        sentencia.setInt(7, contrato.getAfp().getId());
        sentencia.setString(8, contrato.getEmpleado().getId());
        return sentencia.executeUpdate();
    }
    
}
