/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia;

import Capa3_Dominio.Pago;
import Capa4_Persistencia.Gestores.GestorJDBC;
import Capa4_Persistencia.Interfaces.IPagoDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public class PagoDAO implements IPagoDAO{
    
    private GestorJDBC gestorJDBC;

    public PagoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Pago pago) throws SQLException {
         String sentenciaSQL = "INSERT "
                 + "INTO public.pagos("
                 + "pagoasignacionfamiliar, "
                 + "pagofecha, "
                 + "pagoporcentajeafp, "
                 + "pagototalhoras, "
                 + "pagovalorhoras, "
                 + "contratocodigo, "
                 + "periodocodigo, "
                 + "conceptocodigo)"
                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDouble(1, pago.getAsignacionFamiliar());
        sentencia.setDate(2, new Date(new java.util.Date().getTime()));
        sentencia.setDouble(3, pago.getPorcentajeAFP());
        sentencia.setDouble(4, pago.calcularTotalHoras());
        sentencia.setDouble(5, pago.getValorHoras());
        sentencia.setDouble(6, pago.getContrato().getContratoId());
        sentencia.setString(7, pago.getPeriodo().getIdPeriodo());
        sentencia.setInt(8, pago.getConcepto().getConceptoId());
        return sentencia.executeUpdate();
    }
    
}
